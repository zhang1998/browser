package com.uc.weex;

import com.taobao.weex.a;
import com.taobao.weex.b;
import com.taobao.weex.i;
import com.taobao.weex.k;
import com.taobao.weex.m;
import com.uc.weex.wxbridge.UCWebViewEngine;
import com.uc.weex.wxbridge.WebViewJSEngine;

/* compiled from: ProGuard */
final class n implements a {
    private b a = null;

    n() {
    }

    public final b a() {
        if (this.a == null) {
            b bVar = null;
            k a = m.a();
            if (a == k.UC_WEBVIEW) {
                bVar = new UCWebViewEngine(i.e().getApplicationContext());
            } else if (a == k.WEBVIEW) {
                bVar = new WebViewJSEngine(i.e().getApplicationContext());
            }
            this.a = bVar;
        }
        return this.a;
    }
}
