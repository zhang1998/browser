package com.ucpro.b.b;

import android.util.Base64;

/* compiled from: ProGuard */
public final class a {
    protected static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] a(String str) {
        return Base64.decode(str, 0);
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }
}
