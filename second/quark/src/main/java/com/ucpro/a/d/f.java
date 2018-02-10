package com.ucpro.a.d;

import com.uc.webview.browser.BrowserCore;
import com.uc.webview.browser.interfaces.ICoreStat;

/* compiled from: ProGuard */
public final class f {
    private static ICoreStat a = null;

    public static void a() {
        if (a == null) {
            a = BrowserCore.getCoreStat();
        }
    }

    public static void b() {
        if (a != null) {
            a.getCoreStatUploadString();
        }
    }
}
