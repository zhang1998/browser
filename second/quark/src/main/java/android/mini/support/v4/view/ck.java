package android.mini.support.v4.view;

import android.view.View;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class ck implements cr {
    WeakHashMap<View, Runnable> a = null;

    ck() {
    }

    public void a(View view, long j) {
    }

    public void a(cs csVar, View view, float f) {
        d(csVar, view);
    }

    public void b(cs csVar, View view, float f) {
        d(csVar, view);
    }

    public void c(cs csVar, View view, float f) {
        d(csVar, view);
    }

    public void a(cs csVar, View view) {
        d(csVar, view);
    }

    public void a(cs csVar, View view, cx cxVar) {
        view.setTag(2113929216, cxVar);
    }

    final void c(cs csVar, View view) {
        cx cxVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof cx) {
            cxVar = (cx) tag;
        } else {
            cxVar = null;
        }
        Runnable c = csVar.c;
        Runnable d = csVar.d;
        csVar.c = null;
        csVar.d = null;
        if (c != null) {
            c.run();
        }
        if (cxVar != null) {
            cxVar.a(view);
            cxVar.b(view);
        }
        if (d != null) {
            d.run();
        }
        if (this.a != null) {
            this.a.remove(view);
        }
    }

    private void d(cs csVar, View view) {
        Runnable runnable = null;
        if (this.a != null) {
            runnable = (Runnable) this.a.get(view);
        }
        if (runnable == null) {
            runnable = new cj(this, csVar, view);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public void b(cs csVar, View view) {
        if (this.a != null) {
            Runnable runnable = (Runnable) this.a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
        c(csVar, view);
    }
}
