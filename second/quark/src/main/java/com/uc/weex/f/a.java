package com.uc.weex.f;

import java.util.Iterator;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ b a;

    a(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (this.a.g.booleanValue()) {
            this.a.d = Boolean.valueOf(true);
            b.b(this.a);
            this.a.a(null);
        } else {
            this.a.d = Boolean.valueOf(false);
            c.c.b(false);
            super.a(null);
        }
        synchronized (this.a.e) {
            Iterator it = this.a.e.iterator();
            while (it.hasNext()) {
                it.next();
                this.a.g.booleanValue();
            }
        }
    }
}
