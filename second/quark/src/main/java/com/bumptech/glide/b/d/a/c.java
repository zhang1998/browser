package com.bumptech.glide.b.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.p;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public final class c implements p<BitmapDrawable> {
    private final p<Bitmap> b;

    public c(p<Bitmap> pVar) {
        this.b = (p) j.a((Object) pVar, "Argument must not be null");
    }

    public final au<BitmapDrawable> a(Context context, au<BitmapDrawable> auVar, int i, int i2) {
        au a = e.a(((BitmapDrawable) auVar.b()).getBitmap(), com.bumptech.glide.c.a(context).b);
        au a2 = this.b.a(context, a, i, i2);
        if (a2.equals(a)) {
            return auVar;
        }
        return ab.a(context.getResources(), com.bumptech.glide.c.a(context).b, (Bitmap) a2.b());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        return this.b.equals(((c) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }
}
