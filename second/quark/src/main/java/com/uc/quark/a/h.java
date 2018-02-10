package com.uc.quark.a;

import android.os.Handler;
import android.os.Process;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ int a = 10;
    final /* synthetic */ Runnable b;
    final /* synthetic */ Handler c;
    final /* synthetic */ Runnable d;

    h(Runnable runnable) {
        this.b = runnable;
        this.c = null;
        this.d = null;
    }

    public final void run() {
        Process.setThreadPriority(this.a);
        try {
            this.b.run();
            if (this.c != null && this.d != null) {
                this.c.post(this.d);
            }
        } catch (Throwable th) {
            if (m.h == null) {
                m.e();
            }
            m.h.post(new k(this, th));
        }
    }
}
