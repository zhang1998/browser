package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class aq implements ValueCallback<k> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ am b;

    aq(am amVar, ValueCallback valueCallback) {
        this.b = amVar;
        this.a = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        k kVar = (k) obj;
        if (this.a != null) {
            this.a.onReceiveValue(kVar.getStat());
        }
    }
}
