package com.ucpro.feature.webwindow.f.a.a;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class o implements ValueCallback<Boolean> {
    final /* synthetic */ g a;

    o(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        g.a;
        new StringBuilder("add bookmark from js result : ").append(bool);
    }
}
