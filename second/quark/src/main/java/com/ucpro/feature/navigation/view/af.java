package com.ucpro.feature.navigation.view;

import java.util.List;

/* compiled from: ProGuard */
public final class af implements Runnable {
    public l a;
    public int b;
    public int c;
    final /* synthetic */ k d;

    protected af(k kVar) {
        this.d = kVar;
    }

    public final void run() {
        this.d.c();
        List list = this.d.d().a;
        if (this.b >= 0) {
            t.a(list, this.b, this.c);
        } else if (this.a != null) {
            list.add(this.c, this.a.i);
        }
        this.d.d().notifyDataSetChanged();
    }

    public final void a(int i, int i2) {
        this.b = i;
        this.c = i2;
    }
}
