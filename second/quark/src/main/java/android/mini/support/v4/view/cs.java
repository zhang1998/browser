package android.mini.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class cs {
    static final cr a;
    private WeakReference<View> b;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    cs(View view) {
        this.b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new cq();
        } else if (i >= 19) {
            a = new cp();
        } else if (i >= 18) {
            a = new cn();
        } else if (i >= 16) {
            a = new co();
        } else if (i >= 14) {
            a = new cm();
        } else {
            a = new ck();
        }
    }

    public final cs a(long j) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(view, j);
        }
        return this;
    }

    public final cs a(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, f);
        }
        return this;
    }

    public final cs b(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view, f);
        }
        return this;
    }

    public final cs c(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.c(this, view, f);
        }
        return this;
    }

    public final void a() {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view);
        }
    }

    public final void b() {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view);
        }
    }

    public final cs a(cx cxVar) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, cxVar);
        }
        return this;
    }
}
