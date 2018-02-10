package com.ucpro.ui.widget.tablayout;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class r extends a {
    final ValueAnimator a = new ValueAnimator();

    r() {
    }

    public final void a() {
        this.a.start();
    }

    public final boolean b() {
        return this.a.isRunning();
    }

    public final void a(Interpolator interpolator) {
        this.a.setInterpolator(interpolator);
    }

    public final void a(u uVar) {
        this.a.addUpdateListener(new v(this, uVar));
    }

    public final void a(t tVar) {
        this.a.addListener(new m(this, tVar));
    }

    public final void a(int i, int i2) {
        this.a.setIntValues(new int[]{i, i2});
    }

    public final int c() {
        return ((Integer) this.a.getAnimatedValue()).intValue();
    }

    public final void d() {
        this.a.setFloatValues(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
    }

    public final void a(int i) {
        this.a.setDuration((long) i);
    }

    public final void e() {
        this.a.cancel();
    }

    public final float f() {
        return this.a.getAnimatedFraction();
    }

    public final long g() {
        return this.a.getDuration();
    }
}
