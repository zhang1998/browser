package com.taobao.weex.ui.component.b;

import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.av;

/* compiled from: ProGuard */
final class c extends av {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    c(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.b.a() == 1) {
                recyclerView.a(0, this.a);
            } else {
                recyclerView.a(this.a, 0);
            }
            recyclerView.b((av) this);
        }
    }
}
