package com.ucpro.business.a.c;

import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
final class e extends WebViewClient {
    final /* synthetic */ f a;

    e(f fVar) {
        this.a = fVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        this.a.a.a();
    }
}
