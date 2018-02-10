package com.ucpro.a;

import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;

/* compiled from: ProGuard */
final class al implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ aa b;

    al(aa aaVar, String str) {
        this.b = aaVar;
        this.a = str;
    }

    public final void run() {
        k.a;
        p.a(SettingKeys.UserAdblockJs, am.a(this.a));
    }
}
