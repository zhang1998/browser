package com.ucpro.feature.downloadpage.dirselect.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.bd;
import java.util.List;

/* compiled from: ProGuard */
public final class f extends RecyclerView {
    private e s = new e(getContext());

    public f(Context context) {
        super(context);
        setAdapter(this.s);
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.g(0);
        setLayoutManager(linearLayoutManager);
    }

    public final void setData(List<d> list) {
        bd bdVar = this.s;
        if (list != null) {
            bdVar.c = list;
            bdVar.a.a();
        }
    }

    public final void setOnItemClick(c cVar) {
        this.s.d = cVar;
    }
}
