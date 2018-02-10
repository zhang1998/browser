package com.taobao.weex.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class m implements c<String, List<V>> {
    final /* synthetic */ o a;

    m(o oVar) {
        this.a = oVar;
    }

    public final Map<String, List<V>> a(String str, List<String> list) {
        Map<String, List<V>> hashMap = new HashMap();
        hashMap.put(str, this.a.a(list));
        return hashMap;
    }
}
