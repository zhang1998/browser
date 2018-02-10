package com.ucpro.a;

import android.webkit.ValueCallback;
import com.uc.a.b.e;
import com.ucpro.business.e.f.a;

/* compiled from: ProGuard */
final class ai implements Runnable {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ e b;
    final /* synthetic */ am c;

    ai(am amVar, ValueCallback valueCallback, e eVar) {
        this.c = amVar;
        this.a = valueCallback;
        this.b = eVar;
    }

    public final void run() {
        this.a.onReceiveValue(a.b(this.b));
    }
}
