package com.ucpro.feature.webwindow.e;

import com.uc.webview.browser.interfaces.BrowserClient;

/* compiled from: ProGuard */
final class q extends BrowserClient {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    public final String onJsCommand(String str, String str2, String[] strArr) {
        return this.a.b.getJsApiManager().a(str, str2, strArr);
    }
}
