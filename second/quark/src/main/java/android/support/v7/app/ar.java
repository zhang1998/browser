package android.support.v7.app;

import android.support.v7.view.menu.m;
import android.support.v7.view.menu.u;

/* compiled from: ProGuard */
final class ar implements m {
    final /* synthetic */ an a;
    private boolean b;

    private ar(an anVar) {
        this.a = anVar;
    }

    public final boolean a(u uVar) {
        if (this.a.b == null) {
            return false;
        }
        this.a.b.onMenuOpened(108, uVar);
        return true;
    }

    public final void a(u uVar, boolean z) {
        if (!this.b) {
            this.b = true;
            this.a.a.l();
            if (this.a.b != null) {
                this.a.b.onPanelClosed(108, uVar);
            }
            this.b = false;
        }
    }
}
