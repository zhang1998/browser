package com.g.b.a.d;

import java.security.MessageDigest;

/* compiled from: ProGuard */
public final class d {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            char[] cArr = new char[32];
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr[i2] = a[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = a[b & 15];
                i++;
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }
}
