package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.bl;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ProGuard */
class s extends bl {
    final ActionProvider c;
    final /* synthetic */ ab d;

    public s(ab abVar, Context context, ActionProvider actionProvider) {
        this.d = abVar;
        super(context);
        this.c = actionProvider;
    }

    public final View c() {
        return this.c.onCreateActionView();
    }

    public final boolean d() {
        return this.c.onPerformDefaultAction();
    }

    public final boolean e() {
        return this.c.hasSubMenu();
    }

    public final void a(SubMenu subMenu) {
        this.c.onPrepareSubMenu(this.d.a(subMenu));
    }
}
