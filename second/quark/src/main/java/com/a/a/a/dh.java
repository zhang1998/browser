package com.a.a.a;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class dh extends ac<cv> {
    private dh() {
    }

    public final /* synthetic */ void a(t tVar, c cVar) throws g {
        int i = 0;
        cv cvVar = (cv) cVar;
        s sVar = (s) tVar;
        y yVar = new y((byte) 11, (byte) 12, sVar.n());
        cvVar.a = new HashMap(yVar.c * 2);
        for (int i2 = 0; i2 < yVar.c; i2++) {
            String q = sVar.q();
            do doVar = new do();
            doVar.a(sVar);
            cvVar.a.put(q, doVar);
        }
        BitSet a = sVar.a(2);
        if (a.get(0)) {
            m mVar = new m((byte) 12, sVar.n());
            cvVar.b = new ArrayList(mVar.b);
            while (i < mVar.b) {
                du duVar = new du();
                duVar.a(sVar);
                cvVar.b.add(duVar);
                i++;
            }
            cvVar.a(true);
        }
        if (a.get(1)) {
            cvVar.c = sVar.q();
        }
    }

    public final /* synthetic */ void b(t tVar, c cVar) throws g {
        cv cvVar = (cv) cVar;
        s sVar = (s) tVar;
        sVar.b(cvVar.a.size());
        for (Entry entry : cvVar.a.entrySet()) {
            sVar.a((String) entry.getKey());
            ((do) entry.getValue()).b(sVar);
        }
        BitSet bitSet = new BitSet();
        if (cvVar.a()) {
            bitSet.set(0);
        }
        if (cvVar.b()) {
            bitSet.set(1);
        }
        sVar.a(bitSet, 2);
        if (cvVar.a()) {
            sVar.b(cvVar.b.size());
            for (du b : cvVar.b) {
                b.b(sVar);
            }
        }
        if (cvVar.b()) {
            sVar.a(cvVar.c);
        }
    }
}
