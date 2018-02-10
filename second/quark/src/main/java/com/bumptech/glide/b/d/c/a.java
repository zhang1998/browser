package com.bumptech.glide.b.d.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.b.b.aq;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.d.e.f;
import com.bumptech.glide.util.j;

/* compiled from: ProGuard */
public abstract class a<T extends Drawable> implements aq, au<T> {
    public final T a;

    public a(T t) {
        this.a = (Drawable) j.a((Object) t, "Argument must not be null");
    }

    public void e() {
        if (this.a instanceof BitmapDrawable) {
            ((BitmapDrawable) this.a).getBitmap().prepareToDraw();
        } else if (this.a instanceof f) {
            ((f) this.a).a().prepareToDraw();
        }
    }

    public final /* synthetic */ Object b() {
        return this.a.getConstantState().newDrawable();
    }
}
