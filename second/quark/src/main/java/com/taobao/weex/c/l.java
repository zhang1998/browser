package com.taobao.weex.c;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
final class l implements ad {
    final ConcurrentHashMap<String, ae> a;

    l(ConcurrentHashMap<String, ae> concurrentHashMap) {
        this.a = concurrentHashMap;
    }

    public final void a(ae aeVar) {
        this.a.remove(aeVar.q);
    }
}
