package com.uc.weex.h;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ o a;
    final /* synthetic */ r b;

    q(r rVar, o oVar) {
        this.b = rVar;
        this.a = oVar;
    }

    public final void run() {
        this.b.a.remove(this.a);
    }
}
