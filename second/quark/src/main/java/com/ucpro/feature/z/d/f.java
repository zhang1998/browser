package com.ucpro.feature.z.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class f implements AnimatorUpdateListener {
    final /* synthetic */ g a;

    f(g gVar) {
        this.a = gVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.d.setRotationX((IPictureView.DEFAULT_MIN_SCALE - floatValue) * 5.0f);
        this.a.d.setAlpha(floatValue);
        this.a.a.setScaleX(floatValue);
        this.a.a.setScaleY(floatValue);
    }
}
