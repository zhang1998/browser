package com.ucpro.ui.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

/* compiled from: ProGuard */
public final class i {
    private long a = 300;
    private long b = 600;
    private int c;
    private int d;
    private h e;
    private Interpolator f = new c();

    public i(int i, int i2, h hVar) {
        this.c = i;
        this.d = i2;
        this.e = hVar;
    }

    public final void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.c, this.d});
        ofInt.setDuration(this.a);
        ofInt.setInterpolator(this.f);
        ofInt.addUpdateListener(new b(this));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.d, this.c});
        ofInt2.setDuration(this.b);
        ofInt2.setInterpolator(new e());
        ofInt2.addUpdateListener(new a(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofInt, ofInt2});
        animatorSet.start();
    }

    protected final void a(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }
}
