package android.support.v7.view;

import android.support.v4.e.a.b;
import android.support.v4.view.bl;
import android.support.v4.view.dw;
import android.support.v7.view.menu.ab;
import android.support.v7.view.menu.i;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

/* compiled from: ProGuard */
final class j {
    Menu a;
    int b;
    int c;
    int d;
    int e;
    boolean f;
    boolean g;
    boolean h;
    int i;
    int j;
    CharSequence k;
    CharSequence l;
    int m;
    char n;
    char o;
    int p;
    boolean q;
    boolean r;
    boolean s;
    int t;
    int u;
    String v;
    String w;
    String x;
    bl y;
    final /* synthetic */ i z;

    public j(i iVar, Menu menu) {
        this.z = iVar;
        this.a = menu;
        a();
    }

    public final void a() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = true;
    }

    static char a(String str) {
        if (str == null) {
            return '\u0000';
        }
        return str.charAt(0);
    }

    final void a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.q).setVisible(this.r).setEnabled(this.s).setCheckable(this.p > 0).setTitleCondensed(this.l).setIcon(this.m).setAlphabeticShortcut(this.n).setNumericShortcut(this.o);
        if (this.t >= 0) {
            dw.a(menuItem, this.t);
        }
        if (this.x != null) {
            if (this.z.e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new l(i.b(this.z), this.x));
        }
        if (this.p >= 2) {
            if (menuItem instanceof i) {
                ((i) menuItem).a(true);
            } else if (menuItem instanceof ab) {
                ab abVar = (ab) menuItem;
                try {
                    if (abVar.e == null) {
                        abVar.e = ((b) abVar.a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                    }
                    abVar.e.invoke(abVar.a, new Object[]{Boolean.valueOf(true)});
                } catch (Throwable e) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                }
            }
        }
        if (this.v != null) {
            dw.a(menuItem, (View) a(this.v, i.a, this.z.c));
        } else {
            z = false;
        }
        if (this.u > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                dw.b(menuItem, this.u);
            }
        }
        if (this.y != null) {
            dw.a(menuItem, this.y);
        }
    }

    public final SubMenu b() {
        this.h = true;
        SubMenu addSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
        a(addSubMenu.getItem());
        return addSubMenu;
    }

    final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor constructor = this.z.e.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }
}
