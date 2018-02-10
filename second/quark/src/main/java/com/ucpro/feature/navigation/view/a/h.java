package com.ucpro.feature.navigation.view.a;

import com.ucpro.feature.navigation.view.aq;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ aq a;
    final /* synthetic */ a b;

    h(a aVar, aq aqVar) {
        this.b = aVar;
        this.a = aqVar;
    }

    public final void run() {
        this.a.setCurrentState(g.a());
    }
}
