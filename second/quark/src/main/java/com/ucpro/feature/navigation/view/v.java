package com.ucpro.feature.navigation.view;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class v {
    public s a;
    public ArrayList<Animation> b = new ArrayList();

    public v(s sVar) {
        this.a = sVar;
    }

    public final void a(View view, View view2, long j, Runnable runnable) {
        if (view != null && view2 != null) {
            a(view, t.a(view2), j, runnable);
        }
    }

    public final void a(View view, Rect rect, long j, Runnable runnable) {
        Rect a = t.a(view);
        Animation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (rect.left - a.left), 0, 0.0f, 0, (float) (rect.top - a.top));
        translateAnimation.setDuration(200);
        translateAnimation.setStartTime(-1);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new ar(this, translateAnimation, runnable));
        translateAnimation.setStartOffset(j);
        view.startAnimation(translateAnimation);
        this.b.add(translateAnimation);
    }
}
