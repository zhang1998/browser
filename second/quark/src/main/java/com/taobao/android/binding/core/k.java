package com.taobao.android.binding.core;

import android.view.View;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ int b;
    final /* synthetic */ l c;

    k(l lVar, View view, int i) {
        this.c = lVar;
        this.a = view;
        this.b = i;
    }

    public final void run() {
        this.a.setBackgroundColor(this.b);
    }
}
