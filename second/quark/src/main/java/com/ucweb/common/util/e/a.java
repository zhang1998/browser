package com.ucweb.common.util.e;

import android.util.Base64;
import com.ucweb.common.util.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class a {
    protected static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static boolean a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        int i = 0;
        boolean z = false;
        while (true) {
            int i2 = bArr[i] & 255;
            boolean z2 = (i2 & 128) == 0 ? true : (i2 & 192) != 192 ? false : (i2 & 224) == 192 ? true : (i2 & 240) == 224 ? true : (i2 & 248) == 240 ? true : (i2 & 252) == 248 ? true : (i2 & 254) == 252 ? true : z;
            if (!z2) {
                return false;
            }
            int i3 = i + z2;
            if (i3 > bArr.length) {
                return false;
            }
            int i4;
            int i5;
            if (z2) {
                i4 = bArr[i + 5] & 255;
                if (i4 < 128 || i4 > 191) {
                    return false;
                }
                i4 = z2 - 1;
            } else {
                boolean z3 = z2;
            }
            if (i4 == 5) {
                i5 = bArr[i + 4] & 255;
                if (i5 < 128 || i5 > 191) {
                    return false;
                }
                i4--;
            }
            if (i4 == 4) {
                i5 = bArr[i + 3] & 255;
                if (i5 < 128 || i5 > 191) {
                    return false;
                }
                i4--;
            }
            if (i4 == 3) {
                i5 = bArr[i + 2] & 255;
                if (i5 < 128 || i5 > 191) {
                    return false;
                }
                i4--;
            }
            if (i4 == 2) {
                i = bArr[i + 1] & 255;
                if (i > 191 || i < 128) {
                    return false;
                }
                i = i4 - 1;
            } else {
                i = i4;
            }
            if (i == 1 && i2 >= 128 && i2 < 194) {
                return false;
            }
            if (i3 == bArr.length) {
                return true;
            }
            i = i3;
            z = z2;
        }
    }

    public static byte[] b(byte[] bArr) {
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
            } catch (Exception e) {
                c.a(e.toString());
            }
        }
        return bArr2;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr.length == 0) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
            byte[] bArr2 = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    inflaterInputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return toByteArray;
                }
            }
        } catch (Exception e) {
            c.a(e.toString());
            return null;
        }
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = null;
        if (!(bArr == null || bArr.length == 0)) {
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
                c.a(e.toString());
            }
        }
        return bArr2;
    }

    public static String e(byte[] bArr) {
        String str = null;
        if (bArr != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bArr);
                byte[] digest = instance.digest();
                String str2 = "";
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : digest) {
                    char c = a[(b & 240) >> 4];
                    char c2 = a[b & 15];
                    stringBuilder.append(c);
                    stringBuilder.append(c2).append(str2);
                }
                str = stringBuilder.toString().toUpperCase();
            } catch (NoSuchAlgorithmException e) {
                c.a(e.toString());
            }
        }
        return str;
    }

    public static byte[] a(String str) {
        return Base64.decode(str, 0);
    }

    public static String f(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
