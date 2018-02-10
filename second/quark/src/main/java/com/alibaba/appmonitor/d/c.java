package com.alibaba.appmonitor.d;

import com.alibaba.appmonitor.e.b;
import com.alibaba.appmonitor.f.d;
import com.alibaba.appmonitor.f.f;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;

/* compiled from: ProGuard */
public final class c {
    public static void a(Transaction transaction) {
        if (transaction != null && transaction.d != null) {
            f fVar;
            d a = d.a();
            String str = transaction.e;
            Integer num = transaction.a;
            String str2 = transaction.b;
            String str3 = transaction.c;
            DimensionValueSet a2 = DimensionValueSet.c().a(transaction.d);
            synchronized (f.class) {
                fVar = (f) a.a.get(str);
                if (fVar == null) {
                    fVar = (f) b.a().a(f.class, num, str2, str3);
                    a.a.put(str, fVar);
                }
            }
            if (fVar.b == null) {
                fVar.b = a2;
            } else {
                fVar.b.a(a2);
            }
        }
    }
}
