package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class bo {
    public static final dg b;
    public WeakReference<View> a;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    bo(View view) {
        this.a = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            b = new cj();
        } else if (i >= 19) {
            b = new cc();
        } else if (i >= 18) {
            b = new do();
        } else if (i >= 16) {
            b = new bb();
        } else if (i >= 14) {
            b = new ct();
        } else {
            b = new ay();
        }
    }

    public final bo a(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, j);
        }
        return this;
    }

    public final bo a(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view, f);
        }
        return this;
    }

    public final bo b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.b(this, view, f);
        }
        return this;
    }

    public final bo c(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.c(this, view, f);
        }
        return this;
    }

    public final void a() {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view);
        }
    }

    public final void b() {
        View view = (View) this.a.get();
        if (view != null) {
            b.b(this, view);
        }
    }

    public final bo a(l lVar) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view, lVar);
        }
        return this;
    }

    public final bo a(p pVar) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, pVar);
        }
        return this;
    }
}
