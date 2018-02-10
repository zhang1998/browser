package com.ucpro.feature.bookmarkhis.b;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class c implements ValueCallback<Boolean> {
    final /* synthetic */ e a;

    c(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.d();
        }
    }
}
