package com.uc.base.a.a.a.e;

import com.uc.base.a.a.a.d.a;
import com.uc.base.a.a.a.d.b;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ n b;
    final /* synthetic */ j c;

    o(j jVar, String str, n nVar) {
        this.c = jVar;
        this.a = str;
        this.b = nVar;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "cas.getUserBasicInfoByServiceTicket");
        treeMap.put("service_ticket", this.a);
        b a = a.a(treeMap);
        com.uc.base.a.a.a.h.a b;
        if (a.a() == 20000) {
            b = com.uc.base.a.a.a.h.a.b(a.c);
            com.uc.base.a.a.a.h.b.a = b;
            com.uc.base.a.a.a.h.a.a(b);
            this.b.a();
        } else if (a.a() == 20002) {
            i a2 = i.a(a.c);
            a2.a();
            b = com.uc.base.a.a.a.h.a.b(a.c);
            com.uc.base.a.a.a.h.b.a = b;
            com.uc.base.a.a.a.h.a.a(b);
            this.b.a(a2.e);
        } else if (a.a() == 50051 || a.a() == 50052 || a.a() == 50055) {
            j.a();
            this.b.b();
        } else {
            this.b.b(a);
        }
    }
}
