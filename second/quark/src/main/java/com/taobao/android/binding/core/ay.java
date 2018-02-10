package com.taobao.android.binding.core;

import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.av;
import android.text.TextUtils;
import com.taobao.weex.bridge.s;

/* compiled from: ProGuard */
final class ay extends av {
    int a = 0;
    int b = 0;
    final /* synthetic */ bb c;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean h;

    ay(bb bbVar, boolean z) {
        this.c = bbVar;
        this.h = z;
        if (!TextUtils.isEmpty(bbVar.n) && bb.m != null) {
            aw awVar = (aw) bb.m.get(bbVar.n);
            if (awVar != null) {
                this.a = awVar.a;
                this.b = awVar.b;
            }
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        this.a += i;
        this.b += i2;
        Object obj = null;
        if (!(bb.a(i, this.f) || this.h)) {
            this.d = this.a;
            obj = 1;
        }
        if (!bb.a(i2, this.g) && this.h) {
            this.e = this.b;
            obj = 1;
        }
        int i3 = this.a - this.d;
        int i4 = this.b - this.e;
        this.f = i;
        this.g = i2;
        if (obj != null) {
            this.c.a("turn", (float) this.a, (float) this.b, (float) i, (float) i2, (float) i3, (float) i4);
        } else {
            s.a().a(new ax(this, i, i2, i3, i4), this.c.d);
        }
    }
}
