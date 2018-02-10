package android.mini.support.v4.d;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class j implements Iterator<Entry<K, V>>, Entry<K, V> {
    int a;
    int b;
    boolean c = false;
    final /* synthetic */ l d;

    j(l lVar) {
        this.d = lVar;
        this.a = lVar.a() - 1;
        this.b = -1;
    }

    public final boolean hasNext() {
        return this.b < this.a;
    }

    public final void remove() {
        if (this.c) {
            this.d.a(this.b);
            this.b--;
            this.a--;
            this.c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public final K getKey() {
        if (this.c) {
            return this.d.a(this.b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final V getValue() {
        if (this.c) {
            return this.d.a(this.b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final V setValue(V v) {
        if (this.c) {
            return this.d.a(this.b, (Object) v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean equals(Object obj) {
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (c.a(entry.getKey(), this.d.a(this.b, 0)) && c.a(entry.getValue(), this.d.a(this.b, 1))) {
                return true;
            }
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        if (this.c) {
            Object a = this.d.a(this.b, 0);
            Object a2 = this.d.a(this.b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.b++;
        this.c = true;
        return this;
    }
}
