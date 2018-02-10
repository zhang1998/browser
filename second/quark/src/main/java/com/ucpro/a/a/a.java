package com.ucpro.a.a;

import com.uc.webview.browser.BrowserCore;
import com.uc.webview.browser.interfaces.IUserAgent;
import com.ucpro.a.g;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class a {
    public IUserAgent a = BrowserCore.getUserAgent();
    public b b;

    public a(b bVar) {
        c.b(g.a().c());
        this.b = bVar;
    }

    public final void a(String str, String str2) {
        c.a(this.a);
        m.a(2, new f(this, str, str2));
    }
}
