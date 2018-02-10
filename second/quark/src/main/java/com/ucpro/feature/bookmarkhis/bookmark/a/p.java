package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class p implements Runnable {
    boolean a = false;
    final /* synthetic */ Context b;
    final /* synthetic */ ValueCallback c;
    final /* synthetic */ String d;

    p(Context context, ValueCallback valueCallback, String str) {
        this.b = context;
        this.c = valueCallback;
        this.d = str;
    }

    public final void run() {
        WebView webView = new WebView(this.b);
        m.a(2, new z(this), 2000);
        webView.loadUrl(this.d);
        new StringBuilder("load url: ").append(this.d);
        webView.setWebChromeClient(new ad(this, webView));
        webView.setWebViewClient(new c(this));
    }
}
