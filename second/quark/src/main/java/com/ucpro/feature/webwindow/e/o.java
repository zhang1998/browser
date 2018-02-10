package com.ucpro.feature.webwindow.e;

import com.uc.webview.browser.interfaces.BrowserClient;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebViewClient;

/* compiled from: ProGuard */
public abstract class o {
    f b;

    public o(f fVar) {
        this.b = fVar;
    }

    public WebViewClient a() {
        return new WebViewClient();
    }

    public WebChromeClient c() {
        return new WebChromeClient();
    }

    public BrowserClient b() {
        return new q(this);
    }

    public void a(String str) {
    }
}
