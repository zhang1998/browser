package com.loc;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ j a;

    i(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        try {
            if (this.a.e() || !this.a.m) {
                if (this.a.g) {
                    this.a.g = false;
                    j.b(this.a);
                }
                if (this.a.a()) {
                    this.a.E = true;
                    j.a(this.a, 1);
                    return;
                }
                return;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager$NetWorkTask", "run");
        }
    }
}
