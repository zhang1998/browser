package com.ucpro.a.c;

import com.uc.webview.browser.interfaces.BrowserSettings;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    i(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        p.a;
        new StringBuilder("realSetToCore: \nkey: ").append(this.a).append("\nvalue: ").append(this.b);
        BrowserSettings.setGlobalStringValue(this.a, this.b);
        new StringBuilder("set ").append(this.a).append("success");
    }
}
