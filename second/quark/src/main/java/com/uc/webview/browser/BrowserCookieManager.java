package com.uc.webview.browser;

import android.webkit.ValueCallback;
import com.uc.webview.browser.internal.BrowserSDKFactory;
import com.uc.webview.browser.internal.interfaces.IBrowserCookieManager;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class BrowserCookieManager {
    private static final BrowserCookieManager a = new BrowserCookieManager();
    private IBrowserCookieManager b = BrowserSDKFactory.h();
    private Extension c;

    @Api
    /* compiled from: ProGuard */
    public class Extension {
        com.uc.webview.browser.internal.interfaces.IBrowserCookieManager.Extension a;
        final /* synthetic */ BrowserCookieManager b;

        private Extension(BrowserCookieManager browserCookieManager, com.uc.webview.browser.internal.interfaces.IBrowserCookieManager.Extension extension) {
            this.b = browserCookieManager;
            this.a = extension;
        }

        public void removeCookiesForDomains(String[] strArr) {
            this.a.removeCookiesForDomains(strArr);
        }

        public void removeCookiesForDomains(String[] strArr, ValueCallback<Boolean> valueCallback) {
            this.a.removeCookiesForDomains(strArr, valueCallback);
        }
    }

    private BrowserCookieManager() {
        if (this.b.getExtension() != null) {
            this.c = new Extension(this.b.getExtension());
        }
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    public static BrowserCookieManager getInstance() {
        return a;
    }

    public void setAcceptCookie(boolean z) {
        this.b.setAcceptCookie(z);
    }

    public boolean acceptCookie() {
        return this.b.acceptCookie();
    }

    public void setCookie(String str, String str2) {
        this.b.setCookie(str, str2);
    }

    public String getCookie(String str) {
        return this.b.getCookie(str);
    }

    public void removeSessionCookie() {
        this.b.removeSessionCookie();
    }

    public void removeAllCookie() {
        this.b.removeAllCookie();
    }

    public boolean hasCookies() {
        return this.b.hasCookies();
    }

    public Extension getExtension() {
        return this.c;
    }
}
