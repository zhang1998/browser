package com.ucpro.services.d.a;

import com.uc.browser.b;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ u b;

    l(u uVar, String str) {
        this.b = uVar;
        this.a = str;
    }

    public final void run() {
        com.uc.a.d.l.b(this.a);
        i iVar = this.b.c;
        synchronized (u.class) {
            b.a("cms_data", iVar.a);
        }
    }
}
