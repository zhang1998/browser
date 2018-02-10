package com.taobao.android.binding.core;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class a<K, V> extends LinkedHashMap<K, V> {
    private int a = Math.max(16, 4);

    a() {
        super(4, 0.75f, true);
    }

    protected final boolean removeEldestEntry(Entry entry) {
        return size() > this.a;
    }
}
