package com.uc.webview.browser.internal.interfaces;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.ICookieManager;

@Interface
/* compiled from: ProGuard */
public interface IBrowserCookieManager extends ICookieManager {

    @Interface
    /* compiled from: ProGuard */
    public interface Extension {
        void removeCookiesForDomains(String[] strArr);

        void removeCookiesForDomains(String[] strArr, ValueCallback<Boolean> valueCallback);
    }

    Extension getExtension();
}
