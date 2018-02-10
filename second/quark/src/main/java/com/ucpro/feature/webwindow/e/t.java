package com.ucpro.feature.webwindow.e;

import android.content.Context;
import android.text.TextUtils;
import com.uc.webview.browser.BrowserWebView;
import com.ucpro.feature.webwindow.e.a.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class t extends BrowserWebView {
    private a a;
    private int b;

    public t(Context context) {
        super(context);
        com.ucpro.feature.u.a.a("WebViewImpl", this);
    }

    public final void setWebViewProxyListener(a aVar) {
        this.a = aVar;
    }

    public final void coreComputeScroll() {
        super.coreComputeScroll();
        int scrollY = getCoreView().getScrollY();
        if (this.b != scrollY && this.a != null) {
            this.b = scrollY;
            this.a.a(scrollY);
        }
    }

    public final void loadUrl(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("ext:a:")) {
            super.loadUrl(str);
            return;
        }
        String a = com.ucpro.feature.webwindow.m.a.a(str);
        Map hashMap = new HashMap(1);
        hashMap.put("UC_REQUEST_LOAD_POLICY", "EXT_FORCE_DIRECT");
        super.loadUrl(a, hashMap);
    }

    public final int getPageScrollY() {
        return getCoreView().getScrollY();
    }
}
