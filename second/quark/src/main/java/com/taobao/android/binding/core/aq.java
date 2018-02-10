package com.taobao.android.binding.core;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: ProGuard */
final class aq implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ LayoutParams b;
    final /* synthetic */ ar c;

    aq(ar arVar, View view, LayoutParams layoutParams) {
        this.c = arVar;
        this.a = view;
        this.b = layoutParams;
    }

    public final void run() {
        this.a.setLayoutParams(this.b);
    }
}
