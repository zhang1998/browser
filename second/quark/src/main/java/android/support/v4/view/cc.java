package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ProGuard */
class cc extends do {
    cc() {
    }

    public final void a(View view, p pVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (pVar != null) {
            animatorUpdateListener = new aa(pVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
