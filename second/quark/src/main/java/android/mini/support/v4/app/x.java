package android.mini.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: ProGuard */
final class x extends z {
    final /* synthetic */ Fragment a;
    final /* synthetic */ ab b;

    x(ab abVar, View view, Animation animation, Fragment fragment) {
        this.b = abVar;
        this.a = fragment;
        super(view, animation);
    }

    public final void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.a.l != null) {
            this.a.l = null;
            this.b.a(this.a, this.a.m, 0, 0, false);
        }
    }
}
