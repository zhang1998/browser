package com.alibaba.analytics.core.db;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        synchronized (this.a) {
            if (this.a.a.get() == 0 && this.a.b != null) {
                this.a.b.close();
                this.a.b = null;
            }
        }
    }
}
