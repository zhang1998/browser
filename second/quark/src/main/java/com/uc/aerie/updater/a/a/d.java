package com.uc.aerie.updater.a.a;

import android.util.Log;
import com.tencent.tinker.b.b.a;
import com.tencent.tinker.b.c.f;
import com.tencent.tinker.b.c.g;
import com.tencent.tinker.b.c.i;
import com.tencent.tinker.b.c.j;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public final class d {
    static int a(String str, String str2, String str3, File file) {
        j jVar;
        Throwable th;
        Throwable th2;
        i iVar;
        LargeModeInfo largeModeInfo;
        InputStream inputStream;
        Throwable th3;
        InputStream inputStream2;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.parseAllResPatchInfo(str, shareResPatchInfo);
        String.format("res dir: %s, meta: %s", new Object[]{str3, shareResPatchInfo.toString()});
        if (SharePatchFileUtil.checkIfMd5Valid(shareResPatchInfo.resArscMd5)) {
            File file2 = new File(str3);
            File file3 = new File(file2, ShareConstants.RES_NAME);
            if (!file3.exists()) {
                file3.getParentFile().mkdirs();
            } else if (SharePatchFileUtil.checkResourceArscMd5(file3, shareResPatchInfo.resArscMd5)) {
                Log.w("ResDiffPatchInternal", String.format("resource file %s is already exist, and md5 match, just return true", new Object[]{file3.getPath()}));
                return 0;
            } else {
                Log.w("ResDiffPatchInternal", "have a mismatch corrupted resource " + file3.getPath());
                file3.delete();
            }
            i iVar2;
            j jVar2;
            i iVar3;
            try {
                int a = a(str2, file2, file, shareResPatchInfo);
                if (a != 0) {
                    return a;
                }
                jVar = null;
                iVar2 = null;
                try {
                    jVar2 = new j(new BufferedOutputStream(new FileOutputStream(file3)));
                    try {
                        iVar3 = new i(str2);
                    } catch (Throwable th22) {
                        jVar = jVar2;
                        th = th22;
                        iVar = null;
                        if (jVar != null) {
                            jVar.close();
                        }
                        if (iVar2 != null) {
                            iVar2.close();
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        for (LargeModeInfo largeModeInfo2 : shareResPatchInfo.largeModMap.values()) {
                            SharePatchFileUtil.safeDeleteFile(largeModeInfo2.file);
                        }
                        throw th;
                    }
                    try {
                        iVar2 = new i(file);
                        iVar3.a();
                        Enumeration gVar = new g(iVar3, iVar3.a.values().iterator());
                        int i = 0;
                        while (gVar.hasMoreElements()) {
                            f fVar = (f) gVar.nextElement();
                            if (fVar == null) {
                                throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                            }
                            String str4 = fVar.a;
                            if (!str4.contains("../")) {
                                if (!ShareResPatchInfo.checkFileInPattern(shareResPatchInfo.patterns, str4) || shareResPatchInfo.deleteRes.contains(str4) || shareResPatchInfo.modRes.contains(str4) || shareResPatchInfo.largeModRes.contains(str4) || str4.equals(ShareConstants.RES_MANIFEST)) {
                                    a = i;
                                } else {
                                    a.a(iVar3, fVar, jVar2);
                                    a = i + 1;
                                }
                                i = a;
                            }
                        }
                        f a2 = iVar2.a("res/xml/manifest.xml");
                        if (a2 == null) {
                            Log.e("ResDiffPatchInternal", "new manifext.xml isn't exist.");
                            jVar2.close();
                            iVar3.close();
                            iVar2.close();
                            for (LargeModeInfo largeModeInfo22 : shareResPatchInfo.largeModMap.values()) {
                                SharePatchFileUtil.safeDeleteFile(largeModeInfo22.file);
                            }
                            return -420;
                        }
                        inputStream = null;
                        try {
                            String str5;
                            f a3;
                            inputStream = iVar2.a(a2);
                            a.a(new f(a2, ShareConstants.RES_MANIFEST), inputStream, jVar2);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            i++;
                            Iterator it = shareResPatchInfo.largeModRes.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                a3 = iVar3.a(str5);
                                if (a3 == null) {
                                    Log.w("ResDiffPatchInternal", "large patch entry is null. path:" + str5);
                                    jVar2.close();
                                    iVar3.close();
                                    iVar2.close();
                                    for (LargeModeInfo largeModeInfo222 : shareResPatchInfo.largeModMap.values()) {
                                        SharePatchFileUtil.safeDeleteFile(largeModeInfo222.file);
                                    }
                                    return -411;
                                }
                                largeModeInfo222 = (LargeModeInfo) shareResPatchInfo.largeModMap.get(str5);
                                a.a(a3, largeModeInfo222.file, largeModeInfo222.crc, jVar2);
                                i++;
                            }
                            it = shareResPatchInfo.addRes.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                a3 = iVar2.a(str5);
                                if (a3 == null) {
                                    Log.w("ResDiffPatchInternal", "add patch entry is null. path:" + str5);
                                    jVar2.close();
                                    iVar3.close();
                                    iVar2.close();
                                    for (LargeModeInfo largeModeInfo2222 : shareResPatchInfo.largeModMap.values()) {
                                        SharePatchFileUtil.safeDeleteFile(largeModeInfo2222.file);
                                    }
                                    return -412;
                                }
                                a.a(iVar2, a3, jVar2);
                                i++;
                            }
                            it = shareResPatchInfo.modRes.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                a3 = iVar2.a(str5);
                                if (a3 == null) {
                                    Log.w("ResDiffPatchInternal", "mod patch entry is null. path:" + str5);
                                    jVar2.close();
                                    iVar3.close();
                                    iVar2.close();
                                    for (LargeModeInfo largeModeInfo22222 : shareResPatchInfo.largeModMap.values()) {
                                        SharePatchFileUtil.safeDeleteFile(largeModeInfo22222.file);
                                    }
                                    return -413;
                                }
                                a.a(iVar2, a3, jVar2);
                                i++;
                            }
                            iVar3.a();
                            str5 = iVar3.b;
                            if (str5 == null) {
                                jVar2.b = j.a;
                            } else {
                                byte[] bytes = str5.getBytes(com.tencent.tinker.b.c.d.a);
                                j.a("Comment", bytes);
                                jVar2.b = bytes;
                            }
                            jVar2.close();
                            iVar3.close();
                            iVar2.close();
                            for (LargeModeInfo largeModeInfo222222 : shareResPatchInfo.largeModMap.values()) {
                                SharePatchFileUtil.safeDeleteFile(largeModeInfo222222.file);
                            }
                            if (SharePatchFileUtil.checkResourceArscMd5(file3, shareResPatchInfo.resArscMd5)) {
                                String.format("final new resource file:%s, entry count:%d, size:%d", new Object[]{file3.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file3.length())});
                                return 0;
                            }
                            String.format("check final new resource file fail path:%s, entry count:%d, size:%d", new Object[]{file3.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file3.length())});
                            SharePatchFileUtil.safeDeleteFile(file3);
                            return -414;
                        } catch (Throwable th4) {
                            th3 = th4;
                            inputStream2 = inputStream;
                            th22 = th3;
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            throw th22;
                        }
                    } catch (Throwable th222) {
                        iVar2 = iVar3;
                        jVar = jVar2;
                        th3 = th222;
                        iVar = null;
                        th4 = th3;
                        if (jVar != null) {
                            jVar.close();
                        }
                        if (iVar2 != null) {
                            iVar2.close();
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        while (r4.hasNext()) {
                            SharePatchFileUtil.safeDeleteFile(largeModeInfo222222.file);
                        }
                        throw th4;
                    }
                } catch (Throwable th2222) {
                    th3 = th2222;
                    iVar = null;
                    th4 = th3;
                    if (jVar != null) {
                        jVar.close();
                    }
                    if (iVar2 != null) {
                        iVar2.close();
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    while (r4.hasNext()) {
                        SharePatchFileUtil.safeDeleteFile(largeModeInfo222222.file);
                    }
                    throw th4;
                }
            } catch (Throwable th22222) {
                Log.e("ResDiffPatchInternal", "patch res extract exception.", th22222);
                return -415;
            }
        }
        Log.w("ResDiffPatchInternal", "resource meta file md5 mismatch, type:res, md5:" + shareResPatchInfo.resArscMd5);
        return -401;
    }

    private static int a(String str, File file, File file2, ShareResPatchInfo shareResPatchInfo) {
        Closeable closeable;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3;
        ZipFile zipFile4;
        try {
            zipFile3 = new ZipFile(str);
            try {
                Closeable closeable2;
                ZipEntry entry = zipFile3.getEntry(ShareConstants.RES_ARSC);
                if (entry != null) {
                    if (!String.valueOf(entry.getCrc()).equals(shareResPatchInfo.arscBaseCrc)) {
                        Log.e("ResDiffPatchInternal", String.format("resources.arsc's crc is not equal, expect crc: %s, got crc: %s", new Object[]{shareResPatchInfo.arscBaseCrc, String.valueOf(entry.getCrc())}));
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(null);
                        return -403;
                    }
                }
                if (shareResPatchInfo.largeModRes.isEmpty()) {
                    SharePatchFileUtil.closeZip(zipFile3);
                    SharePatchFileUtil.closeZip(null);
                    return 0;
                }
                Iterator it = shareResPatchInfo.largeModRes.iterator();
                zipFile = null;
                while (it.hasNext()) {
                    try {
                        String str2 = (String) it.next();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.largeModMap.get(str2);
                        if (largeModeInfo == null) {
                            Log.w("ResDiffPatchInternal", "resource not found largeModeInfo, type:res, name:" + str2);
                            SharePatchFileUtil.closeZip(zipFile3);
                            SharePatchFileUtil.closeZip(zipFile);
                            return -404;
                        }
                        largeModeInfo.file = new File(file, str2);
                        SharePatchFileUtil.ensureFileDirectory(largeModeInfo.file);
                        if (SharePatchFileUtil.checkIfMd5Valid(largeModeInfo.md5)) {
                            zipFile4 = new ZipFile(file2);
                            try {
                                ZipEntry entry2 = zipFile4.getEntry(str2);
                                if (entry2 == null) {
                                    Log.w("ResDiffPatchInternal", "large mod patch entry is null. path:" + str2);
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    return -406;
                                }
                                ZipEntry entry3 = zipFile3.getEntry(str2);
                                if (entry3 == null) {
                                    Log.w("ResDiffPatchInternal", "resources apk entry is null. path:" + str2);
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    return -407;
                                }
                                Closeable closeable3 = null;
                                closeable = null;
                                try {
                                    closeable3 = zipFile3.getInputStream(entry3);
                                    try {
                                        closeable = zipFile4.getInputStream(entry2);
                                        try {
                                            com.tencent.tinker.a.a.a(closeable3, closeable, largeModeInfo.file);
                                            SharePatchFileUtil.closeQuietly(closeable3);
                                            SharePatchFileUtil.closeQuietly(closeable);
                                            if (SharePatchFileUtil.verifyFileMd5(largeModeInfo.file, largeModeInfo.md5)) {
                                                Log.w("ResDiffPatchInternal", String.format("success recover large modify file:%s, file size:%d, use time:%d", new Object[]{largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)}));
                                                zipFile = zipFile4;
                                            } else {
                                                Log.w("ResDiffPatchInternal", "Failed to recover large modify file:" + largeModeInfo.file.getPath());
                                                SharePatchFileUtil.safeDeleteFile(largeModeInfo.file);
                                                SharePatchFileUtil.closeZip(zipFile3);
                                                SharePatchFileUtil.closeZip(zipFile4);
                                                return -408;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            closeable2 = closeable;
                                            closeable = closeable3;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        closeable2 = closeable;
                                        closeable = closeable3;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable2 = closeable;
                                    closeable = closeable3;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            Log.w("ResDiffPatchInternal", String.format("resource meta file md5 mismatch, type:res, name: %s, md5: %s", new Object[]{str2, largeModeInfo.md5}));
                            SharePatchFileUtil.closeZip(zipFile3);
                            SharePatchFileUtil.closeZip(zipFile);
                            return -405;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        zipFile4 = zipFile;
                    }
                }
                Log.w("ResDiffPatchInternal", "success recover all large modify use time:" + (System.currentTimeMillis() - currentTimeMillis));
                SharePatchFileUtil.closeZip(zipFile3);
                SharePatchFileUtil.closeZip(zipFile);
                return 0;
                SharePatchFileUtil.closeQuietly(closeable);
                SharePatchFileUtil.closeQuietly(closeable2);
                throw th;
            } catch (Throwable th7) {
                th = th7;
                zipFile4 = null;
                SharePatchFileUtil.closeZip(zipFile3);
                SharePatchFileUtil.closeZip(zipFile4);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.closeZip(zipFile3);
            SharePatchFileUtil.closeZip(zipFile4);
            throw th;
        }
    }
}
