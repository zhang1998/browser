package com.ucpro.feature.privacymode.c;

import com.uc.browser.b;

/* compiled from: ProGuard */
public final class c implements Runnable {
    final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        b.a("privacy_password", "privacy_password_table", this.a);
    }
}
