package com.ucpro.feature.l.b;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class c implements ValueCallback<Boolean> {
    final /* synthetic */ m a;

    c(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        this.a.f = bool.booleanValue();
    }
}
