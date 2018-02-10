package android.support.v7.app;

import android.content.Context;
import android.support.v7.view.d;
import android.support.v7.view.h;
import android.support.v7.view.i;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class ag extends h implements z {
    final /* synthetic */ ao c;
    private final Context d;
    private final u e;
    private d f;
    private WeakReference<View> g;

    public ag(ao aoVar, Context context, d dVar) {
        this.c = aoVar;
        this.d = context;
        this.f = dVar;
        u uVar = new u(context);
        this.e = uVar;
        this.e.a((z) this);
    }

    public final MenuInflater h() {
        return new i(this.d);
    }

    public final Menu d() {
        return this.e;
    }

    public final void c() {
        if (this.c.a == this) {
            if (ao.a(this.c.D, this.c.E, false)) {
                this.f.a(this);
            } else {
                this.c.b = this;
                this.c.c = this.f;
            }
            this.f = null;
            this.c.e(false);
            ActionBarContextView h = this.c.s;
            if (h.a == null) {
                h.a();
            }
            this.c.r.a().sendAccessibilityEvent(32);
            this.c.p.setHideOnContentScrollEnabled(this.c.d);
            this.c.a = null;
        }
    }

    public final void b() {
        if (this.c.a == this) {
            this.e.e();
            try {
                this.f.b(this, this.e);
            } finally {
                this.e.f();
            }
        }
    }

    public final boolean i() {
        this.e.e();
        try {
            boolean a = this.f.a((h) this, this.e);
            return a;
        } finally {
            this.e.f();
        }
    }

    public final void a(View view) {
        this.c.s.setCustomView(view);
        this.g = new WeakReference(view);
    }

    public final void b(CharSequence charSequence) {
        this.c.s.setSubtitle(charSequence);
    }

    public final void a(CharSequence charSequence) {
        this.c.s.setTitle(charSequence);
    }

    public final void a(int i) {
        a(this.c.l.getResources().getString(i));
    }

    public final void b(int i) {
        b(this.c.l.getResources().getString(i));
    }

    public final CharSequence e() {
        return this.c.s.getTitle();
    }

    public final CharSequence f() {
        return this.c.s.getSubtitle();
    }

    public final void a(boolean z) {
        super.a(z);
        this.c.s.setTitleOptional(z);
    }

    public final boolean a() {
        return this.c.s.b;
    }

    public final View g() {
        return this.g != null ? (View) this.g.get() : null;
    }

    public final boolean a(u uVar, MenuItem menuItem) {
        if (this.f != null) {
            return this.f.a((h) this, menuItem);
        }
        return false;
    }

    public final void a(u uVar) {
        if (this.f != null) {
            b();
            this.c.s.b();
        }
    }
}
