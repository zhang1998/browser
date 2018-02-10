package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: ProGuard */
final class fi implements OnScrollListener {
    final /* synthetic */ ListPopupWindow a;

    private fi(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.a.f() && this.a.a.getContentView() != null) {
            this.a.C.removeCallbacks(this.a.x);
            this.a.x.run();
        }
    }
}
