package android.support.v7.widget;

import android.support.v7.view.menu.a;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.u;

/* compiled from: ProGuard */
final class ei implements m {
    final /* synthetic */ ActionMenuPresenter a;

    private ei(ActionMenuPresenter actionMenuPresenter) {
        this.a = actionMenuPresenter;
    }

    public final boolean a(u uVar) {
        if (uVar == null) {
            return false;
        }
        this.a.s = ((a) uVar).getItem().getItemId();
        m mVar = this.a.f;
        return mVar != null ? mVar.a(uVar) : false;
    }

    public final void a(u uVar, boolean z) {
        if (uVar instanceof a) {
            ((a) uVar).a.a(false);
        }
        m mVar = this.a.f;
        if (mVar != null) {
            mVar.a(uVar, z);
        }
    }
}
