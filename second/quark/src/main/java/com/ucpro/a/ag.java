package com.ucpro.a;

import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;

/* compiled from: ProGuard */
final class ag implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ v b;

    ag(v vVar, String str) {
        this.b = vVar;
        this.a = str;
    }

    public final void run() {
        k.a;
        p.a(SettingKeys.NetworkAdblockUpdateRule, this.a);
    }
}
