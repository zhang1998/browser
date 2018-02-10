package com.ucpro.a;

import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;

/* compiled from: ProGuard */
final class az implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ar b;

    az(ar arVar, String str) {
        this.b = arVar;
        this.a = str;
    }

    public final void run() {
        k.a;
        p.a(SettingKeys.NetworkAdblockUpdateAppRule, this.a);
    }
}
