package android.mini.support.v4.d;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: ProGuard */
final class k implements Collection<V> {
    final /* synthetic */ l a;

    k(l lVar) {
        this.a = lVar;
    }

    public final boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.a.c();
    }

    public final boolean contains(Object obj) {
        return this.a.b(obj) >= 0;
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

    public final Iterator<V> iterator() {
        return new g(this.a, 1);
    }

    public final boolean remove(Object obj) {
        int b = this.a.b(obj);
        if (b < 0) {
            return false;
        }
        this.a.a(b);
        return true;
    }

    public final boolean removeAll(Collection<?> collection) {
        int i = 0;
        int a = this.a.a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        int i = 0;
        int a = this.a.a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final int size() {
        return this.a.a();
    }

    public final Object[] toArray() {
        return this.a.b(1);
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.a.a((Object[]) tArr, 1);
    }
}
