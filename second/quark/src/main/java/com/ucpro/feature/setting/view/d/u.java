package com.ucpro.feature.setting.view.d;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ t b;

    u(t tVar, String str) {
        this.b = tVar;
        this.a = str;
    }

    public final void run() {
        this.b.f.a("ext:lp:privacyagreement", this.a, "text/html", "UTF-8", "ext:lp:privacyagreement");
    }
}
