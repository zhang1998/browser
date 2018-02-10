package com.taobao.android.binding.core;

import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ double b;
    final /* synthetic */ ac c;
    final /* synthetic */ s d;

    r(s sVar, View view, double d, ac acVar) {
        this.d = sVar;
        this.a = view;
        this.b = d;
        this.c = acVar;
    }

    public final void run() {
        this.a.setScrollY((int) as.a(this.b, this.c));
    }
}
