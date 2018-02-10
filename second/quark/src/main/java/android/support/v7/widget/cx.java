package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.support.v7.c.d;
import android.support.v7.c.e;
import android.support.v7.c.h;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.r;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class cx implements bt {
    Toolbar a;
    CharSequence b;
    Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private final fb p;
    private int q;
    private Drawable r;

    public cx(Toolbar toolbar) {
        this(toolbar, e.abc_action_bar_up_description, d.abc_ic_ab_back_mtrl_am_alpha);
    }

    private cx(Toolbar toolbar, int i, int i2) {
        Toolbar toolbar2;
        Context context;
        this.o = 0;
        this.q = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.b != null;
        this.j = toolbar.getNavigationIcon();
        dh a = dh.a(toolbar.getContext(), null, h.ActionBar, k.actionBarStyle);
        CharSequence c = a.c(h.ActionBar_title);
        if (!TextUtils.isEmpty(c)) {
            this.k = true;
            b(c);
        }
        CharSequence c2 = a.c(h.ActionBar_subtitle);
        if (!TextUtils.isEmpty(c2)) {
            this.l = c2;
            if ((this.e & 8) != 0) {
                this.a.setSubtitle(c2);
            }
        }
        Drawable a2 = a.a(h.ActionBar_logo);
        if (a2 != null) {
            b(a2);
        }
        a2 = a.a(h.ActionBar_icon);
        if (this.j == null && a2 != null) {
            a(a2);
        }
        a2 = a.a(h.ActionBar_homeAsUpIndicator);
        if (a2 != null) {
            this.j = a2;
            s();
        }
        c(a.a(h.ActionBar_displayOptions, 0));
        int e = a.e(h.ActionBar_customNavigationLayout, 0);
        if (e != 0) {
            View inflate = LayoutInflater.from(this.a.getContext()).inflate(e, this.a, false);
            if (!(this.g == null || (this.e & 16) == 0)) {
                this.a.removeView(this.g);
            }
            this.g = inflate;
            if (!(inflate == null || (this.e & 16) == 0)) {
                this.a.addView(this.g);
            }
            c(this.e | 16);
        }
        e = a.d(h.ActionBar_height, 0);
        if (e > 0) {
            LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = e;
            this.a.setLayoutParams(layoutParams);
        }
        e = a.b(h.ActionBar_contentInsetStart, -1);
        int b = a.b(h.ActionBar_contentInsetEnd, -1);
        if (e >= 0 || b >= 0) {
            this.a.i.a(Math.max(e, 0), Math.max(b, 0));
        }
        e = a.e(h.ActionBar_titleTextStyle, 0);
        if (e != 0) {
            toolbar2 = this.a;
            context = this.a.getContext();
            toolbar2.g = e;
            if (toolbar2.b != null) {
                toolbar2.b.setTextAppearance(context, e);
            }
        }
        e = a.e(h.ActionBar_subtitleTextStyle, 0);
        if (e != 0) {
            toolbar2 = this.a;
            context = this.a.getContext();
            toolbar2.h = e;
            if (toolbar2.c != null) {
                toolbar2.c.setTextAppearance(context, e);
            }
        }
        e = a.e(h.ActionBar_popupTheme, 0);
        if (e != 0) {
            this.a.setPopupTheme(e);
        }
        a.a.recycle();
        this.p = fb.a();
        if (i != this.q) {
            this.q = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                CharSequence charSequence;
                int i3 = this.q;
                if (i3 == 0) {
                    charSequence = null;
                } else {
                    charSequence = this.a.getContext().getString(i3);
                }
                this.m = charSequence;
                r();
            }
        }
        this.m = this.a.getNavigationContentDescription();
        Drawable a3 = this.p.a(this.a.getContext(), i2, false);
        if (this.r != a3) {
            this.r = a3;
            s();
        }
        this.a.setNavigationOnClickListener(new ci(this));
    }

    public final ViewGroup a() {
        return this.a;
    }

    public final Context b() {
        return this.a.getContext();
    }

    public final boolean c() {
        Toolbar toolbar = this.a;
        return (toolbar.l == null || toolbar.l.b == null) ? false : true;
    }

    public final void d() {
        this.a.c();
    }

    public final void a(Callback callback) {
        this.c = callback;
    }

    public final void a(CharSequence charSequence) {
        if (!this.k) {
            b(charSequence);
        }
    }

    public final CharSequence e() {
        return this.a.getTitle();
    }

    private void b(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    public final void a(int i) {
        a(i != 0 ? this.p.a(this.a.getContext(), i, false) : null);
    }

    public final void a(Drawable drawable) {
        this.h = drawable;
        q();
    }

    public final void b(int i) {
        b(i != 0 ? this.p.a(this.a.getContext(), i, false) : null);
    }

    private void b(Drawable drawable) {
        this.i = drawable;
        q();
    }

    private void q() {
        Drawable drawable = null;
        if ((this.e & 2) != 0) {
            drawable = (this.e & 1) != 0 ? this.i != null ? this.i : this.h : this.h;
        }
        this.a.setLogo(drawable);
    }

    public final boolean f() {
        Toolbar toolbar = this.a;
        return toolbar.getVisibility() == 0 && toolbar.a != null && toolbar.a.b;
    }

    public final boolean g() {
        return this.a.a();
    }

    public final boolean h() {
        Toolbar toolbar = this.a;
        if (toolbar.a != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.a;
            if (actionMenuView.c != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.c;
                if (actionMenuPresenter.q != null || actionMenuPresenter.g()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        return this.a.b();
    }

    public final boolean j() {
        Toolbar toolbar = this.a;
        if (toolbar.a != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.a;
            if (actionMenuView.c == null || !actionMenuView.c.d()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void k() {
        this.d = true;
    }

    public final void a(Menu menu, m mVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.a.getContext());
            this.n.h = j.action_menu_presenter;
        }
        this.n.f = mVar;
        Toolbar toolbar = this.a;
        u uVar = (u) menu;
        r rVar = this.n;
        if (uVar != null || toolbar.a != null) {
            toolbar.d();
            u uVar2 = toolbar.a.a;
            if (uVar2 != uVar) {
                if (uVar2 != null) {
                    uVar2.b(toolbar.k);
                    uVar2.b(toolbar.l);
                }
                if (toolbar.l == null) {
                    toolbar.l = new eg(toolbar);
                }
                rVar.n = true;
                if (uVar != null) {
                    uVar.a(rVar, toolbar.e);
                    uVar.a(toolbar.l, toolbar.e);
                } else {
                    rVar.a(toolbar.e, null);
                    toolbar.l.a(toolbar.e, null);
                    rVar.a(true);
                    toolbar.l.a(true);
                }
                toolbar.a.setPopupTheme(toolbar.f);
                toolbar.a.setPresenter(rVar);
                toolbar.k = rVar;
            }
        }
    }

    public final void l() {
        Toolbar toolbar = this.a;
        if (toolbar.a != null) {
            toolbar.a.b();
        }
    }

    public final int m() {
        return this.e;
    }

    public final void c(int i) {
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    s();
                    r();
                } else {
                    this.a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                q();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.b);
                    this.a.setSubtitle(this.l);
                } else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.g != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.g);
                } else {
                    this.a.removeView(this.g);
                }
            }
        }
    }

    public final void a(fu fuVar) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = fuVar;
        if (fuVar != null && this.o == 2) {
            this.a.addView(this.f, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.a = 8388691;
            fuVar.setAllowCollapse(true);
        }
    }

    public final void a(boolean z) {
        this.a.setCollapsible(z);
    }

    public final int n() {
        return this.o;
    }

    public final bo a(int i, long j) {
        return ViewCompat.q(this.a).a(i == 0 ? IPictureView.DEFAULT_MIN_SCALE : 0.0f).a(j).a(new ee(this, i));
    }

    private void r() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.a.setNavigationContentDescription(this.q);
        } else {
            this.a.setNavigationContentDescription(this.m);
        }
    }

    private void s() {
        if ((this.e & 4) != 0) {
            this.a.setNavigationIcon(this.j != null ? this.j : this.r);
        }
    }

    public final int o() {
        return this.a.getVisibility();
    }

    public final void a(m mVar, z zVar) {
        Toolbar toolbar = this.a;
        toolbar.m = mVar;
        toolbar.n = zVar;
        if (toolbar.a != null) {
            toolbar.a.a(mVar, zVar);
        }
    }

    public final Menu p() {
        return this.a.getMenu();
    }
}
