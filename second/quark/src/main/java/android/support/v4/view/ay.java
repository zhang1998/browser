package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class ay implements dg {
    WeakHashMap<View, Runnable> a = null;

    ay() {
    }

    public void a(View view, long j) {
    }

    public void a(bo boVar, View view, float f) {
        d(boVar, view);
    }

    public void b(bo boVar, View view, float f) {
        d(boVar, view);
    }

    public void c(bo boVar, View view, float f) {
        d(boVar, view);
    }

    public long a(View view) {
        return 0;
    }

    public void a(View view, Interpolator interpolator) {
    }

    public void b(View view, long j) {
    }

    public void a(bo boVar, View view) {
        d(boVar, view);
    }

    public void a(bo boVar, View view, l lVar) {
        view.setTag(2113929216, lVar);
    }

    public void a(View view, p pVar) {
    }

    final void c(bo boVar, View view) {
        l lVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof l) {
            lVar = (l) tag;
        } else {
            lVar = null;
        }
        Runnable c = boVar.c;
        Runnable d = boVar.d;
        boVar.c = null;
        boVar.d = null;
        if (c != null) {
            c.run();
        }
        if (lVar != null) {
            lVar.a(view);
            lVar.b(view);
        }
        if (d != null) {
            d.run();
        }
        if (this.a != null) {
            this.a.remove(view);
        }
    }

    private void d(bo boVar, View view) {
        Runnable runnable = null;
        if (this.a != null) {
            runnable = (Runnable) this.a.get(view);
        }
        if (runnable == null) {
            runnable = new al(this, boVar, view);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public void b(bo boVar, View view) {
        if (this.a != null) {
            Runnable runnable = (Runnable) this.a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
        c(boVar, view);
    }
}
