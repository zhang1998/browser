package com.uc.weex.wxbridge;

import android.annotation.TargetApi;
import android.os.Build.VERSION;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ WebViewJSEngine b;

    l(WebViewJSEngine webViewJSEngine, String str) {
        this.b = webViewJSEngine;
        this.a = str;
    }

    @TargetApi(19)
    public final void run() {
        if (this.b.mWebView != null) {
            if (VERSION.SDK_INT < 19) {
                this.b.mWebView.loadUrl("javascript: " + this.a);
            } else {
                this.b.mWebView.evaluateJavascript("javascript: " + this.a, new k(this));
            }
        }
    }
}
