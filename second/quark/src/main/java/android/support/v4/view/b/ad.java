package android.support.v4.view.b;

import android.os.Build.VERSION;

/* compiled from: ProGuard */
public final class ad {
    public static final ak a;
    public final Object b;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new ac();
        } else if (VERSION.SDK_INT >= 15) {
            a = new g();
        } else if (VERSION.SDK_INT >= 14) {
            a = new j();
        } else {
            a = new x();
        }
    }

    public ad(Object obj) {
        this.b = obj;
    }

    public final void a(boolean z) {
        a.a(this.b, z);
    }

    public final void a(int i) {
        a.d(this.b, i);
    }

    public final void b(int i) {
        a.c(this.b, i);
    }

    public final void c(int i) {
        a.g(this.b, i);
    }

    public final int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.b == null) {
            if (adVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(adVar.b)) {
            return true;
        } else {
            return false;
        }
    }
}
