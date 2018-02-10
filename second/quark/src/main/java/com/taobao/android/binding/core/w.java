package com.taobao.android.binding.core;

import android.view.View;

/* compiled from: ProGuard */
final class w implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ float b;
    final /* synthetic */ x c;

    w(x xVar, View view, float f) {
        this.c = xVar;
        this.a = view;
        this.b = f;
    }

    public final void run() {
        this.a.setAlpha(this.b);
    }
}
