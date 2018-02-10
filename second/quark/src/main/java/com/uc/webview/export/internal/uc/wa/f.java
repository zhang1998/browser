package com.uc.webview.export.internal.uc.wa;

import com.uc.webview.export.internal.utility.Log;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
final class f {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static String a(String str) {
        String str2 = null;
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder stringBuilder = new StringBuilder(length * 2);
            length += 0;
            for (int i = 0; i < length; i++) {
                byte b = digest[i];
                char c = a[(b & 240) >> 4];
                char c2 = a[b & 15];
                stringBuilder.append(c);
                stringBuilder.append(c2);
            }
            str2 = stringBuilder.toString();
        } catch (Throwable e) {
            Log.e("SDKWaStat", "", e);
        } catch (Throwable e2) {
            Log.e("SDKWaStat", "", e2);
        }
        return str2;
    }

    static byte[] a(byte[] bArr) throws Exception {
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
        Key secretKeySpec = new SecretKeySpec(new byte[]{(byte) 38, (byte) 40, (byte) 85, (byte) 99, (byte) 83, (byte) 100, (byte) 107, (byte) 56, (byte) 56, (byte) 40, (byte) 56, (byte) 56, (byte) 35, (byte) 61, (byte) 61, (byte) 61}, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(b(bArr));
    }

    private static byte[] b(byte[] bArr) {
        Object obj = new byte[(bArr.length + 16)];
        int length = bArr.length;
        obj[0] = (byte) ((length >> 0) & 255);
        obj[1] = (byte) ((length >> 8) & 255);
        obj[2] = (byte) ((length >> 16) & 255);
        obj[3] = (byte) ((length >> 24) & 255);
        for (length = 4; length < 16; length++) {
            obj[length] = null;
        }
        System.arraycopy(bArr, 0, obj, 16, bArr.length);
        return obj;
    }
}
