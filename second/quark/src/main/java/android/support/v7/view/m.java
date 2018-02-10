package android.support.v7.view;

import android.content.Context;
import android.support.v4.d.s;
import android.support.v4.e.a.b;
import android.support.v4.e.a.c;
import android.support.v7.view.menu.ac;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class m implements d {
    final Callback a;
    final Context b;
    final ArrayList<b> c = new ArrayList();
    final s<Menu, Menu> d = new s();

    public m(Context context, Callback callback) {
        this.b = context;
        this.a = callback;
    }

    public final boolean a(h hVar, Menu menu) {
        return this.a.onCreateActionMode(b(hVar), a(menu));
    }

    public final boolean b(h hVar, Menu menu) {
        return this.a.onPrepareActionMode(b(hVar), a(menu));
    }

    public final boolean a(h hVar, MenuItem menuItem) {
        return this.a.onActionItemClicked(b(hVar), ac.a(this.b, (b) menuItem));
    }

    public final void a(h hVar) {
        this.a.onDestroyActionMode(b(hVar));
    }

    private Menu a(Menu menu) {
        Menu menu2 = (Menu) this.d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = ac.a(this.b, (c) menu);
        this.d.put(menu, menu2);
        return menu2;
    }

    public final ActionMode b(h hVar) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.c.get(i);
            if (bVar != null && bVar.b == hVar) {
                return bVar;
            }
        }
        ActionMode bVar2 = new b(this.b, hVar);
        this.c.add(bVar2);
        return bVar2;
    }
}
