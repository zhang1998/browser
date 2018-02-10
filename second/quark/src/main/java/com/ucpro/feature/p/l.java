package com.ucpro.feature.p;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class l implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ h c;

    l(h hVar, int i, boolean z) {
        this.c = hVar;
        this.a = i;
        this.b = z;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.f.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        float currentPlayTime = ((float) valueAnimator.getCurrentPlayTime()) / ((float) this.a);
        if (!this.b) {
            currentPlayTime = IPictureView.DEFAULT_MIN_SCALE - currentPlayTime;
        }
        this.c.f.setAlpha(currentPlayTime);
    }
}
