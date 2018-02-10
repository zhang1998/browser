package android.support.v7.widget;

import android.view.View;

/* compiled from: ProGuard */
final class cj implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ fu b;

    cj(fu fuVar, View view) {
        this.b = fuVar;
        this.a = view;
    }

    public final void run() {
        this.b.smoothScrollTo(this.a.getLeft() - ((this.b.getWidth() - this.a.getWidth()) / 2), 0);
        this.b.a = null;
    }
}
