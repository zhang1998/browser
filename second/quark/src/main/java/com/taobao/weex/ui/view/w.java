package com.taobao.weex.ui.view;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class w extends WebChromeClient {
    final /* synthetic */ x a;

    w(x xVar) {
        this.a = xVar;
    }

    public final void onProgressChanged(WebView webView, int i) {
        boolean z;
        int i2;
        boolean z2 = true;
        super.onProgressChanged(webView, i);
        x xVar = this.a;
        if (i == 100) {
            z = true;
        } else {
            z = false;
        }
        WebView webView2 = xVar.a;
        if (z) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        webView2.setVisibility(i2);
        x xVar2 = this.a;
        if (i == 100) {
            z2 = false;
        }
        xVar2.b(z2);
        WXLogUtils.v("tag", "onPageProgressChanged " + i);
    }

    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.a.c != null) {
            this.a.c.a(webView.getTitle());
        }
    }
}
