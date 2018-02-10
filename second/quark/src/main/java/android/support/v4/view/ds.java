package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

/* compiled from: ProGuard */
class ds implements ck {
    ds() {
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public boolean c(MenuItem menuItem) {
        return false;
    }

    public final void a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public final MenuItem a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public final MenuItem b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public final View a(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
