package android.mini.support.v4.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
final class i implements Set<K> {
    final /* synthetic */ l a;

    i(l lVar) {
        this.a = lVar;
    }

    public final boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.a.c();
    }

    public final boolean contains(Object obj) {
        return this.a.a(obj) >= 0;
    }

    public final boolean containsAll(Collection<?> collection) {
        Map b = this.a.b();
        for (Object containsKey : collection) {
            if (!b.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.a.a() == 0;
    }

    public final Iterator<K> iterator() {
        return new g(this.a, 0);
    }

    public final boolean remove(Object obj) {
        int a = this.a.a(obj);
        if (a < 0) {
            return false;
        }
        this.a.a(a);
        return true;
    }

    public final boolean removeAll(Collection<?> collection) {
        Map b = this.a.b();
        int size = b.size();
        for (Object remove : collection) {
            b.remove(remove);
        }
        return size != b.size();
    }

    public final boolean retainAll(Collection<?> collection) {
        return l.a(this.a.b(), (Collection) collection);
    }

    public final int size() {
        return this.a.a();
    }

    public final Object[] toArray() {
        return this.a.b(0);
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.a.a((Object[]) tArr, 0);
    }

    public final boolean equals(Object obj) {
        return l.a((Set) this, obj);
    }

    public final int hashCode() {
        int i = 0;
        for (int a = this.a.a() - 1; a >= 0; a--) {
            Object a2 = this.a.a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }
}
