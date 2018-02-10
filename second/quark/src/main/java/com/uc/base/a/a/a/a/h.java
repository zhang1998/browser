package com.uc.base.a.a.a.a;

import com.uc.base.a.a.a.d.a;
import com.uc.base.a.a.a.d.b;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ b b;

    h(b bVar, f fVar) {
        this.b = bVar;
        this.a = fVar;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "cas.getCaptcha");
        b a = a.a(treeMap);
        if (this.a != null) {
            this.b.b(new a(this, a));
        }
    }
}
