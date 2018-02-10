package android.support.v7.widget;

import android.content.Context;
import android.support.v7.c.k;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.ae;
import android.support.v7.view.menu.i;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ProGuard */
final class ev extends ae {
    final /* synthetic */ ActionMenuPresenter g;
    private a h;

    public ev(ActionMenuPresenter actionMenuPresenter, Context context, a aVar) {
        boolean z = false;
        this.g = actionMenuPresenter;
        super(context, aVar, null, false, k.actionOverflowMenuStyle);
        this.h = aVar;
        if (!((i) aVar.getItem()).f()) {
            View view;
            if (actionMenuPresenter.i == null) {
                view = (View) actionMenuPresenter.g;
            } else {
                view = actionMenuPresenter.i;
            }
            this.b = view;
        }
        this.d = actionMenuPresenter.r;
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = aVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.e = z;
    }

    public final void onDismiss() {
        super.onDismiss();
        this.g.p = null;
        this.g.s = 0;
    }
}
