package com.taobao.weex.b.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ h a;
    final /* synthetic */ g b;

    e(g gVar, h hVar) {
        this.b = gVar;
        this.a = hVar;
    }

    public final void run() {
        Object c = this.b.c();
        if (c == null) {
            c = new ArrayList(1);
        }
        Map hashMap = new HashMap(4);
        hashMap.put("result", "success");
        hashMap.put("data", c);
        if (this.a != null) {
            this.a.a(hashMap);
        }
    }
}
