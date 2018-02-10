package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ProGuard */
final class aa implements AnimatorUpdateListener {
    final /* synthetic */ p a;
    final /* synthetic */ View b;

    aa(p pVar, View view) {
        this.a = pVar;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}
