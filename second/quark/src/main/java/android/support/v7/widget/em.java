package android.support.v7.widget;

import android.support.v4.view.ViewCompat;

/* compiled from: ProGuard */
final class em implements Runnable {
    final /* synthetic */ ListPopupWindow a;

    private em(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public final void run() {
        if (this.a.b != null && ViewCompat.E(this.a.b) && this.a.b.getCount() > this.a.b.getChildCount() && this.a.b.getChildCount() <= this.a.h) {
            this.a.a.setInputMethodMode(2);
            this.a.b();
        }
    }
}
