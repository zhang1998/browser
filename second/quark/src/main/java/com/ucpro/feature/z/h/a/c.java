package com.ucpro.feature.z.h.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class c implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ h c;

    c(h hVar, float f, float f2) {
        this.c = hVar;
        this.a = f;
        this.b = f2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = ((this.a - this.b) * floatValue) + this.b;
        if (!(this.c.d == null || this.c.k == null)) {
            this.c.d.setY(((float) ((this.c.b.getMeasuredHeight() - this.c.d.getMeasuredHeight()) / 2)) + f);
            this.c.k.setAlpha(floatValue);
            this.c.k.setY(((float) ((this.c.b.getMeasuredHeight() + this.c.d.getMeasuredHeight()) / 2)) + f);
        }
        this.c.c.setY(f);
        this.c.h.setY(f - ((float) this.c.h.getMeasuredHeight()));
        if (a.a()) {
            this.c.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE - floatValue);
        }
    }
}
