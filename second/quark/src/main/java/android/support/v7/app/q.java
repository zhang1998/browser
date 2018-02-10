package android.support.v7.app;

import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.view.MenuItem;

/* compiled from: ProGuard */
final class q implements z {
    final /* synthetic */ an a;

    private q(an anVar) {
        this.a = anVar;
    }

    public final boolean a(u uVar, MenuItem menuItem) {
        return false;
    }

    public final void a(u uVar) {
        if (this.a.b == null) {
            return;
        }
        if (this.a.a.g()) {
            this.a.b.onPanelClosed(108, uVar);
        } else if (this.a.b.onPreparePanel(0, null, uVar)) {
            this.a.b.onMenuOpened(108, uVar);
        }
    }
}
