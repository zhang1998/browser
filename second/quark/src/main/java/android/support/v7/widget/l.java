package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.b.s;
import android.support.v4.view.co;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

/* compiled from: ProGuard */
final class l extends co {
    final /* synthetic */ ag a;

    l(ag agVar) {
        this.a = agVar;
    }

    public final void a(View view, s sVar) {
        super.a(view, sVar);
        if (!this.a.a() && this.a.a.getLayoutManager() != null) {
            this.a.a.getLayoutManager().a(view, sVar);
        }
    }

    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (this.a.a() || this.a.a.getLayoutManager() == null) {
            return false;
        }
        LayoutManager layoutManager = this.a.a.getLayoutManager();
        az azVar = layoutManager.b.b;
        v vVar = layoutManager.b.p;
        return false;
    }
}
