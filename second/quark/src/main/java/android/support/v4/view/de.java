package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ProGuard */
final class de implements l {
    bo a;
    boolean b;

    de(bo boVar) {
        this.a = boVar;
    }

    public final void a(View view) {
        l lVar;
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
        if (tag instanceof l) {
            lVar = (l) tag;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            lVar.a(view);
        }
    }

    public final void b(View view) {
        if (this.a.e >= 0) {
            ViewCompat.a(view, this.a.e, null);
            this.a.e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.b) {
            l lVar;
            if (this.a.d != null) {
                Runnable d = this.a.d;
                this.a.d = null;
                d.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof l) {
                lVar = (l) tag;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                lVar.b(view);
            }
            this.b = true;
        }
    }

    public final void c(View view) {
        l lVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof l) {
            lVar = (l) tag;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            lVar.c(view);
        }
    }
}
