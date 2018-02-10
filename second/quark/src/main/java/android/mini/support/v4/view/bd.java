package android.mini.support.v4.view;

import android.view.View;

/* compiled from: ProGuard */
class bd extends az {
    bd() {
    }

    public void c(View view, int i) {
        if (i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    public final boolean c(View view) {
        return view.hasTransientState();
    }

    public final void d(View view) {
        view.postInvalidateOnAnimation();
    }

    public final void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public final void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public final int e(View view) {
        return view.getImportantForAccessibility();
    }

    public final int m(View view) {
        return view.getMinimumWidth();
    }

    public final int n(View view) {
        return view.getMinimumHeight();
    }

    public final boolean i(View view) {
        return view.hasOverlappingRendering();
    }
}
