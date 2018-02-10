package com.bumptech.glide.c;

import com.bumptech.glide.f.a.h;
import com.bumptech.glide.util.l;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
public final class v implements k {
    public final Set<h<?>> a = Collections.newSetFromMap(new WeakHashMap());

    public final void a() {
        for (h a : l.a(this.a)) {
            a.a();
        }
    }

    public final void b() {
        for (h b : l.a(this.a)) {
            b.b();
        }
    }

    public final void c() {
        for (h c : l.a(this.a)) {
            c.c();
        }
    }
}
