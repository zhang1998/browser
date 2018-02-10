package com.taobao.weex.ui.animation;

import android.animation.IntEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.mini.support.annotation.NonNull;
import android.mini.support.v4.d.m;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.view.a;

/* compiled from: ProGuard */
public final class b implements AnimatorUpdateListener {
    public m<Integer, Integer> a;
    public m<Integer, Integer> b;
    private View c;
    private IntEvaluator d = new IntEvaluator();

    public b(@NonNull View view) {
        this.c = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.c.getLayoutParams() != null) {
            LayoutParams layoutParams = this.c.getLayoutParams();
            TimeInterpolator interpolator = valueAnimator.getInterpolator();
            float animatedFraction = valueAnimator.getAnimatedFraction();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.a != null) {
                layoutParams.width = this.d.evaluate(interpolator.getInterpolation(animatedFraction), (Integer) this.a.a, (Integer) this.a.b).intValue();
            }
            if (this.b != null) {
                layoutParams.height = this.d.evaluate(interpolator.getInterpolation(animatedFraction), (Integer) this.b.a, (Integer) this.b.b).intValue();
            }
            if (!(i2 == layoutParams.height && i == layoutParams.width)) {
                this.c.requestLayout();
            }
            if (this.c instanceof a) {
                ab component = ((a) this.c).getComponent();
                if (component == null) {
                    return;
                }
                if (i != layoutParams.width || i2 != layoutParams.height) {
                    component.notifyNativeSizeChanged(layoutParams.width, layoutParams.height);
                }
            }
        }
    }
}
