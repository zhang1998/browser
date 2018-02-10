package com.bumptech.glide.b.d.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.gifdecoder.a;

/* compiled from: ProGuard */
public final class d implements a {
    private final g a;
    @Nullable
    private final b b;

    public d(g gVar, b bVar) {
        this.a = gVar;
        this.b = bVar;
    }

    @NonNull
    public final Bitmap a(int i, int i2, Config config) {
        return this.a.b(i, i2, config);
    }

    public final void a(Bitmap bitmap) {
        this.a.a(bitmap);
    }

    public final byte[] a(int i) {
        if (this.b == null) {
            return new byte[i];
        }
        return (byte[]) this.b.a(i, byte[].class);
    }

    public final void a(byte[] bArr) {
        if (this.b != null) {
            this.b.a((Object) bArr, byte[].class);
        }
    }

    public final int[] b(int i) {
        if (this.b == null) {
            return new int[i];
        }
        return (int[]) this.b.a(i, int[].class);
    }

    public final void a(int[] iArr) {
        if (this.b != null) {
            this.b.a((Object) iArr, int[].class);
        }
    }
}
