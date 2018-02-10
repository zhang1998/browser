package com.alibaba.analytics.core.f;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.c.i;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ f a;

    c(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        af.b();
        int a = f.a(this.a);
        if (a > 0) {
            f.c.a(i.a(i.b, "time_ex", Double.valueOf((double) a)));
        }
        if (this.a.a.a() > 9000) {
            a = af.b();
            if (a > 0) {
                f.c.a(i.a(i.b, "count_ex", Double.valueOf((double) a)));
            }
        }
    }
}
