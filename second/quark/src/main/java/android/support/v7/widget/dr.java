package android.support.v7.widget;

import android.support.v4.view.ViewCompat;

/* compiled from: ProGuard */
final class dr implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    dr(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public final void run() {
        this.a.i();
        this.a.x = ViewCompat.q(this.a.f).c(0.0f).a(this.a.y);
    }
}
