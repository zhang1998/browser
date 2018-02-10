package com.taobao.weex.ui.component;

import android.view.View;

/* compiled from: ProGuard */
final class bm implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ float b;
    final /* synthetic */ float c;
    final /* synthetic */ bp d;

    bm(bp bpVar, View view, float f, float f2) {
        this.d = bpVar;
        this.a = view;
        this.b = f;
        this.c = f2;
    }

    public final void run() {
        bp.a(this.d, this.a, this.b, this.c);
    }
}
