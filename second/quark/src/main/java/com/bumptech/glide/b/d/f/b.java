package com.bumptech.glide.b.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.d.a.ab;
import com.bumptech.glide.util.j;

/* compiled from: ProGuard */
public final class b implements d<Bitmap, BitmapDrawable> {
    private final Resources a;
    private final g b;

    public b(Resources resources, g gVar) {
        this.a = (Resources) j.a((Object) resources, "Argument must not be null");
        this.b = (g) j.a((Object) gVar, "Argument must not be null");
    }

    public final au<BitmapDrawable> a(au<Bitmap> auVar) {
        return ab.a(this.a, this.b, (Bitmap) auVar.b());
    }
}
