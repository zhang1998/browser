package com.a.a.a;

import java.util.BitSet;

/* compiled from: ProGuard */
final class cw extends ac<du> {
    private cw() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        du duVar = (du) cVar;
        s sVar = (s) tVar;
        duVar.a = sVar.q();
        duVar.c = sVar.q();
        duVar.d = sVar.o();
        duVar.b();
        if (sVar.a(1).get(0)) {
            duVar.b = sVar.q();
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        du duVar = (du) cVar;
        s sVar = (s) tVar;
        sVar.a(duVar.a);
        sVar.a(duVar.c);
        sVar.a(duVar.d);
        BitSet bitSet = new BitSet();
        if (duVar.a()) {
            bitSet.set(0);
        }
        sVar.a(bitSet, 1);
        if (duVar.a()) {
            sVar.a(duVar.b);
        }
    }
}
