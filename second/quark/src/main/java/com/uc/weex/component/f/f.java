package com.uc.weex.component.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class f extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ k b;

    f(k kVar, boolean z) {
        this.b = kVar;
        this.a = z;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a) {
            k.a(this.b, this.a);
        }
    }
}
