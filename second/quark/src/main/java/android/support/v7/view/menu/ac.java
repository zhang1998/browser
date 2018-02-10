package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.e.a.b;
import android.support.v4.e.a.c;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: ProGuard */
public final class ac {
    public static Menu a(Context context, c cVar) {
        if (VERSION.SDK_INT >= 14) {
            return new q(context, cVar);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem a(Context context, b bVar) {
        if (VERSION.SDK_INT >= 16) {
            return new v(context, bVar);
        }
        if (VERSION.SDK_INT >= 14) {
            return new ab(context, bVar);
        }
        throw new UnsupportedOperationException();
    }
}
