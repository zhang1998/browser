package com.ucpro.feature.t.c;

/* compiled from: ProGuard */
final class i implements j {
    final /* synthetic */ f a;

    i(f fVar) {
        this.a = fVar;
    }

    public final void a(int i) {
        if (i == 30091) {
            boolean z;
            h a = this.a.c;
            if (a.a != null) {
                z = a.a.b.a;
            } else {
                z = false;
            }
            if (z && this.a.b != null) {
                this.a.b.a();
            }
            f.c(this.a);
            return;
        }
        if (this.a.b != null) {
            this.a.b.a(i);
        }
        this.a.b();
    }

    public final void a() {
        if (this.a.b != null) {
            this.a.b;
        }
    }
}
