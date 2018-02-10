package com.ucpro.e;

import com.ucpro.feature.y.u;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
public final class l implements g {
    final /* synthetic */ u a;
    final /* synthetic */ k b;

    public l(k kVar, u uVar) {
        this.b = kVar;
        this.a = uVar;
    }

    public final void a() {
        this.a.animate().alpha(0.0f).setListener(new e(this)).setDuration(100).start();
    }

    public final void b() {
    }
}
