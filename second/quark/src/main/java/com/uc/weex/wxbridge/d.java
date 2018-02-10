package com.uc.weex.wxbridge;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ UCWebViewEngine b;

    d(UCWebViewEngine uCWebViewEngine, String str) {
        this.b = uCWebViewEngine;
        this.a = str;
    }

    public final void run() {
        this.b.checkInit(this.b.mContext);
        if (this.b.mWebView != null) {
            this.b.mWebView.addJavascriptInterface(this.b, "bridge");
            this.b.mWebView.evaluateJavascript("javascript:" + this.a, new c(this));
        }
    }
}
