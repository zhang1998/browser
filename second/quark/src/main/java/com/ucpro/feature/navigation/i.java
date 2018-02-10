package com.ucpro.feature.navigation;

import com.uc.browser.b;
import com.ucpro.feature.navigation.b.j;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ o b;

    i(o oVar, j jVar) {
        this.b = oVar;
        this.a = jVar;
    }

    public final void run() {
        b.a("navigation", "data_backup", this.a);
    }
}
