package com.uc.webview.browser.interfaces;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ Object b;

    a(ValueCallback valueCallback, Object obj) {
        this.a = valueCallback;
        this.b = obj;
    }

    public final void run() {
        this.a.onReceiveValue(this.b);
    }
}
