package android.mini.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

/* compiled from: ProGuard */
class ay extends ax {
    ay() {
    }

    final long a() {
        return ValueAnimator.getFrameDelay();
    }

    public final float f(View view) {
        return view.getAlpha();
    }

    public final void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public final int g(View view) {
        return view.getLayerType();
    }

    public final float j(View view) {
        return view.getTranslationX();
    }

    public final float k(View view) {
        return view.getTranslationY();
    }

    public final Matrix l(View view) {
        return view.getMatrix();
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

    public final void p(View view) {
        view.setSaveFromParentEnabled(false);
    }
}
