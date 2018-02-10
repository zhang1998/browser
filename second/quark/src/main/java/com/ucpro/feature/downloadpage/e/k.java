package com.ucpro.feature.downloadpage.e;

import android.webkit.ValueCallback;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ ah b;

    k(ah ahVar, ValueCallback valueCallback) {
        this.b = ahVar;
        this.a = valueCallback;
    }

    public final void run() {
        Object obj;
        ValueCallback valueCallback = this.a;
        if (this.b.d != null) {
            obj = this.b.d;
        } else {
            obj = new ArrayList();
        }
        valueCallback.onReceiveValue(obj);
    }
}
