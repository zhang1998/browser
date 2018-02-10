package com.taobao.weex.ui.view.listview;

import android.mini.support.v7.widget.LinearLayoutManager;
import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.RecyclerView.State;
import android.mini.support.v7.widget.ax;
import android.mini.support.v7.widget.bc;

/* compiled from: ProGuard */
public final class b extends LinearLayoutManager {
    private bc a;

    public b(int i) {
        super(i);
    }

    public final boolean c() {
        return false;
    }

    public final void c(ax axVar, State state) {
        try {
            super.c(axVar, state);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public final int b(int i, ax axVar, State state) {
        try {
            return super.b(i, axVar, state);
        } catch (Exception e) {
            return 0;
        }
    }

    public final void a(RecyclerView recyclerView, int i) {
        if (this.a == null) {
            this.a = new a(this, recyclerView.getContext());
        }
        this.a.g = i;
        a(this.a);
    }
}
