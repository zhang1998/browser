package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.b.b.a.g;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public final class h extends f {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(a);

    protected final Bitmap a(@NonNull g gVar, @NonNull Bitmap bitmap, int i, int i2) {
        return ah.a(gVar, bitmap, i, i2);
    }

    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    public final int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterCrop".hashCode();
    }

    public final void a(MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
