package com.ucpro.feature.z.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ProGuard */
final class m extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ g b;

    m(g gVar, View view) {
        this.b = gVar;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.setVisibility(8);
    }
}
