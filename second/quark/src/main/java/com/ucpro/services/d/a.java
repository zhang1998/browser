package com.ucpro.services.d;

import java.io.UnsupportedEncodingException;

/* compiled from: ProGuard */
public final class a {
    public static byte[] a(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
