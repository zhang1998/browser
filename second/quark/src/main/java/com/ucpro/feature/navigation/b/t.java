package com.ucpro.feature.navigation.b;

import com.uc.browser.b;

/* compiled from: ProGuard */
final class t implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ r b;

    t(r rVar, j jVar) {
        this.b = rVar;
        this.a = jVar;
    }

    public final void run() {
        b.a("navigation", "data_backup", this.a);
    }
}
