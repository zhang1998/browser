package com.ucpro.business.a.c;

import com.uc.webview.export.WebViewClient;
import com.ucpro.feature.webwindow.e.o;

/* compiled from: ProGuard */
public final class f extends o {
    g a;
    private a c;
    private WebViewClient d = new e(this);

    public f(g gVar, a aVar) {
        super(gVar.getWebView());
        this.a = gVar;
        this.c = aVar;
    }

    public final WebViewClient a() {
        return this.d;
    }
}
