package com.ucpro.feature.t.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ucpro.feature.t.f;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class q extends AnimatorListenerAdapter {
    final /* synthetic */ int a;
    final /* synthetic */ f b;
    final /* synthetic */ k c;
    final /* synthetic */ n d;

    public q(n nVar, int i, f fVar, k kVar) {
        this.d = nVar;
        this.a = i;
        this.b = fVar;
        this.c = kVar;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.a == 0 && this.b != null) {
            this.b.a();
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.a == 0) {
            m.a(2, new l(this), 300);
        }
        this.c.animate().translationY((float) this.d.getMeasuredHeight()).setListener(null).setDuration(300);
    }
}
