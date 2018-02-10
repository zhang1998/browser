package com.uc.aerie.updater.a.a;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.b.c.f;
import com.tencent.tinker.b.c.i;
import com.tencent.tinker.b.c.j;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.uc.apollo.impl.SettingsConst;
import com.uc.apollo.media.MediaPlayer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: ProGuard */
final class a {
    static int a(String str, String str2, String str3, File file, boolean z) {
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str3, arrayList);
        if (arrayList.isEmpty()) {
            Log.w("DexDiffPatchInternal", "dex patch list is empty!");
            return 0;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            ZipFile zipFile2 = new ZipFile(file);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str4;
                ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                long currentTimeMillis = System.currentTimeMillis();
                if (shareDexDiffPatchInfo.path.equals("")) {
                    str4 = shareDexDiffPatchInfo.rawName;
                } else {
                    str4 = shareDexDiffPatchInfo.path + "/" + shareDexDiffPatchInfo.rawName;
                }
                Object obj = shareDexDiffPatchInfo.dexDiffMd5;
                CharSequence charSequence = shareDexDiffPatchInfo.oldDexCrC;
                if (ShareTinkerInternals.isVmArt() || !shareDexDiffPatchInfo.destMd5InDvm.equals(SettingsConst.FALSE) || z) {
                    String str5 = shareDexDiffPatchInfo.destMd5InArt;
                    if (SharePatchFileUtil.checkIfMd5Valid(str5)) {
                        File file3 = new File(str2, shareDexDiffPatchInfo.realName);
                        if (!file3.exists()) {
                            file3.getParentFile().mkdirs();
                        } else if (SharePatchFileUtil.verifyDexFileMd5(file3, str5)) {
                            Log.w("DexDiffPatchInternal", String.format("dex file %s is already exist, and md5 match, just continue", new Object[]{file3.getPath()}));
                        } else {
                            Log.w("DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath());
                            file3.delete();
                        }
                        ZipEntry entry = zipFile2.getEntry(str4);
                        ZipEntry entry2 = zipFile.getEntry(str4);
                        boolean equals = TextUtils.equals(charSequence, SettingsConst.FALSE);
                        boolean equals2 = TextUtils.equals(obj, SettingsConst.FALSE);
                        if (equals) {
                            if (entry == null) {
                                Log.w("DexDiffPatchInternal", "patch entry is null. path:" + str4);
                                return -102;
                            } else if (!a(zipFile2, entry, file3, shareDexDiffPatchInfo)) {
                                Log.w("DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath());
                                return -103;
                            }
                        } else if (equals2) {
                            if (ShareTinkerInternals.isVmArt() || z) {
                                if (entry2 == null) {
                                    Log.w("DexDiffPatchInternal", "apk entry is null. path:" + str4);
                                    return -104;
                                }
                                if (!String.valueOf(entry2.getCrc()).equals(charSequence)) {
                                    Log.e("DexDiffPatchInternal", String.format("apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str4, charSequence, String.valueOf(entry2.getCrc())}));
                                    return -105;
                                } else if (!a(zipFile, entry2, file3, shareDexDiffPatchInfo)) {
                                    Log.w("DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath());
                                    SharePatchFileUtil.safeDeleteFile(file3);
                                    return -106;
                                }
                            }
                        } else if (entry == null) {
                            Log.w("DexDiffPatchInternal", "patch entry is null. path:" + str4);
                            return -107;
                        } else if (!SharePatchFileUtil.checkIfMd5Valid(obj)) {
                            Log.w("DexDiffPatchInternal", String.format("meta file md5 invalid, dexFile:name: %s, md5: %s", new Object[]{shareDexDiffPatchInfo.rawName, obj}));
                            return -108;
                        } else if (entry2 == null) {
                            Log.w("DexDiffPatchInternal", "apk entry is null. path:" + str4);
                            return -109;
                        } else {
                            if (String.valueOf(entry2.getCrc()).equals(charSequence)) {
                                a(zipFile, zipFile2, entry2, entry, shareDexDiffPatchInfo, file3);
                                if (SharePatchFileUtil.verifyDexFileMd5(file3, str5)) {
                                    Log.w("DexDiffPatchInternal", String.format("success recover dex file: %s, size: %d, use time: %d", new Object[]{file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
                                } else {
                                    Log.w("DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath());
                                    SharePatchFileUtil.safeDeleteFile(file3);
                                    return -111;
                                }
                            }
                            Log.e("DexDiffPatchInternal", String.format("apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str4, charSequence, String.valueOf(entry2.getCrc())}));
                            return MediaPlayer.MEDIA_ERROR_TIMED_OUT;
                        }
                    }
                    Log.w("DexDiffPatchInternal", String.format("meta file md5 invalid, dexFile : %s, md5: %s", new Object[]{shareDexDiffPatchInfo.rawName, str5}));
                    return -101;
                }
                Log.w("DexDiffPatchInternal", String.format("patch dex %s is only for art, just continue", new Object[]{str4}));
            }
            if (arrayList.isEmpty() || arrayList.size() <= 1 || !ShareTinkerInternals.isVmArt() || a(arrayList, str2)) {
                return 0;
            }
            return -113;
        } catch (Throwable e) {
            Log.e("DexDiffPatchInternal", "patch dex fail.", e);
            return -112;
        }
    }

    private static boolean a(ArrayList<ShareDexDiffPatchInfo> arrayList, String str) {
        boolean z;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        File file = null;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2;
            File file2;
            ShareDexDiffPatchInfo shareDexDiffPatchInfo3 = (ShareDexDiffPatchInfo) it.next();
            File file3 = new File(str, shareDexDiffPatchInfo3.realName);
            if (ShareConstants.CLASS_N_PATTERN.matcher(shareDexDiffPatchInfo3.realName).matches()) {
                hashMap.put(shareDexDiffPatchInfo3, file3);
            }
            if (shareDexDiffPatchInfo3.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                File file4 = file3;
                shareDexDiffPatchInfo2 = shareDexDiffPatchInfo3;
                file2 = file4;
            } else {
                file2 = file;
                shareDexDiffPatchInfo2 = shareDexDiffPatchInfo;
            }
            file = file2;
            shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
        }
        if (shareDexDiffPatchInfo != null) {
            hashMap.put(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, hashMap.size() + 1), file);
        }
        if (hashMap.isEmpty()) {
            z = true;
        } else {
            boolean z2;
            File file5 = new File(str, ShareConstants.CLASS_N_APK_NAME);
            Closeable closeable = null;
            Closeable jVar;
            try {
                jVar = new j(new BufferedOutputStream(new FileOutputStream(file5)));
                InputStream a;
                try {
                    for (ShareDexDiffPatchInfo shareDexDiffPatchInfo32 : hashMap.keySet()) {
                        file3 = (File) hashMap.get(shareDexDiffPatchInfo32);
                        if (shareDexDiffPatchInfo32.isJarMode) {
                            i iVar = new i(file3);
                            f a2 = iVar.a(ShareConstants.DEX_IN_JAR);
                            f fVar = new f(a2, shareDexDiffPatchInfo32.rawName);
                            a = iVar.a(a2);
                            com.tencent.tinker.b.b.a.a(fVar, a, (j) jVar);
                            SharePatchFileUtil.closeQuietly(a);
                        } else {
                            com.tencent.tinker.b.b.a.a(new f(shareDexDiffPatchInfo32.rawName), file3, Long.parseLong(shareDexDiffPatchInfo32.newDexCrC), jVar);
                        }
                        SharePatchFileUtil.safeDeleteFile(file3);
                    }
                    SharePatchFileUtil.closeQuietly(jVar);
                    z2 = true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                jVar = null;
                SharePatchFileUtil.closeQuietly(jVar);
                throw th;
            }
            if (z2) {
                for (ShareDexDiffPatchInfo shareDexDiffPatchInfo322 : hashMap.keySet()) {
                    if (SharePatchFileUtil.verifyDexFileMd5(file5, shareDexDiffPatchInfo322.rawName, shareDexDiffPatchInfo322.destMd5InArt)) {
                        Log.e("DexDiffPatchInternal", String.format("verify dex file md5 error, entry name; %s, file len: %d", new Object[]{shareDexDiffPatchInfo322.rawName, Long.valueOf(file5.length())}));
                        z = false;
                        break;
                    }
                }
            }
            z = z2;
        }
        new StringBuilder("merge classN result:").append(z).append(", cost:").append(System.currentTimeMillis() - currentTimeMillis);
        return z;
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        int i = 0;
        while (i < 2 && !z) {
            Closeable bufferedInputStream;
            int i2 = i + 1;
            OutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            new StringBuilder("try Extracting ").append(file.getPath());
            try {
                Closeable zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[16384];
                        zipOutputStream.putNextEntry(new ZipEntry(ShareConstants.DEX_IN_JAR));
                        for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.closeEntry();
                        SharePatchFileUtil.closeQuietly(bufferedInputStream);
                        SharePatchFileUtil.closeQuietly(zipOutputStream);
                        z = SharePatchFileUtil.verifyDexFileMd5(file, str);
                        if (!z) {
                            file.delete();
                            if (file.exists()) {
                                Log.e("DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath());
                            }
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = zipOutputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                    closeable = zipOutputStream;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        }
        return z;
        SharePatchFileUtil.closeQuietly(bufferedInputStream);
        SharePatchFileUtil.closeQuietly(closeable);
        throw th;
    }

    private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) throws IOException {
        String str = shareDexDiffPatchInfo.destMd5InArt;
        String str2 = shareDexDiffPatchInfo.rawName;
        boolean z = shareDexDiffPatchInfo.isJarMode;
        if (SharePatchFileUtil.isRawDexFile(str2) && z) {
            return a(zipFile, zipEntry, file, str);
        }
        int i = 0;
        while (i < 2) {
            i++;
            if (com.uc.aerie.updater.b.a.a(zipFile, zipEntry, file)) {
                if (SharePatchFileUtil.verifyDexFileMd5(file, str)) {
                    return true;
                }
                file.delete();
            }
        }
        return false;
    }

    private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) throws IOException {
        InputStream bufferedInputStream;
        Throwable th;
        Closeable closeable;
        Closeable closeable2;
        OutputStream outputStream = null;
        try {
            InputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            if (zipEntry2 != null) {
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                } catch (Throwable th2) {
                    th = th2;
                    Object obj = bufferedInputStream2;
                    SharePatchFileUtil.closeQuietly(closeable);
                    SharePatchFileUtil.closeQuietly(closeable2);
                    throw th;
                }
            }
            Closeable closeable3 = null;
            try {
                boolean isRawDexFile = SharePatchFileUtil.isRawDexFile(shareDexDiffPatchInfo.rawName);
                if (!isRawDexFile || shareDexDiffPatchInfo.isJarMode) {
                    try {
                        Closeable zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(ShareConstants.DEX_IN_JAR));
                            if (isRawDexFile) {
                                new com.tencent.tinker.b.a.a(bufferedInputStream2, bufferedInputStream).a(zipOutputStream);
                            } else {
                                try {
                                    ZipEntry nextEntry;
                                    InputStream zipInputStream = new ZipInputStream(bufferedInputStream2);
                                    do {
                                        try {
                                            nextEntry = zipInputStream.getNextEntry();
                                            if (nextEntry == null) {
                                                break;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    } while (!ShareConstants.DEX_IN_JAR.equals(nextEntry.getName()));
                                    if (nextEntry == null) {
                                        throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                    }
                                    new com.tencent.tinker.b.a.a(zipInputStream, bufferedInputStream).a(zipOutputStream);
                                    SharePatchFileUtil.closeQuietly(zipInputStream);
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable = null;
                                    SharePatchFileUtil.closeQuietly(closeable);
                                    throw th;
                                }
                            }
                            zipOutputStream.closeEntry();
                            SharePatchFileUtil.closeQuietly(zipOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            closeable2 = zipOutputStream;
                            SharePatchFileUtil.closeQuietly(closeable2);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        SharePatchFileUtil.closeQuietly(closeable2);
                        throw th;
                    }
                }
                com.tencent.tinker.b.a.a aVar = new com.tencent.tinker.b.a.a(bufferedInputStream2, bufferedInputStream);
                try {
                    OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        aVar.a(bufferedOutputStream);
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        outputStream = bufferedOutputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
                SharePatchFileUtil.closeQuietly(bufferedInputStream2);
                SharePatchFileUtil.closeQuietly(bufferedInputStream);
            } catch (Throwable th9) {
                th = th9;
                closeable2 = bufferedInputStream;
                closeable = bufferedInputStream2;
            }
        } catch (Throwable th10) {
            th = th10;
            closeable = null;
            SharePatchFileUtil.closeQuietly(closeable);
            SharePatchFileUtil.closeQuietly(closeable2);
            throw th;
        }
    }
}
