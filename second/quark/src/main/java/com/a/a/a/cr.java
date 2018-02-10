package com.a.a.a;

import java.util.BitSet;

/* compiled from: ProGuard */
final class cr extends ac<dg> {
    private cr() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        dg dgVar = (dg) cVar;
        s sVar = (s) tVar;
        dgVar.a = sVar.n();
        dgVar.a();
        BitSet a = sVar.a(2);
        if (a.get(0)) {
            dgVar.b = sVar.q();
        }
        if (a.get(1)) {
            dgVar.c = new dx();
            dgVar.c.a(sVar);
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        dg dgVar = (dg) cVar;
        s sVar = (s) tVar;
        sVar.b(dgVar.a);
        BitSet bitSet = new BitSet();
        if (dgVar.b()) {
            bitSet.set(0);
        }
        if (dgVar.c()) {
            bitSet.set(1);
        }
        sVar.a(bitSet, 2);
        if (dgVar.b()) {
            sVar.a(dgVar.b);
        }
        if (dgVar.c()) {
            dgVar.c.b(sVar);
        }
    }
}
