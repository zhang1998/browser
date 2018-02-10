package com.uc.weex.component.f;

/* compiled from: ProGuard */
final class i implements Runnable {
    int a;
    int b;
    boolean c;
    final /* synthetic */ k d;

    public i(k kVar, int i, int i2, boolean z) {
        this.d = kVar;
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public final void run() {
        if (this.b > 0) {
            this.d.a(this.d.getCurrentHeight(), this.a, this.b, this.c);
        } else {
            this.d.a(this.d.getCurrentHeight(), this.a, this.c);
        }
    }
}
