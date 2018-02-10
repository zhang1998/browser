package com.uc.weex.wxbridge;

import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
final class a extends WebViewClient {
    final /* synthetic */ UCWebViewEngine a;

    a(UCWebViewEngine uCWebViewEngine) {
        this.a = uCWebViewEngine;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
