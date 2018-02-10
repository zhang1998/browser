package com.ucweb.common.util.h;

import android.os.Process;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ int a = 10;
    final /* synthetic */ Runnable b;
    final /* synthetic */ e c;
    final /* synthetic */ Runnable d;

    b(Runnable runnable, e eVar, Runnable runnable2) {
        this.b = runnable;
        this.c = eVar;
        this.d = runnable2;
    }

    public final void run() {
        Process.setThreadPriority(this.a);
        try {
            this.b.run();
            if (this.c != null && this.d != null) {
                this.c.post(this.d);
            }
        } catch (Throwable th) {
            if (m.i == null) {
                m.h();
            }
            m.i.post(new g(this, th));
        }
    }
}
