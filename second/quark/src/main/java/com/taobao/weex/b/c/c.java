package com.taobao.weex.b.c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;
    final /* synthetic */ g c;

    c(g gVar, String str, h hVar) {
        this.c = gVar;
        this.a = str;
        this.b = hVar;
    }

    public final void run() {
        boolean b = this.c.b(this.a);
        Map hashMap = new HashMap(4);
        hashMap.put("result", b ? "success" : "failed");
        hashMap.put("data", "undefined");
        if (this.b != null) {
            this.b.a(hashMap);
        }
    }
}
