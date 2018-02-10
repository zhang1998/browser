package com.ucpro.feature.z.h.a;

import android.animation.ValueAnimator;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class h extends i {
    private int A = 0;
    private int z = 0;

    public h(e eVar) {
        super(eVar);
    }

    public final void a(k kVar) {
        this.w = kVar;
        if (this.j != null) {
            this.j.setVisibility(0);
        }
        if (this.k != null) {
            this.k.setVisibility(0);
        }
        if (this.l != null) {
            this.l.setVisibility(0);
        }
        if (this.d != null) {
            this.d.setVisibility(0);
            this.d.setY(this.d.getSourceView().getY());
        }
        if (a.a()) {
            this.a.setAlpha(0.0f);
        }
        c();
    }

    public final void b(k kVar) {
        float y;
        f();
        this.w = kVar;
        if (this.j != null) {
            this.j.setAlpha(0.0f);
            this.j.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(250).setStartDelay(200);
        }
        if (this.l != null) {
            this.l.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        }
        if (this.k != null) {
            this.k.setVisibility(0);
            this.k.setAlpha(0.0f);
        }
        this.c.setY(this.c.getVisibility() == 0 ? this.c.getY() : this.b.getY());
        this.c.setVisibility(0);
        this.b.setY((float) (-this.b.getMeasuredHeight()));
        this.b.setVisibility(4);
        float searchBarInitYWithoutTransY = this.y.getSearchBarInitYWithoutTransY();
        if (this.c.getVisibility() == 0) {
            y = this.c.getY();
        } else {
            y = this.b.getY();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.addUpdateListener(new c(this, searchBarInitYWithoutTransY, y));
        ofFloat.addListener(new p(this, searchBarInitYWithoutTransY));
        ofFloat.setStartDelay(200);
        ofFloat.setDuration(250).start();
        if (this.d != null) {
            this.d.setVisibility(0);
            this.d.setAlpha(0.0f);
            this.d.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(250).setStartDelay(200);
        }
        this.c.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.c.animate().setDuration(250).alpha(0.0f).setStartDelay(200);
        this.h.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.h.animate().setDuration(250).alpha(0.0f).setStartDelay(200);
        this.e.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.e.animate().setDuration(250).alpha(0.0f);
        if (this.f.getVisibility() == 0) {
            this.f.a(true, 250);
        } else {
            this.g.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            this.g.animate().setDuration(250).alpha(0.0f);
        }
        if (this.i.a) {
            this.i.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            this.i.animate().setDuration(250).alpha(0.0f);
        }
    }

    public final void a() {
        if (this.j != null) {
            this.j.setVisibility(0);
            this.j.setAlpha(this.j.getSourceView().getAlpha());
            this.j.animate().alpha(0.0f).setDuration(250).setStartDelay(0);
        }
        if (this.l != null) {
            this.l.setVisibility(0);
            this.l.setAlpha(this.l.getSourceView().getAlpha());
            this.l.animate().alpha(0.0f).setDuration(250).setStartDelay(0);
        }
        if (this.k != null) {
            this.k.setVisibility(0);
            this.k.setAlpha(this.k.getSourceView().getAlpha());
            this.k.animate().alpha(0.0f).y((float) this.k.getBottom()).setDuration(250).setStartDelay(0);
        }
        if (this.d != null) {
            this.d.setVisibility(0);
            this.d.setAlpha(this.j.getSourceView().getAlpha());
        }
        this.h.setVisibility(0);
        this.h.setAlpha(0.0f);
        this.b.setVisibility(0);
        this.b.setAlpha(0.0f);
        this.b.setY((float) (-this.b.getMeasuredHeight()));
        this.c.setVisibility(0);
        this.c.setAlpha(0.0f);
        if (this.i.a) {
            this.i.setVisibility(0);
            this.i.setAlpha(0.0f);
        }
        float searchBarInitY = (float) this.y.getSearchBarInitY();
        float f = (float) this.m;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
        ofFloat.addUpdateListener(new o(this, f, searchBarInitY));
        ofFloat.addListener(new a(this, f));
        ofFloat.setDuration(250).start();
        this.e.setVisibility(0);
        this.e.setAlpha(0.0f);
        this.e.animate().setDuration(250).alpha(IPictureView.DEFAULT_MIN_SCALE).setStartDelay(200);
        this.f.a(200);
    }

    public final void a(int i) {
        this.m = (i - this.b.getMeasuredHeight()) - this.e.getMeasuredHeight();
        this.n = i - this.e.getMeasuredHeight();
        this.p = this.m - this.g.getMeasuredHeight();
        if (this.i.a) {
            this.o = (this.m - this.f.getMeasuredHeight()) - this.i.getMeasuredHeight();
        } else {
            this.o = this.m - this.f.getMeasuredHeight();
        }
    }
}
