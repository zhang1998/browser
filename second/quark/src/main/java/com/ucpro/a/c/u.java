package com.ucpro.a.c;

import com.uc.webview.browser.interfaces.BrowserSettings;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;

    u(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final void run() {
        BrowserSettings.setGlobalBoolValue(this.a, this.b);
    }
}
