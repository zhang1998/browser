package com.uc.weex.a;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ y a;

    o(y yVar) {
        this.a = yVar;
    }

    public final void run() {
        if (!this.a.h) {
            y.b(this.a);
            y.c(this.a);
            this.a.h = true;
        }
    }
}
