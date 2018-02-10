package com.a.a.a;

/* compiled from: ProGuard */
final class ds extends ab<dg> {
    private ds() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        dg dgVar = (dg) cVar;
        tVar.e();
        while (true) {
            l g = tVar.g();
            if (g.b != (byte) 0) {
                switch (g.c) {
                    case (short) 1:
                        if (g.b != (byte) 8) {
                            p.a(tVar, g.b);
                            break;
                        }
                        dgVar.a = tVar.n();
                        dgVar.a();
                        break;
                    case (short) 2:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            dgVar.b = tVar.q();
                            break;
                        }
                    case (short) 3:
                        if (g.b != (byte) 12) {
                            p.a(tVar, g.b);
                            break;
                        }
                        dgVar.c = new dx();
                        dgVar.c.a(tVar);
                        break;
                    default:
                        p.a(tVar, g.b);
                        break;
                }
            }
            tVar.f();
            if (f.a(dgVar.d, 0)) {
                dgVar.d();
                return;
            }
            throw new q("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        dg dgVar = (dg) cVar;
        dgVar.d();
        dg.f;
        tVar.b();
        tVar.a(dg.g);
        tVar.b(dgVar.a);
        if (dgVar.b != null && dgVar.b()) {
            tVar.a(dg.h);
            tVar.a(dgVar.b);
        }
        if (dgVar.c != null && dgVar.c()) {
            tVar.a(dg.i);
            dgVar.c.b(tVar);
        }
        tVar.d();
        tVar.c();
    }
}
