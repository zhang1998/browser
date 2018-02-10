package com.a.a.a;

/* compiled from: ProGuard */
final class dy extends ab<dr> {
    private dy() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        dr drVar = (dr) cVar;
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
                            drVar.a = tVar.q();
                            break;
                        }
                    case (short) 2:
                        if (g.b != (byte) 10) {
                            p.a(tVar, g.b);
                            break;
                        }
                        drVar.b = tVar.o();
                        drVar.b();
                        break;
                    case (short) 3:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            drVar.c = tVar.q();
                            break;
                        }
                    default:
                        p.a(tVar, g.b);
                        break;
                }
            }
            tVar.f();
            if (f.a(drVar.d, 0)) {
                drVar.c();
                return;
            }
            throw new q("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        dr drVar = (dr) cVar;
        drVar.c();
        dr.f;
        tVar.b();
        if (drVar.a != null && drVar.a()) {
            tVar.a(dr.g);
            tVar.a(drVar.a);
        }
        tVar.a(dr.h);
        tVar.a(drVar.b);
        if (drVar.c != null) {
            tVar.a(dr.i);
            tVar.a(drVar.c);
        }
        tVar.d();
        tVar.c();
    }
}
