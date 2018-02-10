package com.taobao.weex.bridge;

import java.util.HashMap;
import java.util.Stack;

/* compiled from: ProGuard */
public final class t<K, V> extends HashMap<K, V> {
    Stack<String> a = new Stack();

    public final V put(K k, V v) {
        if (!(k == null || k.toString() == null)) {
            if (this.a.contains(k)) {
                this.a.remove(k);
            }
            this.a.push(k.toString());
        }
        return super.put(k, v);
    }

    public final V remove(Object obj) {
        return super.remove(obj);
    }

    public final V a(Object obj) {
        this.a.remove(obj);
        return super.remove(obj);
    }
}
