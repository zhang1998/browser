package com.uc.weex.component.c.a.a;

import android.mini.support.v7.widget.LinearLayoutManager;
import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/* compiled from: ProGuard */
public final class e implements a {
    protected final RecyclerView a;
    protected final b b;
    protected boolean c = false;

    public e(RecyclerView recyclerView) {
        this.a = recyclerView;
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if ((layoutManager instanceof LinearLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager)) {
            int i;
            if (layoutManager instanceof LinearLayoutManager) {
                i = ((LinearLayoutManager) layoutManager).i;
            } else {
                i = ((StaggeredGridLayoutManager) layoutManager).e;
            }
            if (i == 0) {
                this.b = new c(this);
                return;
            } else {
                this.b = new d(this);
                return;
            }
        }
        throw new IllegalArgumentException("Recycler views with custom layout managers are not supported by this adapter out of the box.Try implementing and providing an explicit 'impl' parameter to the other c'tors, or otherwise create a custom adapter subclass of your own.");
    }

    public final View a() {
        return this.a;
    }

    public final boolean b() {
        return !this.c && this.b.a();
    }

    public final boolean c() {
        return !this.c && this.b.b();
    }
}
