package com.loc;

import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class aw implements Callable<Void> {
    final /* synthetic */ bc a;

    aw(bc bcVar) {
        this.a = bcVar;
    }

    private Void a() throws Exception {
        synchronized (this.a) {
            if (this.a.l == null) {
            } else {
                this.a.i();
                if (this.a.g()) {
                    this.a.f();
                    this.a.n = 0;
                }
            }
        }
        return null;
    }

    public final /* synthetic */ Object call() throws Exception {
        return a();
    }
}
