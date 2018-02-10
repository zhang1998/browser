package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class ct extends ay {
    WeakHashMap<View, Integer> b = null;

    ct() {
    }

    public void a(bo boVar, View view, l lVar) {
        view.setTag(2113929216, lVar);
        view.animate().setListener(new o(new de(boVar), view));
    }

    public final void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public final void a(bo boVar, View view, float f) {
        view.animate().alpha(f);
    }

    public final void b(bo boVar, View view, float f) {
        view.animate().translationX(f);
    }

    public final void c(bo boVar, View view, float f) {
        view.animate().translationY(f);
    }

    public final long a(View view) {
        return view.animate().getDuration();
    }

    public final void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public final void b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public final void a(bo boVar, View view) {
        view.animate().cancel();
    }

    public final void b(bo boVar, View view) {
        view.animate().start();
    }
}
