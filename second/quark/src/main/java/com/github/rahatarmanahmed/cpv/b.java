package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.Iterator;

/* compiled from: ProGuard */
final class b extends AnimatorListenerAdapter {
    final /* synthetic */ float a;
    final /* synthetic */ CircularProgressView b;

    b(CircularProgressView circularProgressView, float f) {
        this.b = circularProgressView;
        this.a = f;
    }

    public final void onAnimationEnd(Animator animator) {
        Iterator it = this.b.p.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
