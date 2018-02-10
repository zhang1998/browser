package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

/* compiled from: ProGuard */
final class n extends e<OnMenuItemClickListener> implements OnMenuItemClickListener {
    final /* synthetic */ ab b;

    n(ab abVar, OnMenuItemClickListener onMenuItemClickListener) {
        this.b = abVar;
        super(onMenuItemClickListener);
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.a).onMenuItemClick(this.b.a(menuItem));
    }
}
