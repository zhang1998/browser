package com.uc.quark.filedownloader.a;

import com.uc.quark.filedownloader.e.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class d extends RuntimeException {
    public final int a;
    private final Map<String, List<String>> b;
    private final Map<String, List<String>> c;

    public d(int i, Map<String, List<String>> map, Map<String, List<String>> map2) {
        super(b.a("response code error: %d, \n request headers: %s \n response headers: %s", Integer.valueOf(i), map, map2));
        this.a = i;
        this.b = a(map);
        this.c = a(map);
    }

    private static Map<String, List<String>> a(Map<String, List<String>> map) {
        Map<String, List<String>> hashMap = new HashMap();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                hashMap.put((String) entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
        }
        return hashMap;
    }
}
