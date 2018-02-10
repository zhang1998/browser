package com.alibaba.analytics.core.d;

import android.content.Context;

/* compiled from: ProGuard */
final class c implements Runnable {
    Context a;
    final /* synthetic */ g b;

    public c(g gVar) {
        this.b = gVar;
    }

    public final void run() {
        if (this.a != null && e.a(this.a)) {
            String[] b = g.b(this.a);
            if (this.b.e == null || !this.b.e[0].equals(b[0]) || !this.b.e[1].equals(b[1])) {
                for (a a : this.b.d) {
                    a.a(b[0]);
                }
                this.b.e = b;
            }
        }
    }
}
