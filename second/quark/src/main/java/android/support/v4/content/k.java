package android.support.v4.content;

import android.support.v4.d.f;

/* compiled from: ProGuard */
public final class k<D> {
    public int a;
    public i<D> b;
    public c<D> c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public final void a(i<D> iVar) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.b != iVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.b = null;
        }
    }

    public final void a(c<D> cVar) {
        if (this.c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.c != cVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.c = null;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        f.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
