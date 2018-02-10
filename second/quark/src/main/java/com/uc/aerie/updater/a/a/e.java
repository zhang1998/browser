package com.uc.aerie.updater.a.a;

import android.os.Build.VERSION;
import android.system.Os;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.uc.aerie.updater.b.a;
import com.uc.apollo.impl.SettingsConst;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
final class e {
    static int a(String str, String str2, String str3, String str4, File file, String str5) {
        Throwable th;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ShareBsDiffPatchInfo.parseDiffPatchInfo(str2, arrayList, arrayList2);
        if (arrayList.isEmpty()) {
            Log.w("SoDiffPatchInternal", "extract library patch list is empty!");
            return 0;
        }
        File file2 = new File(str4);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3;
        ZipFile zipFile4;
        try {
            zipFile3 = new ZipFile(str3);
            try {
                zipFile4 = new ZipFile(file);
                Closeable closeable;
                Closeable closeable2;
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str6;
                        ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (shareBsDiffPatchInfo.path.equals("")) {
                            str6 = shareBsDiffPatchInfo.name;
                        } else {
                            str6 = shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name;
                        }
                        String str7 = shareBsDiffPatchInfo.md5;
                        if (SharePatchFileUtil.checkIfMd5Valid(str7)) {
                            File file3 = new File(str4 + "/" + (shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name));
                            if (!file3.exists()) {
                                file3.getParentFile().mkdirs();
                            } else if (str7.equals(SharePatchFileUtil.getMD5(file3))) {
                                Log.w("SoDiffPatchInternal", String.format("bsdiff file %s is already exist, and md5 match, just continue", new Object[]{file3.getPath()}));
                            } else {
                                Log.w("SoDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath());
                                file3.delete();
                            }
                            String str8 = shareBsDiffPatchInfo.patchMd5;
                            ZipEntry entry = zipFile4.getEntry(str6);
                            if (entry == null) {
                                Log.w("SoDiffPatchInternal", "patch entry is null. path:" + str6);
                                SharePatchFileUtil.closeZip(zipFile3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                return -302;
                            } else if (str8.equals(SettingsConst.FALSE)) {
                                int i = 0;
                                Object obj = null;
                                while (i < 2) {
                                    i++;
                                    if (a.a(zipFile4, entry, file3)) {
                                        if (SharePatchFileUtil.verifyFileMd5(file3, str7)) {
                                            obj = 1;
                                            break;
                                        }
                                        file3.delete();
                                    }
                                }
                                if (obj == null) {
                                    Log.w("SoDiffPatchInternal", "Failed to extract file " + file3.getPath());
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    return -303;
                                }
                            } else if (SharePatchFileUtil.checkIfMd5Valid(str8)) {
                                ZipEntry entry2 = zipFile3.getEntry(str6);
                                if (entry2 == null) {
                                    Log.w("SoDiffPatchInternal", "apk entry is null. path:" + str6);
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    return -305;
                                }
                                if (String.valueOf(entry2.getCrc()).equals(shareBsDiffPatchInfo.rawCrc)) {
                                    closeable = null;
                                    closeable2 = null;
                                    closeable = zipFile3.getInputStream(entry2);
                                    closeable2 = zipFile4.getInputStream(entry);
                                    com.tencent.tinker.a.a.a(closeable, closeable2, file3);
                                    SharePatchFileUtil.closeQuietly(closeable);
                                    SharePatchFileUtil.closeQuietly(closeable2);
                                    if (SharePatchFileUtil.verifyFileMd5(file3, str7)) {
                                        Log.w("SoDiffPatchInternal", String.format("success recover bsdiff file: %s, use time: %d", new Object[]{file3.getPath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
                                    } else {
                                        Log.w("SoDiffPatchInternal", "Failed to recover diff file " + file3.getPath());
                                        SharePatchFileUtil.safeDeleteFile(file3);
                                        SharePatchFileUtil.closeZip(zipFile3);
                                        SharePatchFileUtil.closeZip(zipFile4);
                                        return -307;
                                    }
                                }
                                Log.e("SoDiffPatchInternal", String.format("apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str6, shareBsDiffPatchInfo.rawCrc, String.valueOf(entry2.getCrc())}));
                                SharePatchFileUtil.closeZip(zipFile3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                return -306;
                            } else {
                                Log.w("SoDiffPatchInternal", String.format("meta file md5 mismatch, type:library, name: %s, md5: %s", new Object[]{shareBsDiffPatchInfo.name, str8}));
                                SharePatchFileUtil.closeZip(zipFile3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                return -304;
                            }
                        }
                        Log.w("SoDiffPatchInternal", String.format("meta file md5 mismatch, type:library, name: %s, md5: %s", new Object[]{shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.md5}));
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(zipFile4);
                        return -301;
                    }
                    SharePatchFileUtil.closeZip(zipFile3);
                    SharePatchFileUtil.closeZip(zipFile4);
                    file2 = new File(str4 + "/lib", str5);
                    if (file2.exists() && file2.isDirectory() && file2.listFiles().length > 0 && !arrayList2.contains(ShareConstants.IGNORE_ALL_SYMBOLIC)) {
                        for (File name : file2.listFiles()) {
                            arrayList2.add(name.getName());
                        }
                        int a = a(str, file2.getAbsolutePath(), arrayList2);
                        if (a != 0) {
                            return a;
                        }
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile4 = null;
                SharePatchFileUtil.closeZip(zipFile3);
                SharePatchFileUtil.closeZip(zipFile4);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.closeZip(zipFile3);
            SharePatchFileUtil.closeZip(zipFile4);
            throw th;
        }
    }

    private static int a(String str, String str2, ArrayList<String> arrayList) {
        Process exec;
        Closeable dataOutputStream;
        Throwable e;
        File file;
        Process process = null;
        File file2 = new File(str);
        if (file2.exists()) {
            int i;
            List<File> arrayList2 = new ArrayList();
            for (File file3 : file2.listFiles()) {
                if (!arrayList.contains(file3.getName())) {
                    arrayList2.add(file3);
                }
            }
            if (arrayList2.isEmpty()) {
                return 0;
            }
            if (VERSION.SDK_INT >= 21) {
                for (File file22 : arrayList2) {
                    try {
                        Os.symlink(file22.getAbsolutePath(), str2 + File.separator + file22.getName());
                    } catch (Throwable e2) {
                        Log.e("SoDiffPatchInternal", "symlink exception.", e2);
                        try {
                            SharePatchFileUtil.copyFileUsingStream(file22, new File(str2 + File.separator + file22.getName()));
                        } catch (IOException e3) {
                            Log.e("SoDiffPatchInternal", "copy " + file22.getName() + "failed.");
                            return -310;
                        }
                    }
                }
            }
            Object obj;
            try {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(null);
                Method method = obj2.getClass().getMethod("symlink", new Class[]{String.class, String.class});
                for (File file222 : arrayList2) {
                    method.invoke(obj2, new Object[]{file222.getAbsolutePath(), str2 + File.separator + file222.getName()});
                }
                i = 1;
            } catch (Exception e4) {
                Log.e("SoDiffPatchInternal", "reflect libcore.io.Libcore symlink fail.");
                obj = null;
            }
            if (obj == null && (new File("/system/bin/ln").exists() || new File("/system/xbin/ln").exists() || new File("/sbin/ln").exists() || new File("/vendor/bin/ln").exists())) {
                try {
                    exec = Runtime.getRuntime().exec("sh");
                    try {
                        dataOutputStream = new DataOutputStream(exec.getOutputStream());
                    } catch (Exception e5) {
                        e = e5;
                        dataOutputStream = null;
                        process = exec;
                        try {
                            Log.e("SoDiffPatchInternal", "symlink exception.", e);
                            if (process != null) {
                                process.destroy();
                            }
                            SharePatchFileUtil.closeQuietly(dataOutputStream);
                            for (File file2222 : arrayList2) {
                                file = new File(str2, file2222.getName());
                                if (file.exists()) {
                                    try {
                                        SharePatchFileUtil.copyFileUsingStream(file2222, file);
                                    } catch (Throwable e6) {
                                        Log.e("SoDiffPatchInternal", "copy " + file2222.getName() + " exception.", e6);
                                        return -311;
                                    }
                                }
                            }
                            for (File file22222 : arrayList2) {
                                file = new File(str2, file22222.getName());
                                if (!file.exists()) {
                                    if (file22222.lastModified() != file.lastModified()) {
                                    }
                                }
                                return -312;
                            }
                            return 0;
                        } catch (Throwable th) {
                            e = th;
                            exec = process;
                            if (exec != null) {
                                exec.destroy();
                            }
                            SharePatchFileUtil.closeQuietly(dataOutputStream);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        dataOutputStream = null;
                        if (exec != null) {
                            exec.destroy();
                        }
                        SharePatchFileUtil.closeQuietly(dataOutputStream);
                        throw e;
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                        for (File file222222 : arrayList2) {
                            if (!new File(str2 + File.separator + file222222.getName()).exists()) {
                                dataOutputStream.writeBytes(String.format("ln -s %s %s", new Object[]{((File) r6.next()).getAbsolutePath(), str2 + File.separator + ((File) r6.next()).getName()}));
                                dataOutputStream.writeBytes("\n");
                                dataOutputStream.flush();
                                do {
                                } while (bufferedReader.readLine() != null);
                            }
                        }
                        dataOutputStream.writeBytes("exit\n");
                        dataOutputStream.flush();
                        exec.waitFor();
                        if (exec != null) {
                            exec.destroy();
                        }
                        SharePatchFileUtil.closeQuietly(dataOutputStream);
                    } catch (Exception e7) {
                        e = e7;
                        process = exec;
                        Log.e("SoDiffPatchInternal", "symlink exception.", e);
                        if (process != null) {
                            process.destroy();
                        }
                        SharePatchFileUtil.closeQuietly(dataOutputStream);
                        for (File file2222222 : arrayList2) {
                            file = new File(str2, file2222222.getName());
                            if (file.exists()) {
                                SharePatchFileUtil.copyFileUsingStream(file2222222, file);
                            }
                        }
                        for (File file22222222 : arrayList2) {
                            file = new File(str2, file22222222.getName());
                            if (!file.exists()) {
                                if (file22222222.lastModified() != file.lastModified()) {
                                }
                            }
                            return -312;
                        }
                        return 0;
                    } catch (Throwable th3) {
                        e = th3;
                        if (exec != null) {
                            exec.destroy();
                        }
                        SharePatchFileUtil.closeQuietly(dataOutputStream);
                        throw e;
                    }
                } catch (Exception e8) {
                    e = e8;
                    dataOutputStream = null;
                    Log.e("SoDiffPatchInternal", "symlink exception.", e);
                    if (process != null) {
                        process.destroy();
                    }
                    SharePatchFileUtil.closeQuietly(dataOutputStream);
                    for (File file222222222 : arrayList2) {
                        file = new File(str2, file222222222.getName());
                        if (file.exists()) {
                            SharePatchFileUtil.copyFileUsingStream(file222222222, file);
                        }
                    }
                    for (File file2222222222 : arrayList2) {
                        file = new File(str2, file2222222222.getName());
                        if (!file.exists()) {
                            if (file2222222222.lastModified() != file.lastModified()) {
                            }
                        }
                        return -312;
                    }
                    return 0;
                } catch (Throwable th4) {
                    e = th4;
                    dataOutputStream = null;
                    exec = null;
                    if (exec != null) {
                        exec.destroy();
                    }
                    SharePatchFileUtil.closeQuietly(dataOutputStream);
                    throw e;
                }
            }
            for (File file22222222222 : arrayList2) {
                file = new File(str2, file22222222222.getName());
                if (file.exists()) {
                    SharePatchFileUtil.copyFileUsingStream(file22222222222, file);
                }
            }
            for (File file222222222222 : arrayList2) {
                file = new File(str2, file222222222222.getName());
                if (!file.exists()) {
                    if (file222222222222.lastModified() != file.lastModified()) {
                    }
                }
                return -312;
            }
            return 0;
        }
        Log.e("SoDiffPatchInternal", "appLibDir not exist!");
        return -309;
    }
}
