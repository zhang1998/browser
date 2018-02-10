package com.taobao.weex.b.c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;
    final /* synthetic */ g c;

    b(g gVar, String str, h hVar) {
        this.c = gVar;
        this.a = str;
        this.b = hVar;
    }

    public final void run() {
        Object obj;
        String a = this.c.a(this.a);
        Map hashMap = new HashMap(4);
        hashMap.put("result", a != null ? "success" : "failed");
        String str = "data";
        if (a != null) {
            obj = a;
        } else {
            obj = "undefined";
        }
        hashMap.put(str, obj);
        if (this.b != null) {
            this.b.a(hashMap);
        }
    }
}
