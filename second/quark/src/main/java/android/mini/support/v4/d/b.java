package android.mini.support.v4.d;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class b<K, V> extends q<K, V> implements Map<K, V> {
    l<K, V> a;

    public b(int i) {
        super(i);
    }

    private l<K, V> a() {
        if (this.a == null) {
            this.a = new a(this);
        }
        return this.a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.h + map.size();
        if (this.f.length < size) {
            Object obj = this.f;
            Object obj2 = this.g;
            super.a(size);
            if (this.h > 0) {
                System.arraycopy(obj, 0, this.f, 0, this.h);
                System.arraycopy(obj2, 0, this.g, 0, this.h << 1);
            }
            q.a(obj, obj2, this.h);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        l a = a();
        if (a.b == null) {
            a.b = new h(a);
        }
        return a.b;
    }

    public Set<K> keySet() {
        l a = a();
        if (a.c == null) {
            a.c = new i(a);
        }
        return a.c;
    }

    public Collection<V> values() {
        l a = a();
        if (a.d == null) {
            a.d = new k(a);
        }
        return a.d;
    }
}
