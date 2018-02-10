package com.a.a.a;

/* compiled from: ProGuard */
final class dn extends ab<du> {
    private dn() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        du duVar = (du) cVar;
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
                            duVar.a = tVar.q();
                            break;
                        }
                    case (short) 2:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            duVar.b = tVar.q();
                            break;
                        }
                    case (short) 3:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            duVar.c = tVar.q();
                            break;
                        }
                    case (short) 4:
                        if (g.b != (byte) 10) {
                            p.a(tVar, g.b);
                            break;
                        }
                        duVar.d = tVar.o();
                        duVar.b();
                        break;
                    default:
                        p.a(tVar, g.b);
                        break;
                }
            }
            tVar.f();
            if (f.a(duVar.e, 0)) {
                duVar.c();
                return;
            }
            throw new q("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        du duVar = (du) cVar;
        duVar.c();
        du.g;
        tVar.b();
        if (duVar.a != null) {
            tVar.a(du.h);
            tVar.a(duVar.a);
        }
        if (duVar.b != null && duVar.a()) {
            tVar.a(du.i);
            tVar.a(duVar.b);
        }
        if (duVar.c != null) {
            tVar.a(du.j);
            tVar.a(duVar.c);
        }
        tVar.a(du.k);
        tVar.a(duVar.d);
        tVar.d();
        tVar.c();
    }
}
