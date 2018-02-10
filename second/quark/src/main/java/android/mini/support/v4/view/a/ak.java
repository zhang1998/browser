package android.mini.support.v4.view.a;

import android.os.Build.VERSION;

/* compiled from: ProGuard */
public final class ak {
    private static final ah a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new ai();
        } else if (VERSION.SDK_INT >= 15) {
            a = new ag();
        } else if (VERSION.SDK_INT >= 14) {
            a = new af();
        } else {
            a = new aj();
        }
    }

    @Deprecated
    public ak(Object obj) {
        this.b = obj;
    }

    public final void a(boolean z) {
        a.a(this.b, z);
    }

    public final void a(int i) {
        a.b(this.b, i);
    }

    public final void b(int i) {
        a.a(this.b, i);
    }

    public final void c(int i) {
        a.c(this.b, i);
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
        ak akVar = (ak) obj;
        if (this.b == null) {
            if (akVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(akVar.b)) {
            return true;
        } else {
            return false;
        }
    }
}
