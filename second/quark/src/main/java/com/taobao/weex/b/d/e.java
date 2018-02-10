package com.taobao.weex.b.d;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class e implements a {
    final /* synthetic */ f a;

    e(f fVar) {
        this.a = fVar;
    }

    public final void a(String str) {
        if (this.a.g != null) {
            Map hashMap = new HashMap(1);
            hashMap.put("data", str);
            this.a.g.b(hashMap);
        }
    }
}
