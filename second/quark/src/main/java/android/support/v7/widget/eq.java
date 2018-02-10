package android.support.v7.widget;

import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.view.MenuItem;

/* compiled from: ProGuard */
final class eq implements z {
    final /* synthetic */ ActionMenuView a;

    private eq(ActionMenuView actionMenuView) {
        this.a = actionMenuView;
    }

    public final boolean a(u uVar, MenuItem menuItem) {
        return this.a.l != null && this.a.l.a();
    }

    public final void a(u uVar) {
        if (this.a.g != null) {
            this.a.g.a(uVar);
        }
    }
}
