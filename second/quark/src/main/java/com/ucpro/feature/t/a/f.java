package com.ucpro.feature.t.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class f implements AnimatorUpdateListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ a d;

    f(a aVar, boolean z, int i, int i2) {
        this.d = aVar;
        this.a = z;
        this.b = i;
        this.c = i2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float a = !this.a ? floatValue <= 0.5f ? ((float) (this.d.M * 2)) * floatValue : ((float) (this.d.M * 2)) * (IPictureView.DEFAULT_MIN_SCALE - floatValue) : 0.0f;
        a = (((this.d.e - this.d.I) * floatValue) + this.d.I) - a;
        float e = ((this.d.d - this.d.J) * floatValue) + this.d.J;
        float h = ((this.d.c - this.d.b) * floatValue) + this.d.b;
        this.d.h = (int) ((((float) (this.b - this.c)) * floatValue) + ((float) this.c));
        this.d.d();
        this.d.e();
        this.d.p.setY(e);
        this.d.p.setX(a);
        this.d.p.setScaleX(h);
        this.d.p.setScaleY(h);
        this.d.p.setPivotX(0.0f);
        this.d.p.setPivotY(0.0f);
        a = ((this.d.l - this.d.k) * floatValue) + this.d.k;
        this.d.a.setAlpha(a);
        this.d.a.setScaleX(a);
        this.d.a.setScaleY(a);
    }
}
