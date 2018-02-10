package com.uc.weex.j;

import android.util.Log;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public final class a {
    protected static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            String str = "";
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                char c = a[(b & 240) >> 4];
                char c2 = a[b & 15];
                stringBuilder.append(c);
                stringBuilder.append(c2).append(str);
            }
            return stringBuilder.toString().toUpperCase();
        } catch (Throwable e) {
            Log.e("", "", e);
            return null;
        }
    }
}
