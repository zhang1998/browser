package com.a.a.a;

import android.content.Context;
import com.a.a.g;
import com.uc.apollo.impl.SettingsConst;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
public final class fg {
    private static final byte[] a = new byte[]{(byte) 10, (byte) 1, (byte) 11, (byte) 5, (byte) 4, (byte) 15, (byte) 7, (byte) 9, (byte) 23, (byte) 3, (byte) 1, (byte) 6, (byte) 8, (byte) 12, (byte) 13, (byte) 91};

    public static byte[] a(String str) {
        byte[] bArr = null;
        if (str != null) {
            int length = str.length();
            if (length % 2 == 0) {
                bArr = new byte[(length / 2)];
                for (int i = 0; i < length; i += 2) {
                    bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i + 2), 16).intValue();
                }
            }
        }
        return bArr;
    }

    public static boolean a(Context context, byte[] bArr) {
        long length = (long) bArr.length;
        if (length <= g.f) {
            return false;
        }
        fi.a(context).d();
        bx.c = context;
        bv.a.a(length, System.currentTimeMillis(), "__data_size_of");
        return true;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(a));
        return instance.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(a));
        return instance.doFinal(bArr);
    }

    public static int a(int i, String str) {
        int i2 = 0;
        if (((double) new Random().nextFloat()) < 0.001d) {
            if (str == null) {
                fw.a("--->", "null signature..");
            }
            try {
                i2 = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception e) {
            }
            return (i2 | 128) * 1000;
        }
        i2 = new Random().nextInt(i);
        if (i2 > 255000 || i2 < 128000) {
            return i2;
        }
        return 127000;
    }

    public static String a(Throwable th) {
        String str = null;
        if (th != null) {
            try {
                Writer stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(printWriter);
                }
                str = stringWriter.toString();
                printWriter.close();
                stringWriter.close();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String b(String str) {
        return "http://" + str + ".umeng.com/app_logs";
    }

    public static String c(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(bytes);
            byte[] digest = instance.digest();
            String str2 = "";
            int i = 0;
            while (i < digest.length) {
                String toHexString = Integer.toHexString(digest[i] & 255);
                if (toHexString.length() == 1) {
                    str2 = str2 + SettingsConst.FALSE;
                }
                i++;
                str2 = str2 + toHexString;
            }
            return str2;
        } catch (Exception e) {
            return null;
        }
    }
}
