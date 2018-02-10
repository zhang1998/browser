package com.ucpro.feature.z.h.a;

import android.animation.ValueAnimator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class l extends i {
    public l(e eVar) {
        super(eVar);
    }

    public final void a(k kVar) {
        this.w = kVar;
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.l != null) {
            this.l.setVisibility(8);
        }
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        this.g.getLayoutAnimation().getAnimation().setDuration(0);
        c();
    }

    public final void b(k kVar) {
        this.w = kVar;
        f();
        this.y.animate().alpha(0.0f).setDuration(250).setListener(new m(this)).setStartDelay(100).start();
    }

    public final void a() {
        this.y.setAlpha(0.0f);
        this.b.setVisibility(0);
        this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.h.setVisibility(0);
        this.h.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.e.setVisibility(0);
        this.e.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.g.setVisibility(0);
        this.g.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.f.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.f.setRotationX(0.0f);
        this.b.setY((float) this.m);
        this.e.setY((float) this.n);
        this.h.setY((float) (this.m - this.h.getMeasuredHeight()));
        this.g.setY((float) this.p);
        this.f.setY((float) this.o);
        if (this.i.a) {
            this.i.setY((float) (this.o + this.f.getMeasuredHeight()));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.addUpdateListener(new q(this));
        ofFloat.addListener(new n(this));
        ofFloat.setDuration(250).start();
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

    protected final void e() {
        if (this.w != null) {
            this.w.b();
        }
    }
}
