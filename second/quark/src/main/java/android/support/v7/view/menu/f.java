package android.support.v7.view.menu;

import android.support.v4.view.ba;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* compiled from: ProGuard */
final class f extends e<OnActionExpandListener> implements ba {
    final /* synthetic */ ab b;

    f(ab abVar, OnActionExpandListener onActionExpandListener) {
        this.b = abVar;
        super(onActionExpandListener);
    }

    public final boolean a(MenuItem menuItem) {
        return ((OnActionExpandListener) this.a).onMenuItemActionExpand(this.b.a(menuItem));
    }

    public final boolean b(MenuItem menuItem) {
        return ((OnActionExpandListener) this.a).onMenuItemActionCollapse(this.b.a(menuItem));
    }
}
