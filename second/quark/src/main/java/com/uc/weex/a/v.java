package com.uc.weex.a;

import com.uc.weex.j.b;

/* compiled from: ProGuard */
final class v implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;
    final /* synthetic */ y c;

    v(y yVar, String str, e eVar) {
        this.c = yVar;
        this.a = str;
        this.b = eVar;
    }

    public final void run() {
        String b = b.b(this.a);
        n a = m.a(b);
        if (a != null) {
            a.a = this.a;
        }
        this.c.a(this.b, a, b, ab.a);
    }
}
