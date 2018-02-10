package android.support.v7.widget;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class dd extends DataSetObserver {
    final /* synthetic */ ListPopupWindow a;

    private dd(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public final void onChanged() {
        if (this.a.a.isShowing()) {
            this.a.b();
        }
    }

    public final void onInvalidated() {
        this.a.c();
    }
}
