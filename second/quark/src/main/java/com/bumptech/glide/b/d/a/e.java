package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.aq;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.util.j;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
public final class e implements aq, au<Bitmap> {
    private final Bitmap a;
    private final g b;

    @Nullable
    public static e a(@Nullable Bitmap bitmap, g gVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, gVar);
    }

    public e(Bitmap bitmap, g gVar) {
        this.a = (Bitmap) j.a((Object) bitmap, "Bitmap must not be null");
        this.b = (g) j.a((Object) gVar, "BitmapPool must not be null");
    }

    public final Class<Bitmap> a() {
        return Bitmap.class;
    }

    public final int c() {
        return l.a(this.a);
    }

    public final void d() {
        this.b.a(this.a);
    }

    public final void e() {
        this.a.prepareToDraw();
    }

    public final /* bridge */ /* synthetic */ Object b() {
        return this.a;
    }
}
