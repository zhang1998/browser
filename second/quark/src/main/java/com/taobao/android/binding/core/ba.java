package com.taobao.android.binding.core;

import com.taobao.weex.bridge.s;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.q;

/* compiled from: ProGuard */
final class ba implements q {
    int a;
    int b;
    final /* synthetic */ bb c;
    private int d;
    private int e;
    private int f;
    private int g;

    private ba(bb bbVar) {
        this.c = bbVar;
        this.a = 0;
        this.b = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public final void a(WXScrollView wXScrollView, int i, int i2) {
        int i3 = i - this.a;
        int i4 = i2 - this.b;
        this.a = i;
        this.b = i2;
        if (i3 != 0 || i4 != 0) {
            Object obj;
            if (bb.a(i4, this.g)) {
                obj = null;
            } else {
                this.e = this.b;
                obj = 1;
            }
            int i5 = this.a - this.d;
            int i6 = this.b - this.e;
            this.f = i3;
            this.g = i4;
            bb.a(this.c, this.a, this.b, i3, i4, i5, i6);
            if (obj != null) {
                this.c.a("turn", (float) this.a, (float) this.b, (float) i3, (float) i4, (float) i5, (float) i6);
                return;
            }
            s.a().a(new az(this, i3, i4, i5, i6), this.c.d);
        }
    }

    public final void a(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
    }

    public final void b(WXScrollView wXScrollView, int i, int i2) {
    }

    public final void a(boolean z) {
    }

    public final void a(int i, int i2, int i3, int i4) {
    }
}
