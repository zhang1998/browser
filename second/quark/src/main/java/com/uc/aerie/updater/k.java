package com.uc.aerie.updater;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.uc.aerie.updater.b.a;
import com.uc.aerie.updater.b.b;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public final class k {
    String a;
    private Context b;

    k(Context context) {
        this.a = SharePatchFileUtil.getRootDirectory(context);
        this.b = context;
    }

    final int a(File file, String str) {
        SharePatchInfo sharePatchInfo;
        File file2 = new File(this.a, ShareConstants.PATCH_INFO_NAME);
        File file3 = new File(this.a, ShareConstants.PATCH_INFO_LOCK_NAME);
        SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(file2, file3);
        if (readAndCheckPropertyWithLock == null) {
            sharePatchInfo = new SharePatchInfo(Build.FINGERPRINT);
        } else {
            sharePatchInfo = readAndCheckPropertyWithLock;
        }
        sharePatchInfo.updateVersion = str;
        if (file == null) {
            sharePatchInfo.updateVersionFileName = sharePatchInfo.currentVersionFileName;
        } else {
            sharePatchInfo.updateVersionFileName = file.getName();
            File file4 = new File(file, ShareConstants.META_FILES_DIR);
            file4.mkdirs();
            try {
                ZipFile zipFile = new ZipFile(file.getAbsoluteFile() + File.separator + str + ShareConstants.PATCH_SUFFIX);
                Enumeration entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (zipEntry != null) {
                        String name = zipEntry.getName();
                        if (!name.startsWith("META-INF/") && name.endsWith(ShareConstants.META_SUFFIX)) {
                            name = zipEntry.getName();
                            if (!a.a(zipFile, zipEntry, new File(file4, name.substring(name.lastIndexOf("/"), name.length())))) {
                                Log.e("UpdateMasterManager", "extract meta file fail. name:" + zipEntry.getName());
                                return SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e("UpdateMasterManager", "extract meta File exception." + th);
                return SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE_DATA;
            }
        }
        if (!b()) {
            return SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED;
        }
        if (SharePatchInfo.rewritePatchInfoFileWithLock(file2, sharePatchInfo, file3)) {
            return 0;
        }
        Log.e("UpdateMasterManager", "update patchInfo fail.");
        if (file != null) {
            SharePatchFileUtil.deleteDir(file);
        }
        return 202;
    }

    public final boolean a() {
        File file = new File(this.a, ShareConstants.ROLLBACK_TO_BASE_FLAG_FILE);
        if (file.getParentFile().exists() && !file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                Log.e("UpdateMasterManager", "create rollback file flag fail.", e);
                return false;
            }
        }
        return true;
    }

    private boolean b() {
        boolean z = false;
        File file = new File(this.a);
        if (!file.exists() || !file.isDirectory()) {
            return z;
        }
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        for (int i = z; i < length; i++) {
            if (listFiles[i].getName().endsWith(ShareConstants.CPU_ABI_SUFFIX)) {
                return true;
            }
        }
        Object a = b.a(this.b);
        if (TextUtils.isEmpty(a)) {
            return z;
        }
        String str = a + ShareConstants.CPU_ABI_SUFFIX;
        try {
            return new File(this.a, str).createNewFile();
        } catch (IOException e) {
            Log.e("UpdateMasterManager", "create cpuAbiFlagFile fail. " + str);
            return z;
        }
    }
}
