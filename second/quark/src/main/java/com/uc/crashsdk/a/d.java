package com.uc.crashsdk.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: ProGuard */
public final class d {
    public static final int[] a = new int[]{126, 147, 115, 241, 101, 198, 215, 134};
    public static final int[] b = new int[]{125, 185, 233, 226, 129, 142, 151, 176};
    public static final int[] c = new int[]{238, 185, 233, 179, 129, 142, 151, 167};

    public static String a(String str) {
        Closeable fileInputStream;
        Throwable e;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream.read(bArr);
                fileInputStream.close();
                byte[] a = a(bArr, a);
                if (a == null || a.length <= 0) {
                    b.a(fileInputStream);
                    return null;
                }
                int length = a.length;
                String str2 = a[length + -1] == (byte) 10 ? new String(a, 0, length - 1) : new String(a);
                b.a(fileInputStream);
                return str2;
            } catch (Exception e2) {
                e = e2;
                try {
                    a.a(e, false);
                    b.a(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    b.a(fileInputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            a.a(e, false);
            b.a(fileInputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            b.a(fileInputStream);
            throw e;
        }
    }

    private static byte[] a(File file) {
        byte[] bArr;
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        if (!file.exists()) {
            return null;
        }
        try {
            bArr = new byte[((int) file.length())];
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                b.a(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    a.a(th, false);
                    b.a(fileInputStream);
                    bArr = null;
                    return bArr;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileInputStream;
                    b.a(closeable);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            b.a(closeable);
            throw th;
        }
        return bArr;
    }

    public static String a(String str, String str2, boolean z) {
        Closeable byteArrayOutputStream;
        Closeable gZIPOutputStream;
        Throwable th;
        boolean z2;
        Closeable closeable = null;
        boolean z3 = false;
        if (!z || h.a(str)) {
            return str;
        }
        File file = new File(str);
        if (!file.exists() || file.length() > 3145728) {
            return str;
        }
        byte[] a = a(file);
        if (a == null || a.length <= 0) {
            return str;
        }
        String str3;
        byte[] bArr;
        boolean z4;
        if (z) {
            byte[] toByteArray;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(a);
                        byteArrayOutputStream.flush();
                        b.a(byteArrayOutputStream);
                        b.a(gZIPOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = gZIPOutputStream;
                        b.a(byteArrayOutputStream);
                        b.a(closeable);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    b.a(byteArrayOutputStream);
                    b.a(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                b.a(byteArrayOutputStream);
                b.a(closeable);
                throw th;
            }
            try {
                toByteArray = r5.toByteArray();
                z2 = true;
            } catch (Throwable th5) {
                a.a(th5, false);
                z2 = false;
                toByteArray = a;
            }
            if (z2 || toByteArray == null || toByteArray.length <= 0) {
                return str;
            }
            str3 = str + str2;
            bArr = toByteArray;
            z4 = true;
        } else {
            z4 = false;
            str3 = str;
            bArr = a;
        }
        if (!z4) {
            return str;
        }
        String str4;
        if (str3.equals(file.getName())) {
            str4 = str3 + ".tmp";
            z4 = true;
        } else {
            z4 = false;
            str4 = str3;
        }
        File file2 = new File(str4);
        if (b.a(file2, bArr)) {
            if (z4) {
                file.delete();
                file2.renameTo(file);
            }
            z3 = true;
        }
        if (z3) {
            return str3;
        }
        return str;
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length + 0 < 2 || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = (bArr.length - 2) + 0;
        try {
            byte[] bArr2 = new byte[length];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                byte b = (byte) (bArr[i2 + 0] ^ iArr[i2 % 8]);
                bArr2[i2] = b;
                i = (byte) (i ^ b);
            }
            if (bArr[length + 0] == ((byte) ((iArr[0] ^ i) & 255)) && bArr[(length + 1) + 0] == ((byte) ((iArr[1] ^ i) & 255))) {
                return bArr2;
            }
            return null;
        } catch (Throwable e) {
            a.a(e, false);
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        byte[] bArr2 = null;
        if (!(bArr == null || iArr == null || iArr.length != 8)) {
            int length = bArr.length;
            try {
                bArr2 = new byte[(length + 2)];
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b = bArr[i2];
                    bArr2[i2] = (byte) (iArr[i2 % 8] ^ b);
                    i = (byte) (i ^ b);
                }
                bArr2[length] = (byte) (iArr[0] ^ i);
                bArr2[length + 1] = (byte) (iArr[1] ^ i);
            } catch (Throwable e) {
                a.a(e, false);
            }
        }
        return bArr2;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            a.a(th, false);
        }
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b = b(str2.getBytes(), a);
        if (b == null) {
            try {
                fileOutputStream.close();
                return false;
            } catch (Throwable th2) {
                a.a(th2, false);
                return false;
            }
        }
        boolean z;
        try {
            fileOutputStream.write(b);
            z = true;
            try {
                fileOutputStream.close();
            } catch (Throwable th3) {
                a.a(th3, false);
            }
        } catch (Throwable th22) {
            a.a(th22, false);
            z = false;
        }
        return z;
    }
}
