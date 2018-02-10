package com.bumptech.glide;

import com.bumptech.glide.c.c;
import com.bumptech.glide.c.s;
import com.bumptech.glide.f.b;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
final class t implements c {
    private final s a;

    public t(s sVar) {
        this.a = sVar;
    }

    public final void a(boolean z) {
        if (z) {
            s sVar = this.a;
            for (b bVar : l.a(sVar.a)) {
                if (!(bVar.f() || bVar.h())) {
                    bVar.c();
                    if (sVar.c) {
                        sVar.b.add(bVar);
                    } else {
                        bVar.b();
                    }
                }
            }
        }
    }
}
