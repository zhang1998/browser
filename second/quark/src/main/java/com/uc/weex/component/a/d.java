package com.uc.weex.component.a;

/* compiled from: ProGuard */
final class d implements Runnable {
    boolean a;
    boolean b;
    boolean c;
    final /* synthetic */ e d;

    d(e eVar, boolean z) {
        this.d = eVar;
        this.c = z;
    }

    public final void run() {
        this.b = true;
        if (!this.a) {
            this.d.b.a(this.c);
            if (this.c) {
                this.d.c = null;
            } else {
                this.d.d = null;
            }
        }
    }
}
