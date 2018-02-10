package com.ucpro.feature.z.h.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class o implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ h c;

    o(h hVar, float f, float f2) {
        this.c = hVar;
        this.a = f;
        this.b = f2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = ((this.a - this.b) * (IPictureView.DEFAULT_MIN_SCALE - floatValue)) + this.b;
        if (this.c.d != null) {
            this.c.d.setY(((float) ((this.c.b.getMeasuredHeight() - this.c.d.getMeasuredHeight()) / 2)) + f);
        }
        this.c.c.setY(f);
        this.c.h.setY(f - ((float) this.c.h.getMeasuredHeight()));
        this.c.e.setY((float) this.c.n);
        this.c.g.setY((float) this.c.p);
        this.c.f.setY((float) this.c.o);
        if (this.c.d != null) {
            this.c.d.setAlpha(floatValue);
        }
        this.c.c.setAlpha(IPictureView.DEFAULT_MIN_SCALE - floatValue);
        this.c.h.setAlpha(IPictureView.DEFAULT_MIN_SCALE - floatValue);
        if (this.c.i.a) {
            this.c.i.setY((float) (this.c.o + this.c.f.getMeasuredHeight()));
            this.c.i.setAlpha(IPictureView.DEFAULT_MIN_SCALE - floatValue);
        }
        if (a.a()) {
            this.c.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE - floatValue);
        }
    }
}
