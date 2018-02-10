package com.ucpro.feature.webwindow.j;

import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
final class k extends WebViewClient {
    final /* synthetic */ u a;

    k(u uVar) {
        this.a = uVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        webView.evaluateJavascript(String.format("adblock.deleteRules(\"%s\")", new Object[]{this.a.a.b}), null);
        webView.destroy();
    }
}
