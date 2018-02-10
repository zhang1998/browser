package com.ucpro.feature.webwindow.j;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.bh;
import android.support.v7.widget.h;
import android.view.View;

/* compiled from: ProGuard */
final class e extends h {
    final /* synthetic */ g a;
    private int b;

    public e(g gVar, int i) {
        this.a = gVar;
        this.b = i;
    }

    public final void a(Rect rect, View view) {
        int d;
        bh b = RecyclerView.b(view);
        if (b != null) {
            d = b.d();
        } else {
            d = -1;
        }
        if (d != 0) {
            rect.top = this.b;
        }
    }
}
