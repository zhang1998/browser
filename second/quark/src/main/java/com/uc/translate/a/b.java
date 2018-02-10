package com.uc.translate.a;

import com.uc.apollo.impl.SettingsConst;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
public final class b {
    public static String a(Map<String, String> map, String str, String str2) throws IOException {
        byte[] b;
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        StringBuilder stringBuilder = new StringBuilder();
        if ("md5".equals(str2)) {
            stringBuilder.append(str);
        }
        for (String str3 : strArr) {
            if (a.a(str3, (String) map.get(str3))) {
                stringBuilder.append(str3).append((String) map.get(str3));
            }
        }
        if ("hmac".equals(str2)) {
            b = b(stringBuilder.toString(), str);
        } else if ("hmac-sha256".equals(str2)) {
            b = a(stringBuilder.toString(), str);
        } else {
            stringBuilder.append(str);
            b = a(stringBuilder.toString().getBytes("UTF-8"));
        }
        return b(b);
    }

    private static byte[] a(String str, String str2) throws IOException {
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA256");
            Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
            instance.init(secretKeySpec);
            return instance.doFinal(str.getBytes("UTF-8"));
        } catch (GeneralSecurityException e) {
            throw new IOException(e.toString());
        }
    }

    private static byte[] b(String str, String str2) throws IOException {
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "HmacMD5");
            Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
            instance.init(secretKeySpec);
            return instance.doFinal(str.getBytes("UTF-8"));
        } catch (GeneralSecurityException e) {
            throw new IOException(e.toString());
        }
    }

    private static byte[] a(byte[] bArr) throws IOException {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (GeneralSecurityException e) {
            throw new IOException(e.toString());
        }
    }

    private static String b(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append(SettingsConst.FALSE);
            }
            stringBuilder.append(toHexString.toUpperCase());
        }
        return stringBuilder.toString();
    }
}
