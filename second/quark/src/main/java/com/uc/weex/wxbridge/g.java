package com.uc.weex.wxbridge;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: ProGuard */
final class g extends WebViewClient {
    final /* synthetic */ WebViewJSEngine a;

    g(WebViewJSEngine webViewJSEngine) {
        this.a = webViewJSEngine;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
