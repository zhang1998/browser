package com.a.a.a;

/* compiled from: ProGuard */
final class bl extends ab<bn> {
    private bl() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        bn bnVar = (bn) cVar;
        tVar.e();
        while (true) {
            l g = tVar.g();
            if (g.b != (byte) 0) {
                switch (g.c) {
                    case (short) 1:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            bnVar.a = tVar.q();
                            break;
                        }
                    case (short) 2:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            bnVar.b = tVar.q();
                            break;
                        }
                    case (short) 3:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            bnVar.c = tVar.q();
                            break;
                        }
                    case (short) 4:
                        if (g.b != (byte) 8) {
                            p.a(tVar, g.b);
                            break;
                        }
                        bnVar.d = tVar.n();
                        bnVar.a();
                        break;
                    case (short) 5:
                        if (g.b != (byte) 8) {
                            p.a(tVar, g.b);
                            break;
                        }
                        bnVar.e = tVar.n();
                        bnVar.b();
                        break;
                    case (short) 6:
                        if (g.b != (byte) 8) {
                            p.a(tVar, g.b);
                            break;
                        }
                        bnVar.f = tVar.n();
                        bnVar.c();
                        break;
                    case (short) 7:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            bnVar.g = tVar.r();
                            break;
                        }
                    case (short) 8:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            bnVar.h = tVar.q();
                            break;
                        }
                    case (short) 9:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            bnVar.i = tVar.q();
                            break;
                        }
                    case (short) 10:
                        if (g.b != (byte) 8) {
                            p.a(tVar, g.b);
                            break;
                        }
                        bnVar.j = tVar.n();
                        bnVar.e();
                        break;
                    default:
                        p.a(tVar, g.b);
                        break;
                }
            }
            tVar.f();
            if (!f.a(bnVar.k, 0)) {
                throw new q("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
            } else if (!f.a(bnVar.k, 1)) {
                throw new q("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
            } else if (f.a(bnVar.k, 2)) {
                bnVar.f();
                return;
            } else {
                throw new q("Required field 'length' was not found in serialized data! Struct: " + toString());
            }
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        bn bnVar = (bn) cVar;
        bnVar.f();
        bn.m;
        tVar.b();
        if (bnVar.a != null) {
            tVar.a(bn.n);
            tVar.a(bnVar.a);
        }
        if (bnVar.b != null) {
            tVar.a(bn.o);
            tVar.a(bnVar.b);
        }
        if (bnVar.c != null) {
            tVar.a(bn.p);
            tVar.a(bnVar.c);
        }
        tVar.a(bn.q);
        tVar.b(bnVar.d);
        tVar.a(bn.r);
        tVar.b(bnVar.e);
        tVar.a(bn.s);
        tVar.b(bnVar.f);
        if (bnVar.g != null) {
            tVar.a(bn.t);
            tVar.a(bnVar.g);
        }
        if (bnVar.h != null) {
            tVar.a(bn.u);
            tVar.a(bnVar.h);
        }
        if (bnVar.i != null) {
            tVar.a(bn.v);
            tVar.a(bnVar.i);
        }
        if (bnVar.d()) {
            tVar.a(bn.w);
            tVar.b(bnVar.j);
        }
        tVar.d();
        tVar.c();
    }
}
