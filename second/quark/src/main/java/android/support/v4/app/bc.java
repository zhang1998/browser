package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: ProGuard */
final class bc extends bz {
    final /* synthetic */ Fragment a;
    final /* synthetic */ ah b;

    bc(ah ahVar, View view, Animation animation, Fragment fragment) {
        this.b = ahVar;
        this.a = fragment;
        super(view, animation);
    }

    public final void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.a.g != null) {
            this.a.g = null;
            this.b.a(this.a, this.a.h, 0, 0, false);
        }
    }
}
