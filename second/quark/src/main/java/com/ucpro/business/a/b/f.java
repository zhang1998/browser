package com.ucpro.business.a.b;

import android.webkit.ValueCallback;
import com.ucpro.business.a.b.b.h;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        ((ValueCallback) this.a.a.obj).onReceiveValue(this.a.b.d);
        if (this.a.b.d instanceof h) {
            ((h) this.a.b.d).a(0.0f, 0);
        }
        m.a("promotion", "doodle_show", new String[0]);
    }
}
