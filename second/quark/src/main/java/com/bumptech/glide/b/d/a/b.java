package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.d;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.o;
import java.io.File;

/* compiled from: ProGuard */
public final class b implements o<BitmapDrawable> {
    private final g a;
    private final o<Bitmap> b;

    public final /* synthetic */ boolean a(Object obj, File file, m mVar) {
        return this.b.a(new e(((BitmapDrawable) ((au) obj).b()).getBitmap(), this.a), file, mVar);
    }

    public b(g gVar, o<Bitmap> oVar) {
        this.a = gVar;
        this.b = oVar;
    }

    public final d a(m mVar) {
        return this.b.a(mVar);
    }
}
