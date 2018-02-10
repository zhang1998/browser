package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

/* compiled from: ProGuard */
final class ch implements Runnable {
    final View a;
    final /* synthetic */ SlidingPaneLayout b;

    ch(SlidingPaneLayout slidingPaneLayout, View view) {
        this.b = slidingPaneLayout;
        this.a = view;
    }

    public final void run() {
        if (this.a.getParent() == this.b) {
            ViewCompat.a(this.a, 0, null);
            this.b.c(this.a);
        }
        this.b.u.remove(this);
    }
}
