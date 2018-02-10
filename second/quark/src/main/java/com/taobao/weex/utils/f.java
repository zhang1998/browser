package com.taobao.weex.utils;

import android.mini.support.annotation.NonNull;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class f<K, V> {
    private c<K, V> a;
    private b b;

    public f(@NonNull String str, @NonNull c<K, V> cVar) {
        this.b = new b(str);
        this.a = cVar;
    }

    public final LinkedHashMap<K, V> a() {
        b.a(this.b);
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap();
        do {
            linkedHashMap.putAll(b());
        } while (this.b.a == d.a);
        return linkedHashMap;
    }

    private Map<K, V> b() {
        List linkedList = new LinkedList();
        String a = a(d.a);
        a(d.c);
        linkedList.add(a(d.b));
        while (this.b.a == d.e) {
            a(d.e);
            linkedList.add(a(d.b));
        }
        a(d.d);
        return this.a.a(a, linkedList);
    }

    private String a(int i) {
        if (i == this.b.a) {
            String str = this.b.b;
            b.a(this.b);
            return str;
        }
        throw new e("Token doesn't match");
    }
}
