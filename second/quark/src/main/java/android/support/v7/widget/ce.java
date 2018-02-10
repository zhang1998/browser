package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ProGuard */
final class ce implements OnGlobalLayoutListener {
    final /* synthetic */ ej a;

    ce(ej ejVar) {
        this.a = ejVar;
    }

    public final void onGlobalLayout() {
        if (ej.a(this.a, this.a.m)) {
            this.a.g();
            super.b();
            return;
        }
        this.a.c();
    }
}
