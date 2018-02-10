package com.ucpro.feature.setting.view.d;

/* compiled from: ProGuard */
final class af implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ p b;

    af(p pVar, String str) {
        this.b = pVar;
        this.a = str;
    }

    public final void run() {
        p.a(this.b, this.a);
    }
}
