package com.taobao.weex.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class l implements c<String, List<V>> {
    final /* synthetic */ n a;

    l(n nVar) {
        this.a = nVar;
    }

    public final Map<String, List<V>> a(String str, List<String> list) {
        Map<String, List<V>> hashMap = new HashMap();
        List linkedList = new LinkedList();
        for (String a : list) {
            linkedList.add(this.a.a(a));
        }
        hashMap.put(str, linkedList);
        return hashMap;
    }
}
