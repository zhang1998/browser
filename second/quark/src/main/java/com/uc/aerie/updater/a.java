package com.uc.aerie.updater;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.uc.aerie.loader.AerieLoaderContext;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public final class a {
    @SuppressLint({"StaticFieldLeak"})
    private static a c = null;
    public k a;
    private Context b;
    private l d;

    public static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("args is force required.");
        } else if (c == null) {
            c = new a(context, new k(context), new l());
        }
    }

    public static a a() {
        if (c != null) {
            return c;
        }
        throw new RuntimeException("must init before get instance.");
    }

    private a(Context context, k kVar, l lVar) {
        this.b = context;
        this.a = kVar;
        this.d = lVar;
    }

    public final g a(File file) throws d, h {
        File file2 = null;
        String str = this.b.getFilesDir() + File.separator + "aerie_updater_temp";
        File file3 = new File(str, file.getName());
        g gVar = new g();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (ShareTinkerInternals.isVmJit()) {
                throw new h("filter patch on VmJit", 109);
            }
            SharePatchFileUtil.copyFileUsingStream(file, file3);
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("update.json");
            if (entry == null) {
                throw new h("patch miss updateJson entry", 103);
            }
            File file4 = new File(str, "update.json");
            if (a(zipFile, entry, file4)) {
                j a = j.a(file4);
                if (a == null) {
                    throw new h("parse update.json fail.", 106);
                }
                if (a.a.contains(AerieLoaderContext.getLoadDv())) {
                    CharSequence charSequence;
                    k kVar = this.a;
                    SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(new File(kVar.a, ShareConstants.PATCH_INFO_NAME), new File(kVar.a, ShareConstants.PATCH_INFO_LOCK_NAME));
                    if (readAndCheckPropertyWithLock != null) {
                        charSequence = readAndCheckPropertyWithLock.updateVersion;
                    } else {
                        charSequence = null;
                    }
                    if (TextUtils.equals(charSequence, a.b)) {
                        throw new h("update version has updated.", SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED);
                    }
                    int a2;
                    HashMap hashMap = new HashMap();
                    Map hashMap2 = new HashMap();
                    if (!a.c.isEmpty()) {
                        File file5 = new File(str, "modulesOut");
                        file5.mkdirs();
                        k kVar2 = this.a;
                        f fVar = new f(this.b, this.d, zipFile, a, new File(kVar2.a + File.separator + a.b), file5);
                        fVar.a();
                        hashMap = fVar.a;
                        hashMap2 = fVar.b;
                        file2 = (File) hashMap.remove("master");
                    }
                    if (!hashMap.isEmpty()) {
                        ZipEntry entry2 = zipFile.getEntry("module_info.json");
                        if (entry2 == null) {
                            throw new h("patch miss module_info entry", 104);
                        } else if (!a(zipFile, entry2, new File(str, "module_info.json"))) {
                            throw new h("unzip module_info from patch fail.", 110);
                        }
                    }
                    gVar.c = SystemClock.elapsedRealtime() - SystemClock.elapsedRealtime();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (file2 != null) {
                        a2 = this.a.a(file2, a.b);
                    } else {
                        a2 = this.a.a(null, a.b);
                    }
                    if (a2 != 0) {
                        kVar = this.a;
                        SharePatchFileUtil.deleteDir(kVar.a + File.separator + a.b);
                        file4 = new File(kVar.a, ShareConstants.PATCH_INFO_NAME);
                        File file6 = new File(kVar.a, ShareConstants.PATCH_INFO_LOCK_NAME);
                        readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(file4, file6);
                        if (readAndCheckPropertyWithLock != null) {
                            readAndCheckPropertyWithLock.updateVersion = "";
                            readAndCheckPropertyWithLock.updateVersionFileName = "";
                            SharePatchInfo.rewritePatchInfoFileWithLock(file4, readAndCheckPropertyWithLock, file6);
                        }
                        throw new h("update master fail.", a2);
                    }
                    gVar.b = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    gVar.a = SystemClock.elapsedRealtime() - elapsedRealtime;
                    gVar.d.putAll(hashMap2);
                    SharePatchFileUtil.deleteDir(str);
                    return gVar;
                }
                throw new h(String.format("mismatch version, current:%s, deploy receivers:%s", new Object[]{AerieLoaderContext.getLoadDv(), a.a.toString()}), 107);
            }
            throw new h("unzip update.json from patch fail.", 105);
        } catch (Throwable e) {
            throw new h("copy package fail.", 101, e);
        } catch (Throwable th) {
            SharePatchFileUtil.deleteDir(str);
        }
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        boolean z = false;
        int i = 0;
        while (i < 3 && !z) {
            i++;
            z = com.uc.aerie.updater.b.a.a(zipFile, zipEntry, file);
        }
        return z;
    }
}
