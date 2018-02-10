package com.ucpro.feature.t.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class d extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ u b;

    d(u uVar, View view) {
        this.b = uVar;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.b.d.a(this.a, 1);
        this.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
    }
}
