package com.ucpro.feature.g.c.b;

import android.support.v7.widget.bh;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class m<T> extends bh implements OnClickListener {
    int l;
    T m;
    Object n;
    private l o;

    public m(View view, l lVar) {
        super(view);
        this.o = lVar;
        view.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.o != null) {
            this.o.a(this.m);
        }
    }
}
