package com.a.a.a;

import java.util.BitSet;

/* compiled from: ProGuard */
final class cx extends ac<dr> {
    private cx() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        dr drVar = (dr) cVar;
        s sVar = (s) tVar;
        drVar.b = sVar.o();
        drVar.b();
        drVar.c = sVar.q();
        if (sVar.a(1).get(0)) {
            drVar.a = sVar.q();
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        dr drVar = (dr) cVar;
        s sVar = (s) tVar;
        sVar.a(drVar.b);
        sVar.a(drVar.c);
        BitSet bitSet = new BitSet();
        if (drVar.a()) {
            bitSet.set(0);
        }
        sVar.a(bitSet, 1);
        if (drVar.a()) {
            sVar.a(drVar.a);
        }
    }
}
