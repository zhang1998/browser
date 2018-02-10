package com.uc.webview.export.internal.setup;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ bf a;
    final /* synthetic */ q b;

    r(q qVar, bf bfVar) {
        this.b = qVar;
        this.a = bfVar;
    }

    public final void run() {
        try {
            this.b.a();
            this.a.a(0, null);
        } catch (Throwable th) {
            this.a.a(3, th);
        }
    }
}
