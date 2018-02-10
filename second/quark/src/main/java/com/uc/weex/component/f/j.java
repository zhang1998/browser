package com.uc.weex.component.f;

import android.mini.support.v7.widget.LinearLayoutManager;
import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.av;
import android.view.View;

/* compiled from: ProGuard */
final class j extends av {
    final /* synthetic */ k a;

    private j(k kVar) {
        this.a = kVar;
    }

    public final void a(RecyclerView recyclerView, int i) {
        this.a.g = i;
        if (i == 0 && recyclerView.getLayoutManager().n() > 0) {
            int bottom;
            View e = recyclerView.getLayoutManager().e(recyclerView.getLayoutManager().n() - 1);
            if (e != null) {
                bottom = e.getBottom();
                int bottom2 = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                recyclerView.getLayoutManager();
                int a = LayoutManager.a(e);
                if (bottom == bottom2 && a == recyclerView.getLayoutManager().s() - 1) {
                    this.a.a();
                    return;
                }
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            bottom = linearLayoutManager.j();
            e = linearLayoutManager.a(bottom);
            if (e != null && e.getTop() == recyclerView.getTop() + recyclerView.getPaddingTop() && bottom == 0 && this.a.d != null) {
                this.a.d.run();
            }
        }
    }
}
