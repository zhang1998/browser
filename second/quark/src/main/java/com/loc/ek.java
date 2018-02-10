package com.loc;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ProGuard */
public final class ek {
    public static String a(String str) {
        Throwable th;
        String str2 = null;
        FileInputStream fileInputStream;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.isFile() && file.exists()) {
                    byte[] bArr = new byte[2048];
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    fileInputStream = new FileInputStream(file);
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            instance.update(bArr, 0, read);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    str2 = eq.d(instance.digest());
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        es.a(th3, "MD5", "getMd5FromFile");
                    }
                }
            }
        } catch (Throwable th32) {
            fileInputStream = str2;
            th = th32;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str2;
    }

    public static byte[] a(byte[] bArr, String str) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Throwable th) {
            es.a(th, "MD5", "getMd5Bytes1");
        }
        return bArr2;
    }

    public static String b(String str) {
        return str == null ? null : eq.d(d(str));
    }

    static byte[] c(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    private static byte[] d(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            es.a(th, "MD5", "getMd5Bytes");
            return new byte[0];
        }
    }

    private static byte[] e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(eq.a(str));
        return instance.digest();
    }
}
