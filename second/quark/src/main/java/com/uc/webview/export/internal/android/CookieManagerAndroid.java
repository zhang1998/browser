package com.uc.webview.export.internal.android;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.ICookieManager;

@Interface
/* compiled from: ProGuard */
public class CookieManagerAndroid implements ICookieManager {
    private CookieManager a = getSystemCookieManager();

    public CookieManager getSystemCookieManager() {
        try {
            return CookieManager.getInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        if (this.a != null) {
            this.a.setAcceptCookie(z);
        }
    }

    public synchronized boolean acceptCookie() {
        boolean acceptCookie;
        if (this.a != null) {
            acceptCookie = this.a.acceptCookie();
        } else {
            acceptCookie = false;
        }
        return acceptCookie;
    }

    public void setCookie(String str, String str2) {
        if (this.a != null) {
            this.a.setCookie(str, str2);
        }
    }

    public synchronized String getCookie(String str) {
        String cookie;
        if (this.a != null) {
            cookie = this.a.getCookie(str);
        } else {
            cookie = "";
        }
        return cookie;
    }

    public void removeSessionCookie() {
        if (this.a != null) {
            this.a.removeSessionCookie();
        }
    }

    public void removeAllCookie() {
        if (this.a != null) {
            this.a.removeAllCookie();
        }
    }

    public synchronized boolean hasCookies() {
        boolean hasCookies;
        if (this.a != null) {
            hasCookies = this.a.hasCookies();
        } else {
            hasCookies = false;
        }
        return hasCookies;
    }

    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
    }

    public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
    }

    public boolean acceptThirdPartyCookies(WebView webView) {
        return false;
    }

    public boolean allowFileSchemeCookiesImpl() {
        if (this.a != null) {
            return CookieManager.allowFileSchemeCookies();
        }
        return false;
    }

    public void setAcceptFileSchemeCookiesImpl(boolean z) {
        if (this.a != null) {
            CookieManager.setAcceptFileSchemeCookies(z);
        }
    }

    public void flush() {
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
    }
}
