package com.taobao.android.binding.core;

import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ double b;
    final /* synthetic */ ac c;
    final /* synthetic */ q d;

    p(q qVar, View view, double d, ac acVar) {
        this.d = qVar;
        this.a = view;
        this.b = d;
        this.c = acVar;
    }

    public final void run() {
        this.a.setScrollX((int) as.a(this.b, this.c));
    }
}
