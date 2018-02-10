package com.loc;

import java.net.ServerSocket;

/* compiled from: ProGuard */
final class at extends Thread {
    final /* synthetic */ au a;

    at(au auVar) {
        this.a = auVar;
    }

    public final void run() {
        try {
            if (!this.a.y) {
                this.a.e();
            }
            if (!this.a.u) {
                this.a.u = true;
                this.a.t = new ServerSocket(43689);
            }
            while (this.a.u) {
                this.a.v = this.a.t.accept();
                au.a(this.a, this.a.v);
            }
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "run");
        }
        super.run();
    }
}
