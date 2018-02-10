package com.uc.webview.browser.internal.android;

import android.content.Context;
import android.util.AttributeSet;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView.IHitTestResult;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView.IHitTestResult.IExtension;
import com.uc.webview.export.WebView;
import com.uc.webview.export.internal.android.WebViewAndroid;
import com.uc.webview.export.internal.interfaces.IUCExtension;
import com.uc.webview.export.internal.interfaces.IWebView;

/* compiled from: ProGuard */
public final class b extends WebViewAndroid {

    /* compiled from: ProGuard */
    final class a implements IHitTestResult {
        final /* synthetic */ b a;
        private IWebView.IHitTestResult b;

        private a(b bVar, IWebView.IHitTestResult iHitTestResult) {
            this.a = bVar;
            this.b = iHitTestResult;
        }

        public final int getType() {
            return this.b.getType();
        }

        public final String getExtra() {
            return this.b.getExtra();
        }

        public final IExtension getExtension() {
            return null;
        }
    }

    public final /* synthetic */ IWebView.IHitTestResult getHitTestResultInner() {
        IWebView.IHitTestResult hitTestResultInner = super.getHitTestResultInner();
        return hitTestResultInner != null ? new a(hitTestResultInner) : null;
    }

    public final /* bridge */ /* synthetic */ IUCExtension getUCExtension() {
        return null;
    }

    public b(Context context, AttributeSet attributeSet, WebView webView) {
        super(context, attributeSet, webView);
    }
}
