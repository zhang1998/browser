package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.e.a.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ProGuard */
final class l extends q implements SubMenu {
    l(Context context, a aVar) {
        super(context, aVar);
    }

    public final SubMenu setHeaderTitle(int i) {
        ((a) this.a).setHeaderTitle(i);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        ((a) this.a).setHeaderTitle(charSequence);
        return this;
    }

    public final SubMenu setHeaderIcon(int i) {
        ((a) this.a).setHeaderIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        ((a) this.a).setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        ((a) this.a).setHeaderView(view);
        return this;
    }

    public final void clearHeader() {
        ((a) this.a).clearHeader();
    }

    public final SubMenu setIcon(int i) {
        ((a) this.a).setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        ((a) this.a).setIcon(drawable);
        return this;
    }

    public final MenuItem getItem() {
        return a(((a) this.a).getItem());
    }
}
