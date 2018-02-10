package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.e.a.b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ProGuard */
public final class dw {
    static final ck a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            a = new dv();
        } else if (i >= 11) {
            a = new ds();
        } else {
            a = new bc();
        }
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof b) {
            ((b) menuItem).setShowAsAction(i);
        } else {
            a.a(menuItem, i);
        }
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        if (menuItem instanceof b) {
            return ((b) menuItem).setActionView(view);
        }
        return a.a(menuItem, view);
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        if (menuItem instanceof b) {
            return ((b) menuItem).setActionView(i);
        }
        return a.b(menuItem, i);
    }

    public static View a(MenuItem menuItem) {
        if (menuItem instanceof b) {
            return ((b) menuItem).getActionView();
        }
        return a.a(menuItem);
    }

    public static MenuItem a(MenuItem menuItem, bl blVar) {
        if (menuItem instanceof b) {
            return ((b) menuItem).a(blVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean b(MenuItem menuItem) {
        if (menuItem instanceof b) {
            return ((b) menuItem).expandActionView();
        }
        return a.b(menuItem);
    }

    public static boolean c(MenuItem menuItem) {
        if (menuItem instanceof b) {
            return ((b) menuItem).isActionViewExpanded();
        }
        return a.c(menuItem);
    }
}
