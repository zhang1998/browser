package com.ucpro.feature.webwindow.e;

import com.uc.webview.export.HttpAuthHandler;
import com.ucpro.feature.webwindow.ag;
import com.ucpro.feature.webwindow.au;
import com.ucpro.feature.webwindow.ba;
import com.ucpro.ui.g.y;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ HttpAuthHandler a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ i d;

    l(i iVar, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.d = iVar;
        this.a = httpAuthHandler;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        ba c = this.d.b.c();
        HttpAuthHandler httpAuthHandler = this.a;
        y yVar = new y(c.a, httpAuthHandler, this.b, this.c);
        yVar.a(new ag(c, httpAuthHandler));
        yVar.a(new au(c, httpAuthHandler));
        yVar.show();
    }
}
