package com.ucpro.feature.webwindow;

import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebView;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;

/* compiled from: ProGuard */
public final class be implements l {
    final /* synthetic */ SslErrorHandler a;
    final /* synthetic */ WebView b;
    final /* synthetic */ bo c;
    final /* synthetic */ ba d;

    public be(ba baVar, SslErrorHandler sslErrorHandler, WebView webView, bo boVar) {
        this.d = baVar;
        this.a = sslErrorHandler;
        this.b = webView;
        this.c = boVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (this.a != null) {
            if (u.c == i) {
                this.a.proceed();
            } else {
                this.a.cancel();
                this.b.stopLoading();
                if (this.c.b()) {
                    this.c.q();
                }
                com.ucpro.feature.webwindow.h.h addressBar = this.c.getAddressBar();
                if (addressBar.getProgressBar() != null) {
                    addressBar.getProgressBar().setVisible(false);
                }
                addressBar.d = false;
            }
        }
        return false;
    }
}
