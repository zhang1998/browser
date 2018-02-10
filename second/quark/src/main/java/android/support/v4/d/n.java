package android.support.v4.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
final class n implements Set<Entry<K, V>> {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int a = this.a.a();
        for (Entry entry : collection) {
            this.a.a(entry.getKey(), entry.getValue());
        }
        return a != this.a.a();
    }

    public final void clear() {
        this.a.c();
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.a.a(entry.getKey());
        if (a >= 0) {
            return j.a(this.a.a(a, 1), entry.getValue());
        }
        return false;
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.a.a() == 0;
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new h(this.a);
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.a.a();
    }

    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public final <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        return l.a((Set) this, obj);
    }

    public final int hashCode() {
        int a = this.a.a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.a.a(a, 0);
            Object a3 = this.a.a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }
}
