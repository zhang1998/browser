package com.a.a.a;

import java.util.BitSet;

/* compiled from: ProGuard */
final class bi extends ac<bn> {
    private bi() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        bn bnVar = (bn) cVar;
        s sVar = (s) tVar;
        bnVar.a = sVar.q();
        bnVar.b = sVar.q();
        bnVar.c = sVar.q();
        bnVar.d = sVar.n();
        bnVar.a();
        bnVar.e = sVar.n();
        bnVar.b();
        bnVar.f = sVar.n();
        bnVar.c();
        bnVar.g = sVar.r();
        bnVar.h = sVar.q();
        bnVar.i = sVar.q();
        if (sVar.a(1).get(0)) {
            bnVar.j = sVar.n();
            bnVar.e();
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        bn bnVar = (bn) cVar;
        s sVar = (s) tVar;
        sVar.a(bnVar.a);
        sVar.a(bnVar.b);
        sVar.a(bnVar.c);
        sVar.b(bnVar.d);
        sVar.b(bnVar.e);
        sVar.b(bnVar.f);
        sVar.a(bnVar.g);
        sVar.a(bnVar.h);
        sVar.a(bnVar.i);
        BitSet bitSet = new BitSet();
        if (bnVar.d()) {
            bitSet.set(0);
        }
        sVar.a(bitSet, 1);
        if (bnVar.d()) {
            sVar.b(bnVar.j);
        }
    }
}
