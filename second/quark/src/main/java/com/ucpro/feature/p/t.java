package com.ucpro.feature.p;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class t implements ValueCallback<g> {
    final /* synthetic */ o a;

    t(o oVar) {
        this.a = oVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        g gVar = (g) obj;
        this.a.e = false;
        r b = this.a.c;
        b.removeAllViews();
        b.b = null;
        b.a = b.a(gVar);
        b.b();
        b.a();
        o.c(this.a);
        o.d(this.a);
    }
}
