package com.a.a.a;

/* compiled from: ProGuard */
public final class ek {
    fd a;
    int b = -1;
    int c = -1;
    int d = -1;
    int e = -1;
    final /* synthetic */ eg f;

    public ek(eg egVar) {
        this.f = egVar;
        int[] c = egVar.e.c();
        this.b = c[0];
        this.c = c[1];
    }

    final fd a(int i, int i2) {
        switch (i) {
            case 0:
                return this.a instanceof fk ? this.a : new fk();
            case 1:
                return this.a instanceof fc ? this.a : new fc();
            case 4:
                if (this.a instanceof fq) {
                    return this.a;
                }
                return new fq(this.f.a);
            case 5:
                if (this.a instanceof ff) {
                    return this.a;
                }
                return new ff(eg.f);
            case 6:
                if (!(this.a instanceof fp)) {
                    return new fp(this.f.a, (long) i2);
                }
                fd fdVar = this.a;
                ((fp) fdVar).a((long) i2);
                return fdVar;
            case 8:
                if (this.a instanceof fr) {
                    return this.a;
                }
                return new fr(this.f.a);
            default:
                if (this.a instanceof fc) {
                    return this.a;
                }
                return new fc();
        }
    }
}
