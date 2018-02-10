package com.uc.base.a.a.a.e;

import com.uc.base.a.a.a.a.d;
import com.uc.base.a.a.a.d.b;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ b b;

    k(b bVar, b bVar2) {
        this.b = bVar;
        this.a = bVar2;
    }

    public final void run() {
        if (this.a.a() / 20000 == 1) {
            this.b.d.a(this.a);
        } else if (this.a.a() == 50058 || this.a.a() == 52000) {
            this.b.d.a(this.a, d.b(this.a.c));
        } else {
            this.b.d.b(this.a);
        }
    }
}
