package com.ucweb.common.util.h;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ k a;

    f(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        if (k.a != null) {
            k.a.removeIdleHandler(this.a);
        }
        this.a.d.run();
    }
}
