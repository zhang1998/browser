package com.tencent.tinker.b.a.c;

import com.tencent.tinker.c.a.ab;
import com.tencent.tinker.c.a.b.b;
import com.tencent.tinker.c.a.v;
import com.tencent.tinker.c.a.y;
import com.tencent.tinker.c.a.z;

/* compiled from: ProGuard */
public final class e {
    final /* synthetic */ f a;
    private final b b;

    public e(f fVar, b bVar) {
        this.a = fVar;
        this.b = bVar;
    }

    private void c(z zVar) {
        int i = 0;
        switch (zVar.a()) {
            case 0:
                y.a(this.b, 0, (long) zVar.e());
                return;
            case 2:
                y.a(this.b, 2, (long) zVar.f());
                return;
            case 3:
                y.b(this.b, 3, (long) zVar.g());
                return;
            case 4:
                y.a(this.b, 4, (long) zVar.h());
                return;
            case 6:
                y.a(this.b, 6, zVar.i());
                return;
            case 16:
                y.c(this.b, 16, ((long) Float.floatToIntBits(zVar.j())) << 32);
                return;
            case 17:
                y.c(this.b, 17, Double.doubleToLongBits(zVar.k()));
                return;
            case 23:
                y.b(this.b, 23, (long) this.a.a(zVar.l()));
                return;
            case 24:
                y.b(this.b, 24, (long) this.a.b(zVar.m()));
                return;
            case 25:
                y.b(this.b, 25, (long) this.a.d(zVar.n()));
                return;
            case 26:
                y.b(this.b, 26, (long) this.a.e(zVar.p()));
                return;
            case 27:
                y.b(this.b, 27, (long) this.a.d(zVar.o()));
                return;
            case 28:
                a(28, 0);
                b(zVar);
                return;
            case 29:
                a(29, 0);
                a(zVar);
                return;
            case 30:
                zVar.q();
                a(30, 0);
                return;
            case 31:
                if (zVar.r()) {
                    i = 1;
                }
                a(31, i);
                return;
            default:
                throw new v("Unexpected type: " + Integer.toHexString(zVar.a()));
        }
    }

    public final void a(z zVar) {
        int c = zVar.c();
        ab.a(this.b, this.a.b(zVar.b));
        ab.a(this.b, c);
        for (int i = 0; i < c; i++) {
            ab.a(this.b, this.a.a(zVar.d()));
            c(zVar);
        }
    }

    public final void b(z zVar) {
        int b = zVar.b();
        ab.a(this.b, b);
        for (int i = 0; i < b; i++) {
            c(zVar);
        }
    }

    private void a(int i, int i2) {
        this.b.a((i2 << 5) | i);
    }
}
