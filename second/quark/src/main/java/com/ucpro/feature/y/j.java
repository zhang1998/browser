package com.ucpro.feature.y;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.o;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.h.m;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class j implements c {
    y a;
    private g b = g.a();
    private final float c = 0.0f;
    private final float d = 0.95f;
    private float e = 0.0f;
    private final int f = a.c((int) R.dimen.homepage_pull_enter_search_slop);
    private final int g = (this.f * 3);
    private Interpolator h = new DecelerateInterpolator();
    private float i = 0.0f;
    private ValueAnimator j = null;
    private ValueAnimator k = null;

    public j(com.ucpro.base.d.a aVar) {
        this.a = (y) aVar;
        m.a(0, new a(this));
    }

    public final void a(boolean z) {
        if (z) {
            o.a(o.p.c);
            com.ucpro.business.stat.m.a(o.p);
        }
        g.a().b(e.ak, this.a);
    }

    public final void b() {
        o.a(o.u.c);
        com.ucpro.business.stat.m.a(o.u);
        g.a().b(e.bD);
    }

    public final void a() {
        this.e = (float) ((this.a.getSearchBar().getMeasuredHeight() * 2) / 3);
    }

    public final void c() {
        d();
        this.a.a();
    }

    public final void a(int i) {
        this.a.setLogoMarginBottom(i);
    }

    public final void e() {
        this.i = 0.0f;
        if (this.j != null) {
            this.j.cancel();
        }
    }

    public final void a(float f) {
        float f2 = IPictureView.DEFAULT_MIN_SCALE;
        float f3 = 0.0f;
        this.i = f;
        float f4 = IPictureView.DEFAULT_MIN_SCALE - ((IPictureView.DEFAULT_MIN_SCALE * f) / ((float) this.f));
        if (f4 <= IPictureView.DEFAULT_MIN_SCALE) {
            if (f4 < 0.0f) {
                f2 = 0.0f;
            } else {
                f2 = f4;
            }
        }
        b(f2);
        if (f > ((float) this.g)) {
            f3 = (float) this.g;
        } else if (f >= 0.0f) {
            f3 = f;
        }
        this.a.a(this.h.getInterpolation(f3 / ((float) this.g)) * this.e);
    }

    public final void f() {
        boolean z = true;
        if (this.i > ((float) this.f)) {
            a(false);
        } else {
            if (this.j != null) {
                this.j.cancel();
            }
            if (this.k != null) {
                this.k.cancel();
            }
            this.j = ValueAnimator.ofFloat(new float[]{this.a.getLogo().getAlpha(), IPictureView.DEFAULT_MIN_SCALE});
            this.j.addUpdateListener(new k(this));
            this.j.setDuration(300);
            this.j.start();
            this.k = ValueAnimator.ofFloat(new float[]{this.a.getSearchBar().getTranslationY(), 0.0f});
            this.k.addUpdateListener(new q(this));
            this.k.setDuration(300);
            this.k.start();
            z = false;
        }
        this.i = 0.0f;
        HashMap hashMap = new HashMap();
        hashMap.put("suc", String.valueOf(z));
        com.ucpro.business.stat.m.a("homepage", "pul_ent_sea", hashMap);
    }

    final void b(float f) {
        this.a.a(f, IPictureView.DEFAULT_MIN_SCALE - ((0.050000012f * (IPictureView.DEFAULT_MIN_SCALE - f)) / IPictureView.DEFAULT_MIN_SCALE));
    }

    public final void c(float f) {
        g.a().a(e.cQ, (int) f, 0);
    }

    public final void g() {
        g.a().b(e.cR);
    }

    public final void d() {
        boolean z = true;
        int i = 0;
        if (com.ucpro.model.a.a.a.a("setting_enable_logo", true)) {
            z = false;
        }
        if (a.a() && r0) {
            i = 8;
        }
        if (this.a.getLogo() != null && this.a.getLogo().getVisibility() != i) {
            this.a.getLogo().setVisibility(i);
        }
    }
}
