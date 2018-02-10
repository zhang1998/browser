package com.bumptech.glide.b.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.n;
import com.bumptech.glide.util.j;
import java.io.IOException;

/* compiled from: ProGuard */
public final class a<DataType> implements n<DataType, BitmapDrawable> {
    private final n<DataType, Bitmap> a;
    private final Resources b;
    private final g c;

    public a(Resources resources, g gVar, n<DataType, Bitmap> nVar) {
        this.b = (Resources) j.a((Object) resources, "Argument must not be null");
        this.c = (g) j.a((Object) gVar, "Argument must not be null");
        this.a = (n) j.a((Object) nVar, "Argument must not be null");
    }

    public final boolean a(DataType dataType, m mVar) throws IOException {
        return this.a.a(dataType, mVar);
    }

    public final au<BitmapDrawable> a(DataType dataType, int i, int i2, m mVar) throws IOException {
        au a = this.a.a(dataType, i, i2, mVar);
        if (a == null) {
            return null;
        }
        return ab.a(this.b, this.c, (Bitmap) a.b());
    }
}
