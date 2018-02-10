package com.ucpro.feature.webwindow.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ProGuard */
final class a extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    a(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.b.d != null) {
            if (this.a) {
                this.b.d.b();
            } else {
                this.b.d.a();
            }
        }
        this.b.post(new f(this.b));
    }
}
