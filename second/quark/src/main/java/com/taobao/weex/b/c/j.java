package com.taobao.weex.b.c;

import android.mini.support.annotation.Nullable;
import com.taobao.weex.bridge.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class j {
    public static Map<String, Object> a(boolean z) {
        Map<String, Object> hashMap = new HashMap(4);
        hashMap.put("result", z ? "success" : "failed");
        hashMap.put("data", "undefined");
        return hashMap;
    }

    private static void a(@Nullable c cVar, String str, Object obj) {
        if (cVar != null) {
            Map hashMap = new HashMap(4);
            hashMap.put("result", str);
            hashMap.put("data", obj);
            cVar.a(hashMap);
        }
    }

    public static void a(@Nullable c cVar) {
        a(cVar, "failed", "no_handler");
    }

    public static void b(@Nullable c cVar) {
        a(cVar, "failed", "invalid_param");
    }
}
