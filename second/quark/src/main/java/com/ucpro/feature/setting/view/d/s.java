package com.ucpro.feature.setting.view.d;

/* compiled from: ProGuard */
final class s implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ r b;

    s(r rVar, String str) {
        this.b = rVar;
        this.a = str;
    }

    public final void run() {
        this.b.f.a("ext:lp:useragreement", this.a, "text/html", "UTF-8", "ext:lp:useragreement");
    }
}
