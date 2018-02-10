package com.taobao.android.binding.core;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: ProGuard */
final class t implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ LayoutParams b;
    final /* synthetic */ u c;

    t(u uVar, View view, LayoutParams layoutParams) {
        this.c = uVar;
        this.a = view;
        this.b = layoutParams;
    }

    public final void run() {
        this.a.setLayoutParams(this.b);
    }
}
