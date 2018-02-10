package com.ucpro.a;

import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;

/* compiled from: ProGuard */
final class z implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ aj b;

    z(aj ajVar, String str) {
        this.b = ajVar;
        this.a = str;
    }

    public final void run() {
        k.a;
        p.a(SettingKeys.NetworkAdFilterHostList, this.a);
    }
}
