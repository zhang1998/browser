package com.ucpro.feature.p;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class e implements ValueCallback<Boolean> {
    final /* synthetic */ n a;

    e(n nVar) {
        this.a = nVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            this.a.d = bool.booleanValue();
        }
    }
}
