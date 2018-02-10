package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class ao implements ValueCallback<s> {
    final /* synthetic */ an a;

    ao(an anVar) {
        this.a = anVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ((s) obj).stop();
    }
}
