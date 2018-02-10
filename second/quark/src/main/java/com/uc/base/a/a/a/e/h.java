package com.uc.base.a.a.a.e;

import com.uc.base.a.a.a.d.b;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ f b;

    h(f fVar, b bVar) {
        this.b = fVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.a.a() / 20000 == 1) {
            j.a();
            this.b.b.a(this.a);
            return;
        }
        this.b.b.b(this.a);
    }
}
