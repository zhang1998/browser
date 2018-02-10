package com.ucpro.base.weex;

import android.webkit.ValueCallback;
import com.uc.webview.export.WebView;
import com.uc.weex.e;

/* compiled from: ProGuard */
final class h implements ValueCallback<String> {
    final /* synthetic */ e a;
    final /* synthetic */ WebView b;
    final /* synthetic */ f c;

    h(f fVar, e eVar, WebView webView) {
        this.c = fVar;
        this.a = eVar;
        this.b = webView;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if ("\"v8Inited\"".equals((String) obj)) {
            this.a.b(true);
        } else {
            this.a.b(false);
        }
        if (this.b != null) {
            this.b.destroy();
        }
    }
}
