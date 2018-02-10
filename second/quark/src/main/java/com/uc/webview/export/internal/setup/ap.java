package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class ap implements ValueCallback<s> {
    final /* synthetic */ an a;

    ap(an anVar) {
        this.a = anVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        if (this.a.c != null) {
            this.a.c.onReceiveValue(sVar.getStat());
        }
    }
}
