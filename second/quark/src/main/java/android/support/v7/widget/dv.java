package android.support.v7.widget;

import android.view.View;

/* compiled from: ProGuard */
final class dv implements Runnable {
    final /* synthetic */ ListPopupWindow a;

    dv(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public final void run() {
        View view = this.a.j;
        if (view != null && view.getWindowToken() != null) {
            this.a.b();
        }
    }
}
