package com.taobao.android.binding.core;

import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ double b;
    final /* synthetic */ ac c;
    final /* synthetic */ double d;
    final /* synthetic */ o e;

    n(o oVar, View view, double d, ac acVar, double d2) {
        this.e = oVar;
        this.a = view;
        this.b = d;
        this.c = acVar;
        this.d = d2;
    }

    public final void run() {
        this.a.setScrollX((int) as.a(this.b, this.c));
        this.a.setScrollY((int) as.a(this.d, this.c));
    }
}
