package com.ucpro.feature.webwindow.j;

import android.content.Context;
import android.webkit.ValueCallback;
import com.ucpro.feature.webwindow.e.c;

/* compiled from: ProGuard */
public final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ p c;

    public f(p pVar, Context context, ValueCallback valueCallback) {
        this.c = pVar;
        this.a = context;
        this.b = valueCallback;
    }

    public final void run() {
        com.ucpro.feature.webwindow.e.f a = c.a(this.a, true);
        a.a("ext:lp:home");
        a.setWebViewCallback(new l(this, a));
    }
}
