package com.uc.base.a.a.a.e;

import com.uc.base.a.a.a.d.a;
import com.uc.base.a.a.a.d.b;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ j c;

    f(j jVar, String str, c cVar) {
        this.c = jVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "cas.logout");
        treeMap.put("service_ticket", this.a);
        b a = a.a(treeMap);
        if (this.b != null) {
            this.c.b(new h(this, a));
        }
    }
}
