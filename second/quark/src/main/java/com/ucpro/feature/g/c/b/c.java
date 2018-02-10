package com.ucpro.feature.g.c.b;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class c<T> extends RecyclerView {
    private int s = 1;
    private h t = new h();
    private GridLayoutManager u;

    public c(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.u = new GridLayoutManager(getContext(), this.s);
        setLayoutManager(this.u);
        setAdapter(this.t);
        this.t.a.a();
    }

    public final void setIProItemView(l lVar) {
        this.t.d = lVar;
    }

    public final void setSpanCount(int i) {
        this.s = i;
        setLayoutManager(new GridLayoutManager(getContext(), this.s));
    }

    public final void setOrientation(int i) {
        this.u.g(i);
    }

    public final void setData(ArrayList<T> arrayList) {
        this.t.c = arrayList;
        this.t.a.a();
    }

    public final void setTag(Object obj) {
        this.t.e = obj;
    }
}
