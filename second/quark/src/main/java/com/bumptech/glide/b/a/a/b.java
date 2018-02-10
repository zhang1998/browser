package com.bumptech.glide.b.a.a;

import android.net.Uri;

/* compiled from: ProGuard */
public final class b {
    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static boolean a(int i, int i2) {
        return i <= 512 && i2 <= 384;
    }
}
