package com.ucpro.a.c;

import com.uc.webview.browser.interfaces.BrowserSettings;

/* compiled from: ProGuard */
final class w implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ float b;

    w(String str, float f) {
        this.a = str;
        this.b = f;
    }

    public final void run() {
        BrowserSettings.setGlobalFloatValue(this.a, this.b);
    }
}
