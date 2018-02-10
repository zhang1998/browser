package com.ucpro.feature.setting.view.d;

import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
final class j extends WebViewClient {
    final /* synthetic */ x a;

    j(x xVar) {
        this.a = xVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        p.a(this.a.a);
    }
}
