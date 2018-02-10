package android.mini.support.v4.b;

import android.mini.support.v4.d.d;

/* compiled from: ProGuard */
public final class c<D> {
    public int a;
    public b<D> b;
    public a<D> c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public final void a(b<D> bVar) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.b != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.b = null;
        }
    }

    public final void a(a<D> aVar) {
        if (this.c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.c != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.c = null;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
