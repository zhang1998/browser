package com.ucpro.a.a;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    f(a aVar, String str, String str2) {
        this.c = aVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        new StringBuilder().append(this.a).append(" : ").append(this.b);
        this.c.a.setUserAgent(this.a, this.b);
    }
}
