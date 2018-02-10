package com.uc.base.a.a.a.a;

import com.uc.base.a.a.a.d.b;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ g b;

    e(g gVar, b bVar) {
        this.b = gVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.a.a() / 20000 == 1) {
            this.b.b.a(this.a, d.a(this.a.c));
            return;
        }
        this.b.b.b(this.a);
    }
}
