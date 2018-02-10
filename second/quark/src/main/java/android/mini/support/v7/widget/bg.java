package android.mini.support.v7.widget;

import android.mini.support.v4.view.a.r;
import android.mini.support.v4.view.h;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.RecyclerView.State;
import android.os.Bundle;
import android.view.View;

/* compiled from: ProGuard */
final class bg extends h {
    final /* synthetic */ bh b;

    bg(bh bhVar) {
        this.b = bhVar;
    }

    public final void a(View view, r rVar) {
        super.a(view, rVar);
        if (!this.b.a() && this.b.b.getLayoutManager() != null) {
            this.b.b.getLayoutManager().a(view, rVar);
        }
    }

    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (this.b.a() || this.b.b.getLayoutManager() == null) {
            return false;
        }
        LayoutManager layoutManager = this.b.b.getLayoutManager();
        ax axVar = layoutManager.q.b;
        State state = layoutManager.q.p;
        return false;
    }
}
