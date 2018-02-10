package android.mini.support.v4.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ProGuard */
final class d implements b {
    private TimeInterpolator a;

    d() {
    }

    public final void a(View view) {
        if (this.a == null) {
            this.a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.a);
    }
}
