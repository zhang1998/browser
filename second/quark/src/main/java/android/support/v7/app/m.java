package android.support.v7.app;

import android.support.v7.view.e;
import android.support.v7.view.menu.u;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

/* compiled from: ProGuard */
class m extends e {
    final /* synthetic */ w b;

    m(w wVar, Callback callback) {
        this.b = wVar;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.b.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.b.a(keyEvent.getKeyCode(), keyEvent);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof u)) {
            return super.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    public void onContentChanged() {
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        u uVar;
        if (menu instanceof u) {
            uVar = (u) menu;
        } else {
            uVar = null;
        }
        if (i == 0 && uVar == null) {
            return false;
        }
        if (uVar != null) {
            uVar.l = true;
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (uVar == null) {
            return onPreparePanel;
        }
        uVar.l = false;
        return onPreparePanel;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.b.e(i);
        return true;
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.b.d(i);
    }
}
