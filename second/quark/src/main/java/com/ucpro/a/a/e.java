package com.ucpro.a.a;

import java.util.Vector;

/* compiled from: ProGuard */
public final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Vector b;
    final /* synthetic */ a c;

    public e(a aVar, String str, Vector vector) {
        this.c = aVar;
        this.a = str;
        this.b = vector;
    }

    public final void run() {
        new StringBuilder("setUserAgentControlList()\n").append(this.a).append(this.b.toString());
        this.c.a.setUserAgentControlList(this.a, this.b);
    }
}
