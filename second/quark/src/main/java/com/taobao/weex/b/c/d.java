package com.taobao.weex.b.c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ h a;
    final /* synthetic */ g b;

    d(g gVar, h hVar) {
        this.b = gVar;
        this.a = hVar;
    }

    public final void run() {
        long b = this.b.b();
        Map hashMap = new HashMap(4);
        hashMap.put("result", "success");
        hashMap.put("data", Long.valueOf(b));
        if (this.a != null) {
            this.a.a(hashMap);
        }
    }
}
