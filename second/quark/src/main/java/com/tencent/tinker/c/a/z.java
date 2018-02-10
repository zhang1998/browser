package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.a;

/* compiled from: ProGuard */
public final class z {
    protected final a a;
    public int b;
    private int c;
    private int d;

    public z(a aVar, int i) {
        this.c = -1;
        this.a = aVar;
        this.c = i;
    }

    public final int a() {
        if (this.c == -1) {
            int a = this.a.a() & 255;
            this.c = a & 31;
            this.d = (a & 224) >> 5;
        }
        return this.c;
    }

    public final int b() {
        a(28);
        this.c = -1;
        return ab.b(this.a);
    }

    public final int c() {
        a(29);
        this.c = -1;
        this.b = ab.b(this.a);
        return ab.b(this.a);
    }

    public final int d() {
        return ab.b(this.a);
    }

    public final byte e() {
        a(0);
        this.c = -1;
        return (byte) y.a(this.a, this.d);
    }

    public final short f() {
        a(2);
        this.c = -1;
        return (short) y.a(this.a, this.d);
    }

    public final char g() {
        a(3);
        this.c = -1;
        return (char) y.a(this.a, this.d, false);
    }

    public final int h() {
        a(4);
        this.c = -1;
        return y.a(this.a, this.d);
    }

    public final long i() {
        a(6);
        this.c = -1;
        a aVar = this.a;
        int i = this.d;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) aVar.a()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float j() {
        a(16);
        this.c = -1;
        return Float.intBitsToFloat(y.a(this.a, this.d, true));
    }

    public final double k() {
        a(17);
        this.c = -1;
        a aVar = this.a;
        long j = 0;
        for (int i = this.d; i >= 0; i--) {
            j = (j >>> 8) | ((((long) aVar.a()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int l() {
        a(23);
        this.c = -1;
        return y.a(this.a, this.d, false);
    }

    public final int m() {
        a(24);
        this.c = -1;
        return y.a(this.a, this.d, false);
    }

    public final int n() {
        a(25);
        this.c = -1;
        return y.a(this.a, this.d, false);
    }

    public final int o() {
        a(27);
        this.c = -1;
        return y.a(this.a, this.d, false);
    }

    public final int p() {
        a(26);
        this.c = -1;
        return y.a(this.a, this.d, false);
    }

    public final void q() {
        a(30);
        this.c = -1;
    }

    public final boolean r() {
        a(31);
        this.c = -1;
        return this.d != 0;
    }

    public final void s() {
        int i = 0;
        int b;
        switch (a()) {
            case 0:
                e();
                return;
            case 2:
                f();
                return;
            case 3:
                g();
                return;
            case 4:
                h();
                return;
            case 6:
                i();
                return;
            case 16:
                j();
                return;
            case 17:
                k();
                return;
            case 23:
                l();
                return;
            case 24:
                m();
                return;
            case 25:
                n();
                return;
            case 26:
                p();
                return;
            case 27:
                o();
                return;
            case 28:
                b = b();
                while (i < b) {
                    s();
                    i++;
                }
                return;
            case 29:
                b = c();
                while (i < b) {
                    ab.b(this.a);
                    s();
                    i++;
                }
                return;
            case 30:
                q();
                return;
            case 31:
                r();
                return;
            default:
                throw new v("Unexpected type: " + Integer.toHexString(this.c));
        }
    }

    private void a(int i) {
        if (a() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(a())}));
        }
    }

    public z(x xVar, int i) {
        this(new w(xVar), i);
    }
}
