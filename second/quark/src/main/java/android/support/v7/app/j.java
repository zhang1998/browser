package android.support.v7.app;

import android.support.v7.view.menu.m;
import android.support.v7.view.menu.u;
import android.view.Window.Callback;

/* compiled from: ProGuard */
final class j implements m {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    private j(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final boolean a(u uVar) {
        Callback callback = this.a.j.getCallback();
        if (callback != null) {
            callback.onMenuOpened(108, uVar);
        }
        return true;
    }

    public final void a(u uVar, boolean z) {
        this.a.b(uVar);
    }
}
