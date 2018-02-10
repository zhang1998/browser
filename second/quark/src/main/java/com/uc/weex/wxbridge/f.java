package com.uc.weex.wxbridge;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ UCWebViewEngine b;

    f(UCWebViewEngine uCWebViewEngine, String str) {
        this.b = uCWebViewEngine;
        this.a = str;
    }

    public final void run() {
        if (this.b.mWebView != null) {
            this.b.mWebView.evaluateJavascript("javascript:" + this.a, new e(this));
        }
    }
}
