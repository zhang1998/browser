package com.ucpro.feature.webwindow.e;

import android.content.Context;
import com.uc.webview.browser.interfaces.BrowserClient;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebViewClient;
import com.ucpro.base.c.a.c;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.webwindow.at;
import com.ucpro.feature.webwindow.bo;

/* compiled from: ProGuard */
public final class j extends o {
    private bo a;
    private at c;
    private m d;
    private c e;
    private Context f;

    public j(Context context, at atVar, bo boVar, m mVar, c cVar) {
        super(boVar.getWebView());
        this.c = atVar;
        this.a = boVar;
        this.f = context;
        this.d = mVar;
        this.e = cVar;
    }

    public final BrowserClient b() {
        return new u(this.f, this.c, this.a, this.d, this.e);
    }

    public final WebChromeClient c() {
        return new y(this.f, this.c, this.a, this.d, this.e);
    }

    public final WebViewClient a() {
        return new i(this.f, this.c, this.a, this.d, this.e);
    }

    public final void a(String str) {
        this.a.e(str);
    }
}
