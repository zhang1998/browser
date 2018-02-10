package android.support.v7.app;

import android.support.v7.view.menu.m;
import android.support.v7.view.menu.u;
import android.view.Menu;
import android.view.Window.Callback;

/* compiled from: ProGuard */
final class n implements m {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    private n(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void a(u uVar, boolean z) {
        Menu menu;
        Menu c = uVar.c();
        boolean z2 = c != uVar;
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.a;
        if (z2) {
            menu = c;
        }
        PanelFeatureState a = appCompatDelegateImplV7.a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.a.a(a.a, a, c);
            this.a.a(a, true);
            return;
        }
        this.a.a(a, z);
    }

    public final boolean a(u uVar) {
        if (uVar == null && this.a.p) {
            Callback callback = this.a.j.getCallback();
            if (!(callback == null || this.a.v)) {
                callback.onMenuOpened(108, uVar);
            }
        }
        return true;
    }
}
