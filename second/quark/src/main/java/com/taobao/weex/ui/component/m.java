package com.taobao.weex.ui.component;

import android.graphics.Rect;
import android.view.View;

/* compiled from: ProGuard */
public final class m {
    public final ab a;
    public boolean[] b;
    public int c;
    private boolean d;
    private boolean e;
    private Rect f;

    public m(ab abVar) {
        this(abVar, 0);
    }

    public m(ab abVar, int i) {
        this.d = false;
        this.b = new boolean[]{false, false};
        this.e = false;
        this.f = new Rect();
        this.a = abVar;
        this.c = i;
    }

    public final boolean a() {
        return this.b[0] || this.b[1];
    }

    public final int a(boolean z) {
        if (this.d == z) {
            return 0;
        }
        this.d = z;
        return z ? 1 : -1;
    }

    public final int b(boolean z) {
        if (this.e == z) {
            return 0;
        }
        this.e = z;
        return z ? 1 : -1;
    }

    public final boolean b() {
        View hostView = this.a.getHostView();
        return hostView != null && hostView.getLocalVisibleRect(this.f);
    }

    public final boolean c() {
        if (!this.d || ((float) this.f.height()) / ((float) this.a.getHostView().getHeight()) < this.a.getCustomAppearProportion()) {
            return false;
        }
        return true;
    }
}
