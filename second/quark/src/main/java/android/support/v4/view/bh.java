package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* compiled from: ProGuard */
class bh extends cu {
    bh() {
    }

    public void a(View view, int i) {
        i.b(view, i);
    }

    public void b(View view, int i) {
        i.a(view, i);
    }

    final long a() {
        return ValueAnimator.getFrameDelay();
    }

    public final float e(View view) {
        return view.getAlpha();
    }

    public final void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public final int f(View view) {
        return view.getLayerType();
    }

    public void a(View view, Paint paint) {
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public final int a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public final int g(View view) {
        return view.getMeasuredWidthAndState();
    }

    public final int h(View view) {
        return view.getMeasuredState();
    }

    public final float i(View view) {
        return view.getTranslationX();
    }

    public final float j(View view) {
        return view.getTranslationY();
    }

    public final void a(View view, float f) {
        view.setTranslationX(f);
    }

    public final void b(View view, float f) {
        view.setTranslationY(f);
    }

    public final void c(View view, float f) {
        view.setAlpha(f);
    }

    public final void d(View view, float f) {
        view.setScaleX(f);
    }

    public final void e(View view, float f) {
        view.setScaleY(f);
    }

    public final float k(View view) {
        return view.getScaleX();
    }

    public final void l(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public final void m(View view) {
        view.setSaveFromParentEnabled(false);
    }

    public final void a(View view, boolean z) {
        view.setActivated(z);
    }
}
