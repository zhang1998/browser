package com.bumptech.glide.c;

import com.bumptech.glide.util.l;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
final class a implements j {
    private final Set<k> a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    a() {
    }

    public final void a(k kVar) {
        this.a.add(kVar);
        if (this.c) {
            kVar.c();
        } else if (this.b) {
            kVar.a();
        } else {
            kVar.b();
        }
    }

    public final void b(k kVar) {
        this.a.remove(kVar);
    }

    final void a() {
        this.b = true;
        for (k a : l.a(this.a)) {
            a.a();
        }
    }

    final void b() {
        this.b = false;
        for (k b : l.a(this.a)) {
            b.b();
        }
    }

    final void c() {
        this.c = true;
        for (k c : l.a(this.a)) {
            c.c();
        }
    }
}
