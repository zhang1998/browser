package com.bumptech.glide.f.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/* compiled from: ProGuard */
public abstract class d<Z> extends k<ImageView, Z> {
    @Nullable
    private Animatable b;

    protected abstract void b(@Nullable Z z);

    public d(ImageView imageView) {
        super(imageView);
    }

    private void d(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public final void b(@Nullable Drawable drawable) {
        super.b(drawable);
        c(null);
        d(drawable);
    }

    public final void c(@Nullable Drawable drawable) {
        super.c(drawable);
        c(null);
        d(drawable);
    }

    public final void a(@Nullable Drawable drawable) {
        super.a(drawable);
        c(null);
        d(drawable);
    }

    public final void a(Z z) {
        c((Object) z);
    }

    public final void a() {
        if (this.b != null) {
            this.b.start();
        }
    }

    public final void b() {
        if (this.b != null) {
            this.b.stop();
        }
    }

    private void c(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.b = (Animatable) z;
            this.b.start();
        } else {
            this.b = null;
        }
        b((Object) z);
    }
}
