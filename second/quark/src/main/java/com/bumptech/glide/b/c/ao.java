package com.bumptech.glide.b.c;

import android.support.annotation.Nullable;
import com.bumptech.glide.util.g;

/* compiled from: ProGuard */
public final class ao<A, B> {
    public final g<an<A>, B> a;

    public ao() {
        this(250);
    }

    public ao(int i) {
        this.a = new am(this, i);
    }

    @Nullable
    public final B a(A a) {
        Object a2 = an.a(a);
        B b = this.a.b(a2);
        a2.a();
        return b;
    }
}
