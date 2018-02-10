package android.support.v7.widget;

import android.support.v7.view.menu.u;
import android.view.View;

/* compiled from: ProGuard */
final class fd implements Runnable {
    final /* synthetic */ ActionMenuPresenter a;
    private ef b;

    public fd(ActionMenuPresenter actionMenuPresenter, ef efVar) {
        this.a = actionMenuPresenter;
        this.b = efVar;
    }

    public final void run() {
        u uVar = this.a.c;
        if (uVar.c != null) {
            uVar.c.a(uVar);
        }
        View view = (View) this.a.g;
        if (!(view == null || view.getWindowToken() == null || !this.b.a())) {
            this.a.o = this.b;
        }
        this.a.q = null;
    }
}
