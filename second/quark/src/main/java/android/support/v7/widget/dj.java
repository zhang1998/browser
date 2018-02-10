package android.support.v7.widget;

import android.support.v4.view.bo;
import android.support.v4.view.l;
import android.view.View;

/* compiled from: ProGuard */
public final class dj implements l {
    int a;
    final /* synthetic */ fo b;
    private boolean c = false;

    protected dj(fo foVar) {
        this.b = foVar;
    }

    public final dj a(bo boVar, int i) {
        this.b.h = boVar;
        this.a = i;
        return this;
    }

    public final void a(View view) {
        super.setVisibility(0);
        this.c = false;
    }

    public final void b(View view) {
        if (!this.c) {
            this.b.h = null;
            super.setVisibility(this.a);
        }
    }

    public final void c(View view) {
        this.c = true;
    }
}
