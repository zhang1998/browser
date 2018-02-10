package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: ProGuard */
class dd extends cp {
    dd() {
    }

    public void e(View view, int i) {
        if (i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    public final boolean v(View view) {
        return view.hasTransientState();
    }

    public final void w(View view) {
        view.postInvalidateOnAnimation();
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public final void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public final void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public final int x(View view) {
        return view.getImportantForAccessibility();
    }

    public final ViewParent z(View view) {
        return view.getParentForAccessibility();
    }

    public final int C(View view) {
        return view.getMinimumWidth();
    }

    public final int D(View view) {
        return view.getMinimumHeight();
    }

    public void n(View view) {
        view.requestFitSystemWindows();
    }

    public final boolean F(View view) {
        return view.getFitsSystemWindows();
    }

    public final boolean B(View view) {
        return view.hasOverlappingRendering();
    }
}
