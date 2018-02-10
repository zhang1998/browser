package com.uc.weex.component.c.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: ProGuard */
public final class k implements AnimatorListener, AnimatorUpdateListener, l {
    protected final Interpolator a = new DecelerateInterpolator();
    protected final float b = -2.0f;
    protected final float c = -4.0f;
    protected final j d;
    final /* synthetic */ q e;
    private float f;

    public k(q qVar, float f) {
        this.e = qVar;
        this.d = qVar.b();
    }

    public final int a() {
        return 3;
    }

    public final void a(l lVar) {
        Animator a;
        float f = 0.0f;
        this.e.g.a(lVar.a(), 3, this.e.c() - this.e.k);
        View a2 = this.e.b.a();
        this.d.a(a2);
        if (this.e.j == 0.0f || ((this.e.j < 0.0f && this.e.a.c) || (this.e.j > 0.0f && !this.e.a.c))) {
            this.f = this.d.b;
            a = a(this.d.b);
        } else {
            float f2 = (-this.e.j) / this.b;
            if (f2 >= 0.0f) {
                f = f2;
            }
            f2 = (((-this.e.j) * this.e.j) / this.c) + this.d.b;
            int i = (int) f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2, this.d.a, new float[]{f2});
            ofFloat.setDuration((long) i);
            ofFloat.setInterpolator(this.a);
            ofFloat.addUpdateListener(this);
            ObjectAnimator a3 = a(f2);
            this.f = f2;
            a = new AnimatorSet();
            a.playSequentially(new Animator[]{ofFloat, a3});
        }
        a.addListener(this);
        a.start();
    }

    public final boolean a(MotionEvent motionEvent) {
        return true;
    }

    public final boolean b() {
        return true;
    }

    public final void onAnimationEnd(Animator animator) {
        this.e.a(this.e.c);
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = this.f - floatValue;
        this.f = floatValue;
        this.e.h.a(floatValue, f, this.e.b.b());
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    private ObjectAnimator a(float f) {
        float abs = (Math.abs(f) / this.d.c) * 800.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e.b.a(), this.d.a, new float[]{this.e.a.b});
        ofFloat.setDuration((long) Math.max((int) abs, 200));
        ofFloat.setInterpolator(this.a);
        ofFloat.addUpdateListener(this);
        return ofFloat;
    }
}
