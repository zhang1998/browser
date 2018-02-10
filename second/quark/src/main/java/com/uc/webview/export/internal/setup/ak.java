package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class ak implements ValueCallback<s> {
    final ValueCallback a = ((ValueCallback) this.b.invokeO(10007, "switch"));
    final /* synthetic */ ae b;

    ak(ae aeVar) {
        this.b = aeVar;
    }

    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
        if (this.a != null) {
            this.a.onReceiveValue(this.b);
        }
    }
}
