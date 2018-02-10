package com.uc.weex.component.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class h extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ k b;

    h(k kVar, boolean z) {
        this.b = kVar;
        this.a = z;
    }

    public final void onAnimationEnd(Animator animator) {
        k.a(this.b, this.a);
    }
}
