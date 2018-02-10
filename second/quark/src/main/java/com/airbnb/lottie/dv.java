package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class dv implements AnimatorUpdateListener {
    final /* synthetic */ cu a;

    dv(cu cuVar) {
        this.a = cuVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.l) {
            this.a.c.cancel();
            this.a.b((float) IPictureView.DEFAULT_MIN_SCALE);
            return;
        }
        this.a.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
