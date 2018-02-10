package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.e.a.c;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

/* compiled from: ProGuard */
class q extends y<c> implements Menu {
    q(Context context, c cVar) {
        super(context, cVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(((c) this.a).add(charSequence));
    }

    public MenuItem add(int i) {
        return a(((c) this.a).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(((c) this.a).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(((c) this.a).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((c) this.a).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return a(((c) this.a).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((c) this.a).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((c) this.a).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((c) this.a).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((c) this.a).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((c) this.a).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((c) this.a).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((c) this.a).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return a(((c) this.a).findItem(i));
    }

    public int size() {
        return ((c) this.a).size();
    }

    public MenuItem getItem(int i) {
        return a(((c) this.a).getItem(i));
    }

    public void close() {
        ((c) this.a).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((c) this.a).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((c) this.a).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((c) this.a).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((c) this.a).setQwertyMode(z);
    }

    public void removeItem(int i) {
        if (this.c != null) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
        ((c) this.a).removeItem(i);
    }

    public void removeGroup(int i) {
        if (this.c != null) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        ((c) this.a).removeGroup(i);
    }

    public void clear() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
        ((c) this.a).clear();
    }
}
