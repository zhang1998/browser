package com.ucweb.common.util.o;

import android.os.Build.VERSION;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: ProGuard */
public final class d {
    public static byte[] a(String str, Charset charset) {
        if (VERSION.SDK_INT >= 9) {
            return str.getBytes(charset);
        }
        try {
            return str.getBytes(charset.name());
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
