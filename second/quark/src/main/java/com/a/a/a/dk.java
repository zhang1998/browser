package com.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class dk extends ab<cv> {
    private dk() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        cv cvVar = (cv) cVar;
        tVar.e();
        while (true) {
            l g = tVar.g();
            if (g.b != (byte) 0) {
                int i;
                switch (g.c) {
                    case (short) 1:
                        if (g.b != (byte) 13) {
                            p.a(tVar, g.b);
                            break;
                        }
                        y h = tVar.h();
                        cvVar.a = new HashMap(h.c * 2);
                        for (i = 0; i < h.c; i++) {
                            String q = tVar.q();
                            do doVar = new do();
                            doVar.a(tVar);
                            cvVar.a.put(q, doVar);
                        }
                        break;
                    case (short) 2:
                        if (g.b != (byte) 15) {
                            p.a(tVar, g.b);
                            break;
                        }
                        m i2 = tVar.i();
                        cvVar.b = new ArrayList(i2.b);
                        for (i = 0; i < i2.b; i++) {
                            du duVar = new du();
                            duVar.a(tVar);
                            cvVar.b.add(duVar);
                        }
                        cvVar.a(true);
                        break;
                    case (short) 3:
                        if (g.b != (byte) 11) {
                            p.a(tVar, g.b);
                            break;
                        } else {
                            cvVar.c = tVar.q();
                            break;
                        }
                    default:
                        p.a(tVar, g.b);
                        break;
                }
            }
            tVar.f();
            cvVar.c();
            return;
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        cv cvVar = (cv) cVar;
        cvVar.c();
        cv.e;
        tVar.b();
        if (cvVar.a != null) {
            tVar.a(cv.f);
            tVar.a(new y((byte) 11, (byte) 12, cvVar.a.size()));
            for (Entry entry : cvVar.a.entrySet()) {
                tVar.a((String) entry.getKey());
                ((do) entry.getValue()).b(tVar);
            }
        }
        if (cvVar.b != null && cvVar.a()) {
            tVar.a(cv.g);
            tVar.a(new m((byte) 12, cvVar.b.size()));
            for (du b : cvVar.b) {
                b.b(tVar);
            }
        }
        if (cvVar.c != null && cvVar.b()) {
            tVar.a(cv.h);
            tVar.a(cvVar.c);
        }
        tVar.d();
        tVar.c();
    }
}
