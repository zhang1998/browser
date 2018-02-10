package com.ucpro.feature.webwindow;

import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
final class j extends WebViewClient {
    final /* synthetic */ bd a;

    j(bd bdVar) {
        this.a = bdVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        webView.destroy();
    }
}
