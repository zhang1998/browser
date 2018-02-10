package com.ucpro.feature.inputenhance;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class a implements AnimatorListener {
    final /* synthetic */ s a;

    a(s sVar) {
        this.a = sVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.a.k.setVisibility(0);
        this.a.l.setVisibility(0);
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.h.remove(this.a.K);
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.k.setVisibility(0);
        this.a.k.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.a.l.setVisibility(0);
        this.a.l.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.a.h.remove(this.a.K);
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
