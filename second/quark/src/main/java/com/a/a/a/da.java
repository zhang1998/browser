package com.a.a.a;

import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class da extends ac<dx> {
    private da() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        dx dxVar = (dx) cVar;
        s sVar = (s) tVar;
        y yVar = new y((byte) 11, (byte) 12, sVar.n());
        dxVar.a = new HashMap(yVar.c * 2);
        for (int i = 0; i < yVar.c; i++) {
            String q = sVar.q();
            dr drVar = new dr();
            drVar.a(sVar);
            dxVar.a.put(q, drVar);
        }
        dxVar.b = sVar.n();
        dxVar.b();
        dxVar.c = sVar.q();
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        dx dxVar = (dx) cVar;
        s sVar = (s) tVar;
        sVar.b(dxVar.a.size());
        for (Entry entry : dxVar.a.entrySet()) {
            sVar.a((String) entry.getKey());
            ((dr) entry.getValue()).b(sVar);
        }
        sVar.b(dxVar.b);
        sVar.a(dxVar.c);
    }
}
