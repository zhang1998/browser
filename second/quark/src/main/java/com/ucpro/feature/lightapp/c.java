package com.ucpro.feature.lightapp;

import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;

/* compiled from: ProGuard */
public abstract class c implements com.ucpro.base.c.b.c, a {
    private boolean a;
    public final m e;
    public n f;
    public final com.ucpro.base.weex.c g;

    public abstract void a();

    public abstract String b();

    public abstract String c();

    public c(m mVar, com.ucpro.base.weex.c cVar) {
        this.e = mVar;
        this.g = cVar;
    }

    public final void a(n nVar) {
        this.f = nVar;
        if (this.f instanceof g) {
            ((g) this.f).setWindowCallBacks(this);
        }
    }

    public void f() {
        if (this.f != null && !this.a) {
            this.a = true;
            a(true);
        }
    }

    public final void g() {
        if (this.f instanceof g) {
            this.e.a((g) this.f, true);
        }
    }

    public final void a(boolean z) {
        this.e.a(z);
    }

    public final void a(g gVar, byte b) {
        if (b == (byte) 13) {
            a();
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        return false;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.e.b((g) view);
        }
        return null;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final boolean h() {
        return this.f != null && this.e.a() == this.f;
    }
}
