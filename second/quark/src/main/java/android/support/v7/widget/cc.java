package android.support.v7.widget;

import android.support.v7.view.menu.j;

/* compiled from: ProGuard */
final class cc extends j {
    final /* synthetic */ ActionMenuPresenter a;

    private cc(ActionMenuPresenter actionMenuPresenter) {
        this.a = actionMenuPresenter;
    }

    public final ListPopupWindow a() {
        if (this.a.p != null) {
            return this.a.p.c;
        }
        return null;
    }
}
