package android.support.v4.d;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class b<K, V> extends s<K, V> implements Map<K, V> {
    l<K, V> a;

    private l<K, V> a() {
        if (this.a == null) {
            this.a = new k(this);
        }
        return this.a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        l a = a();
        if (a.b == null) {
            a.b = new n(a);
        }
        return a.b;
    }

    public Set<K> keySet() {
        l a = a();
        if (a.c == null) {
            a.c = new a(a);
        }
        return a.c;
    }

    public Collection<V> values() {
        l a = a();
        if (a.d == null) {
            a.d = new d(a);
        }
        return a.d;
    }
}
