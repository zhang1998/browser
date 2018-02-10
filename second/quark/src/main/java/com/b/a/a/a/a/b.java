package com.b.a.a.a.a;

/* compiled from: ProGuard */
public final class b {
    private static a a = new a();
    private static a b = new a();
    private static a c = new a();
    private static a d = new a();
    private static a e = new a();
    private static d f = new d();
    private static d g = new d();
    private static a h = new a();
    private static a i = new a();

    public static void a(a aVar, a aVar2, d dVar) {
        int i = 0;
        int i2 = 2;
        a.b(aVar, aVar2, b);
        double d;
        if (b.c() != 0.0d) {
            c.a(aVar);
            d.a(aVar2);
            b.b();
            c.b();
            d.b();
            d dVar2 = f;
            dVar2.a(0, c);
            dVar2.a(1, b);
            a.b(b, c, a);
            dVar2.a(2, a);
            d dVar3 = g;
            dVar3.a(0, d);
            dVar3.a(1, b);
            a.b(b, d, a);
            dVar3.a(2, a);
            d = dVar2.a[1];
            dVar2.a[1] = dVar2.a[3];
            dVar2.a[3] = d;
            double d2 = dVar2.a[2];
            dVar2.a[2] = dVar2.a[6];
            dVar2.a[6] = d2;
            double d3 = dVar2.a[5];
            dVar2.a[5] = dVar2.a[7];
            dVar2.a[7] = d3;
            d.a(dVar3, dVar2, dVar);
        } else if (a.a(aVar, aVar2) >= 0.0d) {
            dVar.b();
        } else {
            a aVar3 = e;
            d = Math.abs(aVar.a);
            double abs = Math.abs(aVar.b);
            double abs2 = Math.abs(aVar.c);
            if (d > abs) {
                if (d <= abs2) {
                    i = 2;
                }
            } else if (abs > abs2) {
                i = 1;
            } else {
                i = 2;
            }
            i--;
            if (i >= 0) {
                i2 = i;
            }
            aVar3.a();
            aVar3.a(i2, 1.0d);
            a.b(aVar, aVar3, aVar3);
            aVar3.b();
            i.a(e);
            i.a(3.141592653589793d / i.c());
            a(i, 0.0d, 0.20264236728467558d, dVar);
        }
    }

    public static void a(a aVar, d dVar) {
        double d;
        double d2 = 0.5d;
        double a = a.a(aVar, aVar);
        double sqrt = Math.sqrt(a);
        if (a < 1.0E-8d) {
            d = 1.0d - (a * 0.1666666716337204d);
        } else if (a < 1.0E-6d) {
            d2 = 0.5d - (0.0416666679084301d * a);
            d = 1.0d - ((1.0d - (a * 0.1666666716337204d)) * (a * 0.1666666716337204d));
        } else {
            a = 1.0d / sqrt;
            d = Math.sin(sqrt) * a;
            d2 = (1.0d - Math.cos(sqrt)) * (a * a);
        }
        a(aVar, d, d2, dVar);
    }

    public static void a(d dVar, a aVar) {
        double a = (((dVar.a(0, 0) + dVar.a(1, 1)) + dVar.a(2, 2)) - 1.0d) * 0.5d;
        aVar.a((dVar.a(2, 1) - dVar.a(1, 2)) / 2.0d, (dVar.a(0, 2) - dVar.a(2, 0)) / 2.0d, (dVar.a(1, 0) - dVar.a(0, 1)) / 2.0d);
        double c = aVar.c();
        if (a > 0.7071067811865476d) {
            if (c > 0.0d) {
                aVar.a(Math.asin(c) / c);
            }
        } else if (a > -0.7071067811865476d) {
            aVar.a(Math.acos(a) / c);
        } else {
            double asin = 3.141592653589793d - Math.asin(c);
            double a2 = dVar.a(0, 0) - a;
            double a3 = dVar.a(1, 1) - a;
            double a4 = dVar.a(2, 2) - a;
            a aVar2 = h;
            if (a2 * a2 > a3 * a3 && a2 * a2 > a4 * a4) {
                aVar2.a(a2, (dVar.a(1, 0) + dVar.a(0, 1)) / 2.0d, (dVar.a(0, 2) + dVar.a(2, 0)) / 2.0d);
            } else if (a3 * a3 > a4 * a4) {
                aVar2.a((dVar.a(1, 0) + dVar.a(0, 1)) / 2.0d, a3, (dVar.a(2, 1) + dVar.a(1, 2)) / 2.0d);
            } else {
                aVar2.a((dVar.a(0, 2) + dVar.a(2, 0)) / 2.0d, (dVar.a(2, 1) + dVar.a(1, 2)) / 2.0d, a4);
            }
            if (a.a(aVar2, aVar) < 0.0d) {
                aVar2.a(-1.0d);
            }
            aVar2.b();
            aVar2.a(asin);
            aVar.a(aVar2);
        }
    }

    private static void a(a aVar, double d, double d2, d dVar) {
        double d3 = aVar.a * aVar.a;
        double d4 = aVar.b * aVar.b;
        double d5 = aVar.c * aVar.c;
        dVar.a(0, 0, 1.0d - ((d4 + d5) * d2));
        dVar.a(1, 1, 1.0d - ((d5 + d3) * d2));
        dVar.a(2, 2, 1.0d - ((d3 + d4) * d2));
        d3 = aVar.c * d;
        d4 = (aVar.a * aVar.b) * d2;
        dVar.a(0, 1, d4 - d3);
        dVar.a(1, 0, d3 + d4);
        d3 = aVar.b * d;
        d4 = (aVar.a * aVar.c) * d2;
        dVar.a(0, 2, d4 + d3);
        dVar.a(2, 0, d4 - d3);
        d3 = aVar.a * d;
        d4 = (aVar.b * aVar.c) * d2;
        dVar.a(1, 2, d4 - d3);
        dVar.a(2, 1, d3 + d4);
    }
}
