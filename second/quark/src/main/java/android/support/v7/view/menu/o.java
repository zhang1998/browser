package android.support.v7.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.fm;

/* compiled from: ProGuard */
final class o extends fm {
    final /* synthetic */ ActionMenuItemView a;

    public o(ActionMenuItemView actionMenuItemView) {
        this.a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public final ListPopupWindow a() {
        if (this.a.f != null) {
            return this.a.f.a();
        }
        return null;
    }

    protected final boolean b() {
        if (this.a.d == null || !this.a.d.a(this.a.a)) {
            return false;
        }
        ListPopupWindow a = a();
        if (a == null || !a.a.isShowing()) {
            return false;
        }
        return true;
    }
}
