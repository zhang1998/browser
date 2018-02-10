package com.ucpro.feature.webwindow;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class an implements ValueCallback {
    final /* synthetic */ ab a;

    an(ab abVar) {
        this.a = abVar;
    }

    public final void onReceiveValue(Object obj) {
        this.a.F = false;
    }
}
