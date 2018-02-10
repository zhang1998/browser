package com.uc.base.a.a.a.a;

import com.uc.base.a.a.a.d.a;
import com.uc.base.a.a.a.d.b;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ f b;
    final /* synthetic */ b c;

    g(b bVar, String str, f fVar) {
        this.c = bVar;
        this.a = str;
        this.b = fVar;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "aegis.estimateMobileDownSmsLoginRisk");
        treeMap.put("mobile", this.a);
        b a = a.a(treeMap);
        if (this.b != null) {
            this.c.b(new e(this, a));
        }
    }
}
