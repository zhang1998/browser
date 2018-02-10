package com.bumptech.glide.b.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.d.a.e;
import com.bumptech.glide.b.p;
import com.bumptech.glide.c;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public final class i implements p<f> {
    private final p<Bitmap> b;

    public i(p<Bitmap> pVar) {
        this.b = (p) j.a((Object) pVar, "Argument must not be null");
    }

    public final au<f> a(Context context, au<f> auVar, int i, int i2) {
        f fVar = (f) auVar.b();
        au eVar = new e(fVar.a(), c.a(context).b);
        au a = this.b.a(context, eVar, i, i2);
        if (!eVar.equals(a)) {
            eVar.d();
        }
        Bitmap bitmap = (Bitmap) a.b();
        fVar.a.b.a(this.b, bitmap);
        return auVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        return this.b.equals(((i) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }
}
