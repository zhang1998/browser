package com.a.a.a;

import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class cp extends ab<dx> {
    private cp() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        dx dxVar = (dx) cVar;
        tVar.e();
        while (true) {
            l g = tVar.g();
            if (g.b != (byte) 0) {
                switch (g.c) {
                    case (short) 1:
                        if (g.b != (byte) 13) {
                            p.a(tVar, g.b);
                            break;
                        }
                        y h = tVar.h();
                        dxVar.a = new HashMap(h.c * 2);
                        for (int i = 0; i < h.c; i++) {
                            String q = tVar.q();
                            dr drVar = new dr();
                            drVar.a(tVar);
                            dxVar.a.put(q, drVar);
                        }
                        break;
                    case (short) 2:
                        if (g.b != (byte) 8) {
                            p.a(tVar, g.b);
                            break;
                        }
                        dxVar.b = tVar.n();
                        dxVar.b();
                        break;
                    case (short) 3:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            dxVar.c = tVar.q();
                            break;
                        }
                    default:
                        p.a(tVar, g.b);
                        break;
                }
            }
            tVar.f();
            if (f.a(dxVar.d, 0)) {
                dxVar.c();
                return;
            }
            throw new q("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        dx dxVar = (dx) cVar;
        dxVar.c();
        dx.f;
        tVar.b();
        if (dxVar.a != null) {
            tVar.a(dx.g);
            tVar.a(new y((byte) 11, (byte) 12, dxVar.a.size()));
            for (Entry entry : dxVar.a.entrySet()) {
                tVar.a((String) entry.getKey());
                ((dr) entry.getValue()).b(tVar);
            }
        }
        tVar.a(dx.h);
        tVar.b(dxVar.b);
        if (dxVar.c != null) {
            tVar.a(dx.i);
            tVar.a(dxVar.c);
        }
        tVar.d();
        tVar.c();
    }
}
