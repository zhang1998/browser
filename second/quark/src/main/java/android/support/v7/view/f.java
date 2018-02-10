package android.support.v7.view;

import android.support.v4.view.bo;
import android.support.v4.view.cy;
import android.support.v4.view.l;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class f {
    public final ArrayList<bo> a = new ArrayList();
    l b;
    boolean c;
    private long d = -1;
    private Interpolator e;
    private final cy f = new k(this);

    public final f a(bo boVar) {
        if (!this.c) {
            this.a.add(boVar);
        }
        return this;
    }

    public final void a() {
        if (!this.c) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                bo boVar = (bo) it.next();
                if (this.d >= 0) {
                    boVar.a(this.d);
                }
                if (this.e != null) {
                    Interpolator interpolator = this.e;
                    View view = (View) boVar.a.get();
                    if (view != null) {
                        bo.b.a(view, interpolator);
                    }
                }
                if (this.b != null) {
                    boVar.a(this.f);
                }
                boVar.b();
            }
            this.c = true;
        }
    }

    public final void b() {
        if (this.c) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((bo) it.next()).a();
            }
            this.c = false;
        }
    }

    public final f c() {
        if (!this.c) {
            this.d = 250;
        }
        return this;
    }

    public final f a(Interpolator interpolator) {
        if (!this.c) {
            this.e = interpolator;
        }
        return this;
    }

    public final f a(l lVar) {
        if (!this.c) {
            this.b = lVar;
        }
        return this;
    }
}
