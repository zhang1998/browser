package com.uc.apollo.media.service;

import com.uc.apollo.media.impl.E.a;
import com.uc.apollo.media.impl.F;

/* compiled from: ProGuard */
final class l extends a {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final void a(int i, F f, F f2) {
        this.a.l.obtainMessage(10, new int[]{i, f.l, f2.l}).sendToTarget();
    }

    public final void a(int i, int i2, int i3) {
        this.a.l.obtainMessage(11, new int[]{i, i2, i3}).sendToTarget();
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a.l.obtainMessage(12, new int[]{i, i2, i3, i4}).sendToTarget();
    }

    public final void a(int i) {
    }

    public final void b(int i) {
        this.a.l.obtainMessage(14, i, 0).sendToTarget();
    }

    public final void a(int i, int i2, int i3, Object obj) {
        if (i2 == 72 || i2 == 71) {
            this.a.l.obtainMessage(16, new int[]{i, i2, i3}).sendToTarget();
        }
    }
}
