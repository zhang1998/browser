package com.uc.weex.wxbridge;

import android.annotation.TargetApi;
import android.os.Build.VERSION;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ WebViewJSEngine b;

    j(WebViewJSEngine webViewJSEngine, String str) {
        this.b = webViewJSEngine;
        this.a = str;
    }

    @TargetApi(19)
    public final void run() {
        if (this.b.mWebView != null) {
            this.b.mWebView.addJavascriptInterface(this.b, "bridge");
            if (VERSION.SDK_INT < 19) {
                this.b.mWebView.loadUrl("javascript:" + this.a);
                this.b.mWebView.loadUrl("file:///android_asset/main.html");
                return;
            }
            this.b.mWebView.loadUrl("javascript:");
            this.b.mWebView.evaluateJavascript("javascript:" + this.a, new i(this));
        }
    }
}
