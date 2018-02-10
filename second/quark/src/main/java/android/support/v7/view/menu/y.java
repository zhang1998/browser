package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.e.a.a;
import android.support.v4.e.a.b;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

/* compiled from: ProGuard */
abstract class y<T> extends e<T> {
    final Context b;
    Map<b, MenuItem> c;
    Map<a, SubMenu> d;

    y(Context context, T t) {
        super(t);
        this.b = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.c == null) {
            this.c = new android.support.v4.d.b();
        }
        MenuItem menuItem2 = (MenuItem) this.c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = ac.a(this.b, bVar);
        this.c.put(bVar, menuItem2);
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof a)) {
            return subMenu;
        }
        a aVar = (a) subMenu;
        if (this.d == null) {
            this.d = new android.support.v4.d.b();
        }
        SubMenu subMenu2 = (SubMenu) this.d.get(aVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        Context context = this.b;
        if (VERSION.SDK_INT >= 14) {
            subMenu2 = new l(context, aVar);
            this.d.put(aVar, subMenu2);
            return subMenu2;
        }
        throw new UnsupportedOperationException();
    }
}
