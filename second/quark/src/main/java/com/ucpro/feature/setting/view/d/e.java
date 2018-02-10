package com.ucpro.feature.setting.view.d;

import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
final class e extends WebViewClient {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        r.a(this.a.a);
    }
}
