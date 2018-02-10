package android.support.v7.widget;

import android.content.Context;
import android.support.v7.c.k;
import android.support.v7.view.menu.ae;
import android.support.v7.view.menu.u;
import android.view.View;

/* compiled from: ProGuard */
final class ef extends ae {
    final /* synthetic */ ActionMenuPresenter g;

    public ef(ActionMenuPresenter actionMenuPresenter, Context context, u uVar, View view) {
        this.g = actionMenuPresenter;
        super(context, uVar, view, true, k.actionOverflowMenuStyle);
        this.d = actionMenuPresenter.r;
    }

    public final void onDismiss() {
        super.onDismiss();
        if (this.g.c != null) {
            this.g.c.close();
        }
        this.g.o = null;
    }
}
