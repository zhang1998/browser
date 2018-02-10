package com.taobao.android.binding.core;

import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ double b;
    final /* synthetic */ ac c;
    final /* synthetic */ o d;

    m(o oVar, View view, double d, ac acVar) {
        this.d = oVar;
        this.a = view;
        this.b = d;
        this.c = acVar;
    }

    public final void run() {
        this.a.setScrollX((int) as.a(this.b, this.c));
        this.a.setScrollY((int) as.a(this.b, this.c));
    }
}
