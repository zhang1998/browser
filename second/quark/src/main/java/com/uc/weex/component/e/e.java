package com.uc.weex.component.e;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ f a;

    e(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        x.a(this.a.d.c, 0);
        this.a.d.d(this.a.b);
        if (this.a.c != null) {
            this.a.c.a();
        }
        this.a.d.f.remove(this);
    }
}
