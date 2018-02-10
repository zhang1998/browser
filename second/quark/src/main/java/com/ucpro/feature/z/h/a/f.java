package com.ucpro.feature.z.h.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class f implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ i c;

    f(i iVar, float f, float f2) {
        this.c = iVar;
        this.a = f;
        this.b = f2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((IPictureView.DEFAULT_MIN_SCALE - ((Float) valueAnimator.getAnimatedValue()).floatValue()) * (this.a - this.b)) + this.b;
        this.c.c.setY(floatValue);
        this.c.h.setY(floatValue - ((float) this.c.h.getMeasuredHeight()));
        if (this.c.d != null) {
            this.c.d.setY(floatValue);
        }
        this.c.e.setY(((float) this.c.b.getMeasuredHeight()) + floatValue);
        this.c.g.setY(floatValue - ((float) this.c.g.getMeasuredHeight()));
        if (this.c.i.a) {
            this.c.f.setY((floatValue - ((float) this.c.f.getMeasuredHeight())) - ((float) this.c.i.getMeasuredHeight()));
            this.c.i.setY(floatValue - ((float) this.c.i.getMeasuredHeight()));
            return;
        }
        this.c.f.setY(floatValue - ((float) this.c.f.getMeasuredHeight()));
    }
}
