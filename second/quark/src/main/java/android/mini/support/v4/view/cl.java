package android.mini.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ProGuard */
final class cl implements cx {
    cs a;
    boolean b;

    cl(cs csVar) {
        this.a = csVar;
    }

    public final void a(View view) {
        cx cxVar;
        this.b = false;
        if (this.a.e >= 0) {
            ViewCompat.a(view, 2, null);
        }
        if (this.a.c != null) {
            Runnable c = this.a.c;
            this.a.c = null;
            c.run();
        }
        Object tag = view.getTag(2113929216);
        if (tag instanceof cx) {
            cxVar = (cx) tag;
        } else {
            cxVar = null;
        }
        if (cxVar != null) {
            cxVar.a(view);
        }
    }

    public final void b(View view) {
        if (this.a.e >= 0) {
            ViewCompat.a(view, this.a.e, null);
            this.a.e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.b) {
            cx cxVar;
            if (this.a.d != null) {
                Runnable d = this.a.d;
                this.a.d = null;
                d.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof cx) {
                cxVar = (cx) tag;
            } else {
                cxVar = null;
            }
            if (cxVar != null) {
                cxVar.b(view);
            }
            this.b = true;
        }
    }

    public final void c(View view) {
        cx cxVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof cx) {
            cxVar = (cx) tag;
        } else {
            cxVar = null;
        }
        if (cxVar != null) {
            cxVar.c(view);
        }
    }
}
