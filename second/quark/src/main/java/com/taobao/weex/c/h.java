package com.taobao.weex.c;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
final class h implements ad {
    final ConcurrentHashMap<String, ae> a;

    h(ConcurrentHashMap<String, ae> concurrentHashMap) {
        this.a = concurrentHashMap;
    }

    public final void a(ae aeVar) {
        aeVar.x = true;
        this.a.put(aeVar.q, aeVar);
        ae aeVar2 = (ae) this.a.get("_root");
        if (aeVar2 != null && aeVar.f()) {
            String str = aeVar.q;
            if (aeVar2.w == null) {
                aeVar2.w = new ArrayList();
            }
            aeVar2.w.add(str);
        }
    }
}
