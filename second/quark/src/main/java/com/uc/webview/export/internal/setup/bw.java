package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class bw implements ValueCallback<s> {
    final ValueCallback a = ((ValueCallback) this.b.invokeO(10007, "switch"));
    final /* synthetic */ bu b;

    bw(bu buVar) {
        this.b = buVar;
    }

    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
        if (this.a != null) {
            this.a.onReceiveValue(this.b);
        }
    }
}
