package com.ucpro.feature.o.a;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class l implements ValueCallback<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ k b;

    l(k kVar, String str) {
        this.b = kVar;
        this.a = str;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.b.a.a(this.a);
        }
    }
}
