package com.uc.base.b.c.c;

import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.uc.base.b.c.a.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class a {
    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static int a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                com.uc.base.b.b.a.a(th);
            }
        }
    }

    public static String a(String... strArr) {
        StringBuffer stringBuffer = new StringBuffer((strArr.length * 32) * 10);
        for (String append : strArr) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public static boolean a(String str, String str2, byte[] bArr, byte[] bArr2, int i, boolean z) {
        if (a(str) || a(str2) || bArr2 == null) {
            return false;
        }
        File d = d(str + (System.currentTimeMillis() + str2));
        if (!a(d, bArr, bArr2, i, z)) {
            return false;
        }
        String str3 = str + str2;
        if (!a(d, str3)) {
            String b = b(str3);
            c(b);
            a(new File(str3), b);
            if (!a(d, str3)) {
                return false;
            }
            c(b);
        }
        return true;
    }

    public static byte[] a(File file) {
        Closeable fileInputStream;
        byte[] a;
        Throwable th;
        Throwable th2;
        Closeable closeable = null;
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    a = a((InputStream) fileInputStream);
                    a(fileInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        com.uc.base.b.b.a.a(th);
                        a(fileInputStream);
                        return a;
                    } catch (Throwable th4) {
                        th2 = th4;
                        a(fileInputStream);
                        throw th2;
                    }
                }
            }
            a(closeable);
        } catch (Throwable th5) {
            fileInputStream = closeable;
            th2 = th5;
            a(fileInputStream);
            throw th2;
        }
        return a;
    }

    private static byte[] a(InputStream inputStream) {
        Closeable byteArrayOutputStream = new ByteArrayOutputStream(2048);
        byte[] bArr = null;
        try {
            byte[] bArr2 = new byte[WXMediaMessage.THUMB_LENGTH_LIMIT];
            while (true) {
                int read = inputStream.read(bArr2, 0, WXMediaMessage.THUMB_LENGTH_LIMIT);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            com.uc.base.b.b.a.a(th);
        } finally {
            a(byteArrayOutputStream);
        }
        return bArr;
    }

    public static String b(String str) {
        return str + ".bak";
    }

    private static boolean a(File file, byte[] bArr, byte[] bArr2, int i, boolean z) {
        Throwable th;
        Throwable th2;
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            if (bArr != null) {
                try {
                    fileOutputStream.write(bArr);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        com.uc.base.b.b.a.a(th);
                        a(fileOutputStream);
                        return false;
                    } catch (Throwable th4) {
                        th2 = th4;
                        a(fileOutputStream);
                        throw th2;
                    }
                }
            }
            fileOutputStream.write(bArr2, 0, i);
            fileOutputStream.flush();
            if (z) {
                FileDescriptor fd = fileOutputStream.getFD();
                if (fd != null) {
                    fd.sync();
                }
            }
            a(fileOutputStream);
            return true;
        } catch (Throwable th5) {
            th2 = th5;
            fileOutputStream = null;
            a(fileOutputStream);
            throw th2;
        }
    }

    public static boolean a(File file, String str) {
        return file.renameTo(new File(str));
    }

    public static boolean c(String str) {
        return b(new File(str));
    }

    private static boolean b(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String file2 : list) {
                    if (!b(new File(file, file2))) {
                        return false;
                    }
                }
            }
        }
        return file.delete();
    }

    public static File d(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (!(parentFile == null || parentFile.exists())) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Throwable th) {
                new StringBuilder("create file error: ").append(th.getMessage());
                com.uc.base.b.b.a.a(th);
            }
        }
        return file;
    }

    public static final int a(byte[] bArr, int i, StringBuffer stringBuffer) {
        int i2 = 0;
        if (bArr == null || bArr.length == 0 || i <= 0) {
            return 0;
        }
        int i3 = i + 0;
        while (i2 < i3) {
            int i4 = bArr[i2] & 255;
            byte b;
            switch (i4 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    i2++;
                    stringBuffer.append((char) i4);
                    break;
                case 12:
                case 13:
                    i2 += 2;
                    if (i2 <= i3) {
                        b = bArr[i2 - 1];
                        if ((b & 192) == 128) {
                            stringBuffer.append((char) (((i4 & 31) << 6) | (b & 63)));
                            break;
                        }
                        return stringBuffer.length();
                    }
                    return stringBuffer.length();
                case 14:
                    i2 += 3;
                    if (i2 <= i3) {
                        b = bArr[i2 - 2];
                        byte b2 = bArr[i2 - 1];
                        if ((b & 192) == 128 && (b2 & 192) == 128) {
                            stringBuffer.append((char) ((((i4 & 15) << 12) | ((b & 63) << 6)) | ((b2 & 63) << 0)));
                            break;
                        }
                        return stringBuffer.length();
                    }
                    return stringBuffer.length();
                    break;
                default:
                    return stringBuffer.length();
            }
        }
        return stringBuffer.length();
    }

    public static int a(String str, int i) {
        if (str == null || str.length() == 0) {
            return i;
        }
        boolean startsWith = str.startsWith("0x");
        if (startsWith) {
            str = str.substring(2);
        }
        if (startsWith) {
            return (int) Long.parseLong(str, 16);
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return i;
        }
    }

    public static double e(String str) {
        double d = 0.0d;
        if (!(str == null || str.length() == 0)) {
            try {
                d = Double.parseDouble(str);
            } catch (Throwable e) {
                com.uc.base.b.b.a.a(e);
            }
        }
        return d;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        if (!(bArr == null || bArr.length == 0)) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                byte[] bArr3 = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                gZIPInputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
            } catch (Throwable e) {
                com.uc.base.b.b.a.a(e);
            }
        }
        return bArr2;
    }

    public static String f(String str) {
        byte[] bArr;
        byte[] bArr2;
        if (str == null || str.length() == 0) {
            bArr = null;
        } else {
            bArr = a(new File(str));
        }
        if (bArr != null) {
            b a = com.uc.base.b.b.a.a((byte) 1, (byte) 3);
            if (a == null) {
                bArr2 = null;
            } else {
                bArr = a.b(bArr);
                bArr2 = bArr;
            }
        } else {
            bArr = null;
            bArr2 = bArr;
        }
        if (bArr2 == null) {
            return null;
        }
        try {
            return new String(bArr2, "utf-8");
        } catch (Throwable th) {
            com.uc.base.b.b.a.a(th);
            return null;
        }
    }
}
