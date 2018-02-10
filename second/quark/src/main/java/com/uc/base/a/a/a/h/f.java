package com.uc.base.a.a.a.h;

import com.uc.base.a.a.a.d.a;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;
    final /* synthetic */ e c;
    final /* synthetic */ b d;

    f(b bVar, String str, e eVar, e eVar2) {
        this.d = bVar;
        this.a = str;
        this.b = eVar;
        this.c = eVar2;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "account.getProfileByServiceTicket");
        treeMap.put("service_ticket", this.a);
        this.d.b(new c(this, a.a(treeMap)));
    }
}
