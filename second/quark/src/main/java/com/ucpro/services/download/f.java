package com.ucpro.services.download;

import com.uc.quark.t;
import com.uc.webview.browser.BrowserCore;
import com.uc.webview.export.CookieManager;
import com.ucpro.feature.h.b;

/* compiled from: ProGuard */
final class f implements t {
    f() {
    }

    public final String a(String str) {
        return CookieManager.getInstance().getCookie(str);
    }

    public final String b(String str) {
        if (!l.a(str)) {
            return b.a.c();
        }
        b.a;
        return BrowserCore.getUserAgent().getUserAgent(com.ucweb.common.util.i.f.c(str));
    }
}
