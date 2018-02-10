package com.taobao.weex;

import android.view.View;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ ac a;

    r(ac acVar) {
        this.a = acVar;
    }

    public final void run() {
        if (this.a.d != null) {
            this.a.i();
            View a = this.a.f;
            if (i.c() && ad.a().i != null) {
                a = ad.a().i.a();
            }
            this.a.s.k = System.currentTimeMillis() - this.a.q;
            if (this.a.b != null) {
                this.a.b.a(this.a, a);
            }
            if (this.a.c != null) {
                this.a.c.i_();
            }
        }
    }
}
