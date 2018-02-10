package android.support.v7.widget;

import android.view.View;

/* compiled from: ProGuard */
final class dq extends fm {
    final /* synthetic */ ActionMenuPresenter a;
    final /* synthetic */ fg b;

    dq(fg fgVar, View view, ActionMenuPresenter actionMenuPresenter) {
        this.b = fgVar;
        this.a = actionMenuPresenter;
        super(view);
    }

    public final ListPopupWindow a() {
        if (this.b.a.o == null) {
            return null;
        }
        return this.b.a.o.c;
    }

    public final boolean b() {
        this.b.a.c();
        return true;
    }

    public final boolean c() {
        if (this.b.a.q != null) {
            return false;
        }
        this.b.a.d();
        return true;
    }
}
