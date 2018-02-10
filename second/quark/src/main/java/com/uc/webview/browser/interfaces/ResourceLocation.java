package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public enum ResourceLocation {
    UNKNOWN,
    NETWORK,
    PAGECACHE,
    APPCACHE,
    SUBSTITUTEDATA,
    LOCALCACHE,
    HTTPCACHE;

    public static ResourceLocation fromInt(int i) {
        ResourceLocation[] values = values();
        if (i < 0 || i >= values.length) {
            return UNKNOWN;
        }
        return values[i];
    }
}
