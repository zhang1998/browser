package com.taobao.weex.ui.component.a;

import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.p;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class f {
    private p a;

    public f(p pVar) {
        this.a = pVar;
    }

    public static void a(ab abVar, Map<String, Map<String, ab>> map) {
        p parentScroller = abVar.getParentScroller();
        if (parentScroller != null) {
            Map map2 = (Map) map.get(parentScroller.getRef());
            if (map2 == null) {
                map2 = new ConcurrentHashMap();
            }
            if (!map2.containsKey(abVar.getRef())) {
                map2.put(abVar.getRef(), abVar);
                map.put(parentScroller.getRef(), map2);
            }
        }
    }

    public static void b(ab abVar, Map<String, Map<String, ab>> map) {
        p parentScroller = abVar.getParentScroller();
        if (parentScroller != null) {
            Map map2 = (Map) map.get(parentScroller.getRef());
            if (map2 != null) {
                map2.remove(abVar.getRef());
            }
        }
    }
}
