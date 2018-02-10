package com.ucpro.feature.navigation;

import com.ucpro.feature.navigation.b.j;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ o b;

    r(o oVar, j jVar) {
        this.b = oVar;
        this.a = jVar;
    }

    public final void run() {
        if (this.b.a != null) {
            this.b.a.a(new com.ucpro.feature.navigation.b.r(this.a));
        }
    }
}
