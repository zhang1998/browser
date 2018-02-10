package com.ucpro.a;

import com.uc.webview.browser.interfaces.BrowserMobileWebKit;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class k {
    public HashMap<String, String> a;
    private String b;
    private String c;

    private k() {
        this.a = new HashMap();
    }

    public k(BrowserMobileWebKit browserMobileWebKit) {
        this();
        this.b = browserMobileWebKit.getCoreVersion();
        this.c = browserMobileWebKit.getCoreBuildSeq();
        browserMobileWebKit.getCoreInfo(this.a);
    }
}
