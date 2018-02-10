package com.loc;

import java.util.TimerTask;

/* compiled from: ProGuard */
final class by extends TimerTask {
    final /* synthetic */ int a = 2;
    final /* synthetic */ cb b;

    by(cb cbVar) {
        this.b = cbVar;
    }

    public final void run() {
        try {
            Thread.currentThread().setPriority(1);
            long b = dm.b() - this.b.C;
            if (this.b.d() && this.b.t() == 0) {
                this.b.u();
            }
            if (b >= 10000) {
                if (this.b.v()) {
                    cb.a(this.b, this.a);
                } else {
                    this.b.u();
                }
            }
        } catch (Throwable th) {
            cq.a(th, "APS", "timerTaskU run");
        }
    }
}
