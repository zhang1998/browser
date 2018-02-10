package com.ucpro.feature.webwindow.j;

import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
final class j extends WebViewClient {
    final /* synthetic */ l a;

    j(l lVar) {
        this.a = lVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        webView.evaluateJavascript("adblock.getAllRules()", new t(this, webView));
    }
}
