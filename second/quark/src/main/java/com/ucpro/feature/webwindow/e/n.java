package com.ucpro.feature.webwindow.e;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ u b;

    n(u uVar, ValueCallback valueCallback) {
        this.b = uVar;
        this.a = valueCallback;
    }

    public final void run() {
        this.a.onReceiveValue(Boolean.valueOf(false));
    }
}
