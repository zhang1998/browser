package com.taobao.weex.ui;

import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ String b;
    final /* synthetic */ b c;

    g(Map map, String str, b bVar) {
        this.a = map;
        this.b = str;
        this.c = bVar;
    }

    public final void run() {
        try {
            Map map = this.a;
            if (map == null) {
                map = new HashMap();
            }
            map.put("type", this.b);
            map.put("methods", this.c.a());
            i.b(this.b, this.c);
            i.a(map);
            i.b.add(map);
        } catch (Throwable e) {
            WXLogUtils.e("register component error:", e);
        }
    }
}
