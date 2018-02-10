package com.uc.base.wa.b;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ n a;

    l(n nVar) {
        this.a = nVar;
    }

    public final void run() {
        synchronized (this.a.a) {
            while (!this.a.a.isEmpty() && this.a.b(((Integer) this.a.a.peek()).intValue())) {
                this.a.a.remove();
            }
        }
    }
}
