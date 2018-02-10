package android.support.v7.widget;

import android.support.v4.view.ViewCompat;

/* compiled from: ProGuard */
final class dm implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    dm(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public final void run() {
        this.a.i();
        this.a.x = ViewCompat.q(this.a.f).c((float) (-this.a.f.getHeight())).a(this.a.y);
    }
}
