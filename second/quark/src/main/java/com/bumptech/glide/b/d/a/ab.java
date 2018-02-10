package com.bumptech.glide.b.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.aq;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.util.j;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
public final class ab implements aq, au<BitmapDrawable> {
    private final Bitmap a;
    private final Resources b;
    private final g c;

    public static ab a(Resources resources, g gVar, Bitmap bitmap) {
        return new ab(resources, gVar, bitmap);
    }

    private ab(Resources resources, g gVar, Bitmap bitmap) {
        this.b = (Resources) j.a((Object) resources, "Argument must not be null");
        this.c = (g) j.a((Object) gVar, "Argument must not be null");
        this.a = (Bitmap) j.a((Object) bitmap, "Argument must not be null");
    }

    public final Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    public final int c() {
        return l.a(this.a);
    }

    public final void d() {
        this.c.a(this.a);
    }

    public final void e() {
        this.a.prepareToDraw();
    }

    public final /* synthetic */ Object b() {
        return new BitmapDrawable(this.b, this.a);
    }
}
