package com.ucpro.feature.t.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ProGuard */
final class a implements AnimatorUpdateListener {
    final /* synthetic */ View a;
    final /* synthetic */ u b;

    a(u uVar, View view) {
        this.b = uVar;
        this.a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setAlpha(this.b.b(this.a));
    }
}
