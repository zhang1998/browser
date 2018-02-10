package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public class SharePatchFileUtil {
    private static final String TAG = "Tinker.PatchFileUtil";

    public static String getRootDirectory(Context context) {
        return context.getApplicationInfo().dataDir + File.separator + ShareConstants.PATCH_DIRECTORY_NAME;
    }

    public static boolean checkIfMd5Valid(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static final boolean isLegalFile(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static boolean getExtractMetaInfo(File file, HashMap<String, String> hashMap) {
        Throwable e;
        for (File file2 : file.listFiles()) {
            Closeable bufferedInputStream;
            if (!TextUtils.isEmpty(file2.getName()) && file2.getName().endsWith(ShareConstants.META_SUFFIX)) {
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    byte[] bArr = new byte[16384];
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            stringBuilder.append(new String(bArr, 0, read));
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    closeQuietly(bufferedInputStream);
                    hashMap.put(file2.getName(), stringBuilder.toString());
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = null;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedInputStream = null;
                }
            }
        }
        return true;
        try {
            Log.e(TAG, "getMetaInfo exception.", e);
            closeQuietly(bufferedInputStream);
            return false;
        } catch (Throwable th3) {
            th2 = th3;
            closeQuietly(bufferedInputStream);
            throw th2;
        }
    }

    public static boolean verifyPackage(Context context, File file) {
        Throwable e;
        if (!isLegalFile(file)) {
            return false;
        }
        JarFile jarFile = null;
        JarFile jarFile2;
        try {
            jarFile2 = new JarFile(file);
            try {
                Enumeration entries = jarFile2.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (!(jarEntry == null || jarEntry.isDirectory() || jarEntry.getName().startsWith("META-INF/"))) {
                        loadDigestesDrain(jarFile2, jarEntry);
                        Certificate[] certificates = jarEntry.getCertificates();
                        if (certificates == null) {
                            try {
                                jarFile2.close();
                            } catch (Throwable e2) {
                                Log.e(TAG, file.getAbsolutePath(), e2);
                            }
                            return false;
                        } else if (!ShareSignatureCheck.check(context, file, certificates)) {
                            try {
                                jarFile2.close();
                            } catch (Throwable e22) {
                                Log.e(TAG, file.getAbsolutePath(), e22);
                            }
                            return false;
                        }
                    }
                }
                try {
                    jarFile2.close();
                } catch (Throwable e222) {
                    Log.e(TAG, file.getAbsolutePath(), e222);
                }
                return true;
            } catch (Exception e3) {
                jarFile = jarFile2;
            } catch (Throwable th) {
                e222 = th;
            }
        } catch (Exception e4) {
            try {
                throw new RuntimeException("verify package signature fail.");
            } catch (Throwable th2) {
                jarFile2 = jarFile;
                e222 = th2;
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (Throwable th22) {
                        Log.e(TAG, file.getAbsolutePath(), th22);
                    }
                }
                throw e222;
            }
        } catch (Throwable th222) {
            jarFile2 = null;
            e222 = th222;
            if (jarFile2 != null) {
                jarFile2.close();
            }
            throw e222;
        }
    }

    public static boolean verifyAndGetPatchMetaInfo(Context context, File file, HashMap<String, String> hashMap) {
        JarFile jarFile;
        Throwable e;
        JarFile jarFile2;
        if (!isLegalFile(file)) {
            return false;
        }
        try {
            jarFile = new JarFile(file);
            try {
                Enumeration entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (jarEntry != null) {
                        String name = jarEntry.getName();
                        if (!name.startsWith("META-INF/") && name.endsWith(ShareConstants.META_SUFFIX)) {
                            hashMap.put(name, loadDigestes(jarFile, jarEntry));
                            Certificate[] certificates = jarEntry.getCertificates();
                            if (certificates == null) {
                                try {
                                    jarFile.close();
                                } catch (Throwable e2) {
                                    Log.e(TAG, file.getAbsolutePath(), e2);
                                }
                                return false;
                            } else if (!ShareSignatureCheck.check(context, file, certificates)) {
                                try {
                                    jarFile.close();
                                } catch (Throwable e22) {
                                    Log.e(TAG, file.getAbsolutePath(), e22);
                                }
                                return false;
                            }
                        }
                    }
                }
                try {
                    jarFile.close();
                } catch (Throwable e222) {
                    Log.e(TAG, file.getAbsolutePath(), e222);
                }
                return true;
            } catch (Exception e3) {
                e222 = e3;
                jarFile2 = jarFile;
            } catch (Throwable th) {
                e222 = th;
            }
        } catch (Exception e4) {
            e222 = e4;
            jarFile2 = null;
            try {
                throw new TinkerRuntimeException(String.format("PatchMetaInfo file %s, size %s verifyPatchMetaSignature fail", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length())}), e222);
            } catch (Throwable th2) {
                e222 = th2;
                jarFile = jarFile2;
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Throwable e5) {
                        Log.e(TAG, file.getAbsolutePath(), e5);
                    }
                }
                throw e222;
            }
        } catch (Throwable th3) {
            e222 = th3;
            jarFile = null;
            if (jarFile != null) {
                jarFile.close();
            }
            throw e222;
        }
    }

    public static boolean getPatchMetaInfo(Context context, File file, HashMap<String, String> hashMap) {
        Throwable e;
        JarFile jarFile;
        if (!isLegalFile(file)) {
            return false;
        }
        JarFile jarFile2;
        try {
            jarFile2 = new JarFile(file);
            try {
                Enumeration entries = jarFile2.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (jarEntry != null) {
                        String name = jarEntry.getName();
                        if (!name.startsWith("META-INF/") && name.endsWith(ShareConstants.META_SUFFIX)) {
                            hashMap.put(name, loadDigestes(jarFile2, jarEntry));
                        }
                    }
                }
                try {
                    jarFile2.close();
                } catch (Throwable e2) {
                    Log.e(TAG, file.getAbsolutePath(), e2);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                jarFile = jarFile2;
                try {
                    throw new TinkerRuntimeException(String.format("PatchMetaInfo file %s, size %s verifyPatchMetaSignature fail", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length())}), e2);
                } catch (Throwable th) {
                    e2 = th;
                    jarFile2 = jarFile;
                    if (jarFile2 != null) {
                        try {
                            jarFile2.close();
                        } catch (Throwable e4) {
                            Log.e(TAG, file.getAbsolutePath(), e4);
                        }
                    }
                    throw e2;
                }
            } catch (Throwable th2) {
                e2 = th2;
                if (jarFile2 != null) {
                    jarFile2.close();
                }
                throw e2;
            }
        } catch (Exception e5) {
            e2 = e5;
            jarFile = null;
            throw new TinkerRuntimeException(String.format("PatchMetaInfo file %s, size %s verifyPatchMetaSignature fail", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length())}), e2);
        } catch (Throwable th3) {
            e2 = th3;
            jarFile2 = null;
            if (jarFile2 != null) {
                jarFile2.close();
            }
            throw e2;
        }
    }

    public static final boolean isSoSymlink(File file) {
        if (file != null && file.getName().startsWith(ShareConstants.SO_PATH) && file.getName().endsWith(".so")) {
            return true;
        }
        return false;
    }

    public static final boolean safeDeleteFile(File file) {
        boolean z = true;
        if (file != null) {
            new StringBuilder("safeDeleteFile, try to delete path: ").append(file.getPath());
            if (file.exists() || isSoSymlink(file)) {
                z = file.delete();
                if (!z) {
                    Log.e(TAG, "Failed to delete file, try to delete when exit. path: " + file.getPath());
                    file.deleteOnExit();
                }
            }
        }
        return z;
    }

    public static final boolean deleteDir(String str) {
        if (str == null) {
            return false;
        }
        return deleteDir(new File(str));
    }

    public static final boolean deleteDir(File file) {
        int i = 0;
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    deleteDir(listFiles[i]);
                    i++;
                }
                safeDeleteFile(file);
            }
        } else {
            safeDeleteFile(file);
        }
        return true;
    }

    public static boolean verifyFileMd5(File file, String str) {
        if (str == null) {
            return false;
        }
        String md5 = getMD5(file);
        if (md5 != null) {
            return str.equals(md5);
        }
        return false;
    }

    public static boolean isRawDexFile(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(ShareConstants.DEX_SUFFIX);
    }

    public static boolean verifyDexFileMd5(File file, String str) {
        return verifyDexFileMd5(file, ShareConstants.DEX_IN_JAR, str);
    }

    public static boolean verifyDexFileMd5(File file, String str, String str2) {
        ZipFile zipFile;
        Throwable th;
        Throwable th2;
        boolean z = false;
        if (file == null || str2 == null || str == null) {
            return z;
        }
        Object md5;
        if (isRawDexFile(file.getName())) {
            md5 = getMD5(file);
        } else {
            try {
                zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry(str);
                    if (entry == null) {
                        Log.e(TAG, "There's no entry named: classes.dex in " + file.getAbsolutePath());
                        try {
                            zipFile.close();
                            return z;
                        } catch (Throwable th3) {
                            return z;
                        }
                    }
                    md5 = getMD5(zipFile.getInputStream(entry));
                    try {
                        zipFile.close();
                    } catch (Throwable th4) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        Log.e(TAG, "Bad dex jar file: " + file.getAbsolutePath(), th);
                        if (zipFile != null) {
                            return z;
                        }
                        try {
                            zipFile.close();
                            return z;
                        } catch (Throwable th6) {
                            return z;
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable th8) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th9) {
                th2 = th9;
                zipFile = null;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th2;
            }
        }
        return str2.equals(md5);
    }

    public static void copyFolder(File file, File file2) throws IOException {
        if (file != null && file.exists() && file2 != null && !file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                for (String str : file.list()) {
                    copyFolder(new File(file, str), new File(file2, str));
                }
                return;
            }
            copyFileUsingStream(file, file2);
        }
    }

    public static void copyFileUsingStream(File file, File file2) throws IOException {
        Closeable fileOutputStream;
        Throwable th;
        Closeable closeable = null;
        if (isLegalFile(file) && file2 != null && !file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            File parentFile = file2.getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            try {
                Closeable fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, false);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    closeable = fileInputStream;
                    closeQuietly(closeable);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            closeQuietly(fileInputStream);
                            closeQuietly(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileInputStream;
                    closeQuietly(closeable);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                closeQuietly(closeable);
                closeQuietly(fileOutputStream);
                throw th;
            }
        }
    }

    public static String loadDigestes(JarFile jarFile, JarEntry jarEntry) throws Exception {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        Closeable bufferedInputStream;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        closeQuietly(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    public static void loadDigestesDrain(JarFile jarFile, JarEntry jarEntry) throws Exception {
        Throwable th;
        Closeable bufferedInputStream;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (bufferedInputStream.read(bArr) > 0);
            closeQuietly(bufferedInputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    public static final String getMD5(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder stringBuilder = new StringBuilder(32);
                byte[] bArr = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                for (byte b : digest) {
                    stringBuilder.append(Integer.toString((b & 255) + LogType.UNEXP, 16).substring(1));
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String getMD5(File file) {
        Closeable fileInputStream;
        Throwable th;
        String str = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = getMD5((InputStream) fileInputStream);
                    closeQuietly(fileInputStream);
                } catch (Exception e) {
                    closeQuietly(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = str;
                closeQuietly(fileInputStream);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = str;
                th = th4;
                closeQuietly(fileInputStream);
                throw th;
            }
        }
        return str;
    }

    public static String optimizedPathFor(File file, File file2) {
        String name;
        if (ShareTinkerInternals.isAfterAndroidO()) {
            try {
                String currentInstructionSet = ShareTinkerInternals.getCurrentInstructionSet();
                File parentFile = file.getParentFile();
                name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    name = name.substring(0, lastIndexOf);
                }
                return parentFile.getAbsolutePath() + "/oat/" + currentInstructionSet + "/" + name + ShareConstants.ODEX_SUFFIX;
            } catch (Throwable e) {
                throw new TinkerRuntimeException("getCurrentInstructionSet fail:", e);
            }
        }
        name = file.getName();
        if (!name.endsWith(ShareConstants.DEX_SUFFIX)) {
            int lastIndexOf2 = name.lastIndexOf(".");
            if (lastIndexOf2 < 0) {
                name = name + ShareConstants.DEX_SUFFIX;
            } else {
                StringBuilder stringBuilder = new StringBuilder(lastIndexOf2 + 4);
                stringBuilder.append(name, 0, lastIndexOf2);
                stringBuilder.append(ShareConstants.DEX_SUFFIX);
                name = stringBuilder.toString();
            }
        }
        return new File(file2, name).getPath();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                Log.w(TAG, "Failed to close resource", e);
            }
        }
    }

    public static void closeZip(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Throwable e) {
                Log.w(TAG, "Failed to close resource", e);
            }
        }
    }

    public static boolean checkResourceArscMd5(File file, String str) {
        Throwable th;
        Throwable th2;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(ShareConstants.RES_ARSC);
                if (entry == null) {
                    closeZip(zipFile2);
                    return false;
                }
                InputStream inputStream = zipFile2.getInputStream(entry);
                String md5 = getMD5(inputStream);
                if (md5 == null || !md5.equals(str)) {
                    closeQuietly(inputStream);
                    closeZip(zipFile2);
                    return false;
                }
                closeQuietly(inputStream);
                closeZip(zipFile2);
                return true;
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = zipFile2;
                closeZip(zipFile);
                throw th2;
            }
        } catch (Throwable th4) {
            th = th4;
            new StringBuilder("checkResourceArscMd5 throwable:").append(th.getMessage());
            closeZip(zipFile);
            return false;
        }
    }

    public static void ensureFileDirectory(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }

    public static boolean isDigit(String str) {
        return Pattern.compile("[0-9]{1,}").matcher(str).matches();
    }
}
