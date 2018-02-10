package com.taobao.weex.ui.view;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class v extends WebViewClient {
    final /* synthetic */ x a;

    v(x xVar) {
        this.a = xVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        WXLogUtils.v("tag", "onPageOverride " + str);
        return true;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WXLogUtils.v("tag", "onPageStarted " + str);
        if (this.a.c != null) {
            this.a.c.b(str);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        WXLogUtils.v("tag", "onPageFinished " + str);
        if (this.a.c != null) {
            this.a.c.a(str, webView.canGoBack(), webView.canGoForward());
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.a.b != null) {
            this.a.b.a("error", "page error");
        }
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.a.b != null) {
            this.a.b.a("error", "http error");
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        if (this.a.b != null) {
            this.a.b.a("error", "ssl error");
        }
    }
}
