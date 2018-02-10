package com.ucpro.ui.widget.tablayout;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/* compiled from: ProGuard */
public final class c {
    Object a;
    Drawable b;
    public CharSequence c;
    CharSequence d;
    int e;
    View f;
    ProTabLayout g;
    q h;

    private c() {
        this.e = -1;
    }

    @NonNull
    public final c a(@Nullable CharSequence charSequence) {
        this.c = charSequence;
        b();
        return this;
    }

    public final void a() {
        if (this.g == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        this.g.b(this, true);
    }

    final void b() {
        if (this.h != null) {
            this.h.a();
        }
    }
}
