package com.c.a.b;

import android.app.Activity;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ Activity b;
    final /* synthetic */ c c;

    d(c cVar, int i, Activity activity) {
        this.c = cVar;
        this.a = i;
        this.b = activity;
    }

    public final void run() {
        if (this.a != this.c.d) {
            this.c.d = this.a;
            this.c.a(this.b, this.c.d);
        }
    }
}
