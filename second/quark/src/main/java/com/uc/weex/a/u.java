package com.uc.weex.a;

import com.uc.weex.j.b;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;
    final /* synthetic */ y c;

    u(y yVar, String str, e eVar) {
        this.c = yVar;
        this.a = str;
        this.b = eVar;
    }

    public final void run() {
        String a = b.a(this.a);
        n a2 = m.a(a);
        if (a2 != null) {
            a2.a = this.a;
        }
        this.c.a(this.b, a2, a, ab.b);
    }
}
