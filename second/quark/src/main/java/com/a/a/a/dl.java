package com.a.a.a;

/* compiled from: ProGuard */
final class dl extends ab<do> {
    private dl() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        do doVar = (do) cVar;
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
                            doVar.a = tVar.q();
                            break;
                        }
                    case (short) 2:
                        if (g.b != (byte) 10) {
                            p.a(tVar, g.b);
                            break;
                        }
                        doVar.b = tVar.o();
                        doVar.a();
                        break;
                    case (short) 3:
                        if (g.b != (byte) 8) {
                            p.a(tVar, g.b);
                            break;
                        }
                        doVar.c = tVar.n();
                        doVar.b();
                        break;
                    default:
                        p.a(tVar, g.b);
                        break;
                }
            }
            tVar.f();
            if (!f.a(doVar.d, 0)) {
                throw new q("Required field 'ts' was not found in serialized data! Struct: " + toString());
            } else if (f.a(doVar.d, 1)) {
                doVar.c();
                return;
            } else {
                throw new q("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        do doVar = (do) cVar;
        doVar.c();
        do.f;
        tVar.b();
        if (doVar.a != null) {
            tVar.a(do.g);
            tVar.a(doVar.a);
        }
        tVar.a(do.h);
        tVar.a(doVar.b);
        tVar.a(do.i);
        tVar.b(doVar.c);
        tVar.d();
        tVar.c();
    }
}
