package com.ucpro.feature.webwindow.j;

import android.content.Context;
import com.ucpro.feature.webwindow.e.c;
import com.ucpro.feature.webwindow.e.f;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    i(p pVar, Context context, String str) {
        this.c = pVar;
        this.a = context;
        this.b = str;
    }

    public final void run() {
        f a = c.a(this.a, true);
        a.a("ext:lp:home");
        a.setWebViewCallback(new u(this, a));
    }
}
