package com.alibaba.analytics.core.h.a;

import com.alibaba.analytics.a.af;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (com.alibaba.analytics.core.b.a().b != null) {
            List arrayList = new ArrayList(a.a.size());
            for (String str : a.a.keySet()) {
                arrayList.add(new c(str, (String) a.a.get(str)));
            }
            com.alibaba.analytics.core.b.a().n.c(c.class);
            com.alibaba.analytics.core.b.a().n.a(arrayList);
            return;
        }
        af.c("storeTask.run()", "context", com.alibaba.analytics.core.b.a().b);
    }
}
