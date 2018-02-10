package com.ucpro.a.c;

import com.uc.webview.browser.interfaces.BrowserSettings;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;

    h(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final void run() {
        BrowserSettings.setGlobalIntValue(this.a, this.b);
    }
}
