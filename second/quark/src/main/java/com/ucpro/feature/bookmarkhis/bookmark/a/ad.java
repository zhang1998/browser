package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: ProGuard */
final class ad extends WebChromeClient {
    final /* synthetic */ WebView a;
    final /* synthetic */ p b;

    ad(p pVar, WebView webView) {
        this.b = pVar;
        this.a = webView;
    }

    public final void onReceivedTitle(WebView webView, String str) {
        this.a.destroy();
        if (!this.b.a) {
            this.b.a = true;
            this.b.c.onReceiveValue(str);
        }
    }
}
