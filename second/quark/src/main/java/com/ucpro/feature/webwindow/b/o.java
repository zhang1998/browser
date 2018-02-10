package com.ucpro.feature.webwindow.b;

import android.os.Bundle;
import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class o implements ValueCallback<Bundle> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ k c;

    o(k kVar, String str, String str2) {
        this.c = kVar;
        this.a = str;
        this.b = str2;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.c.a != null) {
            f.a(bundle.getBoolean("succeed"), this.a, this.b);
        }
    }
}
