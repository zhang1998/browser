package com.uc.weex.component.c;

import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.av;

/* compiled from: ProGuard */
final class e extends av {
    final /* synthetic */ b a;
    final /* synthetic */ f b;

    e(f fVar, b bVar) {
        this.b = fVar;
        this.a = bVar;
    }

    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            float f = this.a.f / 2.0f;
            if (this.b.v > 0.0f && this.b.v < f) {
                recyclerView.a(0, (int) (-(((double) this.b.v) + 0.5d)));
            } else if (this.b.v >= f && this.b.v < this.a.f) {
                recyclerView.a(0, (int) (((double) (this.a.f - this.b.v)) + 0.5d));
            }
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        this.b.v = this.b.v + ((float) i2);
    }
}
