package com.ucpro.feature.t.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class t extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ u b;

    t(u uVar, View view) {
        this.b = uVar;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
    }
}
