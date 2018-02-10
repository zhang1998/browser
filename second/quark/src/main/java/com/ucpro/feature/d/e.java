package com.ucpro.feature.d;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout.LayoutParams;

/* compiled from: ProGuard */
public final class e extends RecyclerView {
    b s = new b(getContext());

    public e(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        setLayoutManager(new GridLayoutManager(getContext(), 3));
        setAdapter(this.s);
        this.s.a.a();
    }

    public final void setOnSharePlatform(n nVar) {
        this.s.c = nVar;
    }
}
