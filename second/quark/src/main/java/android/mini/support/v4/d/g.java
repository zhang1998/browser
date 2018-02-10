package android.mini.support.v4.d;

import java.util.Iterator;

/* compiled from: ProGuard */
final class g<T> implements Iterator<T> {
    final int a;
    int b;
    int c;
    boolean d = false;
    final /* synthetic */ l e;

    g(l lVar, int i) {
        this.e = lVar;
        this.a = i;
        this.b = lVar.a();
    }

    public final boolean hasNext() {
        return this.c < this.b;
    }

    public final T next() {
        T a = this.e.a(this.c, this.a);
        this.c++;
        this.d = true;
        return a;
    }

    public final void remove() {
        if (this.d) {
            this.c--;
            this.b--;
            this.d = false;
            this.e.a(this.c);
            return;
        }
        throw new IllegalStateException();
    }
}
