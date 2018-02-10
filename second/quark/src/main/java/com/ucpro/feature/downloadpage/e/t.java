package com.ucpro.feature.downloadpage.e;

import com.ucpro.base.system.b;

/* compiled from: ProGuard */
final class t implements Runnable {
    final /* synthetic */ boolean a = true;
    final /* synthetic */ o b;

    t(o oVar) {
        this.b = oVar;
    }

    public final void run() {
        if (this.a) {
            this.b.g = b.a.a(this.b.t);
            return;
        }
        this.b.g = "...";
    }
}
