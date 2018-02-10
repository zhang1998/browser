package com.uc.weex.i;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
final class n {
    private static byte[] a = null;

    public static void a(InputStream inputStream, File file, long j, long j2) throws IOException {
        Throwable th;
        file.delete();
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr;
                if (a == null) {
                    bArr = new byte[16384];
                    a = bArr;
                } else {
                    bArr = a;
                }
                if (j > 0) {
                    fileOutputStream2.getFD();
                }
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read >= 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        fileOutputStream2.getFD().sync();
                        file.setExecutable(true);
                        file.setLastModified(j2);
                        fileOutputStream2.getFD().sync();
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (Throwable th2) {
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileOutputStream = fileOutputStream2;
                th = th4;
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream.close();
            throw th;
        }
    }

    public static void a() {
        a = null;
    }

    public static int a(String[] strArr, String str) {
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i] != null && str.equals(strArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void a(File file) throws IOException {
        if (!file.delete()) {
            throw new IOException("could not delete file " + file);
        }
    }

    public static String[] b() {
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    public static f a(Context context) throws IOException {
        return f.a(new File(context.getApplicationInfo().dataDir, "libs-dir-lock"));
    }

    public static void a(File file, File file2) throws IOException {
        long j = 0;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            long lastModified = file.lastModified();
            if (lastModified >= 0) {
                j = lastModified;
            }
            a(fileInputStream, file2, file.length(), j);
        } catch (Throwable th) {
        } finally {
            a = null;
        }
    }

    public static void a(File file, long j) {
        if (j < 0) {
            j = 0;
        }
        file.setLastModified(j);
    }

    public static boolean a(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    static File b(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "app_wxlib");
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new RuntimeException("could not create libs directory");
    }
}
