package com.ucpro.a.a;

/* compiled from: ProGuard */
public final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    public d(a aVar, String str, String str2) {
        this.c = aVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        new StringBuilder("setHUCList()\n").append(this.a).append(":").append(this.b);
        this.c.a.setHUCList(this.a, this.b);
    }
}
