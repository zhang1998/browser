package com.a.a.a;

/* compiled from: ProGuard */
public final class p {
    private static int a = Integer.MAX_VALUE;

    public static void a(t tVar, byte b) throws g {
        a(tVar, b, a);
    }

    private static void a(t tVar, byte b, int i) throws g {
        int i2 = 0;
        if (i <= 0) {
            throw new g("Maximum skip depth exceeded");
        }
        switch (b) {
            case (byte) 2:
                tVar.k();
                return;
            case (byte) 3:
                tVar.l();
                return;
            case (byte) 4:
                tVar.p();
                return;
            case (byte) 6:
                tVar.m();
                return;
            case (byte) 8:
                tVar.n();
                return;
            case (byte) 10:
                tVar.o();
                return;
            case (byte) 11:
                tVar.r();
                return;
            case (byte) 12:
                tVar.e();
                while (true) {
                    l g = tVar.g();
                    if (g.b != (byte) 0) {
                        a(tVar, g.b, i - 1);
                    } else {
                        tVar.f();
                        return;
                    }
                }
            case (byte) 13:
                y h = tVar.h();
                while (i2 < h.c) {
                    a(tVar, h.a, i - 1);
                    a(tVar, h.b, i - 1);
                    i2++;
                }
                return;
            case (byte) 14:
                o j = tVar.j();
                while (i2 < j.b) {
                    a(tVar, j.a, i - 1);
                    i2++;
                }
                return;
            case (byte) 15:
                m i3 = tVar.i();
                while (i2 < i3.b) {
                    a(tVar, i3.a, i - 1);
                    i2++;
                }
                return;
            default:
                return;
        }
    }
}
