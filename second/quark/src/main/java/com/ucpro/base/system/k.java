package com.ucpro.base.system;

import android.webkit.ValueCallback;
import java.util.HashSet;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ ValueCallback a;

    k(ValueCallback valueCallback) {
        this.a = valueCallback;
    }

    public final void run() {
        if (this.a != null) {
            HashSet b = e.e;
            e.e = null;
            this.a.onReceiveValue(b);
        }
    }
}
