package com.c.a;

import com.c.a.f.a;

/* compiled from: ProGuard */
public final class y implements Runnable {
    final /* synthetic */ f a;

    public y(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        f fVar = this.a;
        for (a a : fVar.d.a) {
            a.a();
        }
        a a2 = fVar.c.c();
        if (a2 != null) {
            a2.a();
        }
        if (fVar.g != null) {
            fVar.g.c();
            fVar.g.a();
            fVar.g = null;
        }
    }
}
