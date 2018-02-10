package com.taobao.android.binding.core;

import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class ao implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ double b;
    final /* synthetic */ ac c;
    final /* synthetic */ ap d;

    ao(ap apVar, View view, double d, ac acVar) {
        this.d = apVar;
        this.a = view;
        this.b = d;
        this.c = acVar;
    }

    public final void run() {
        this.a.setTranslationY((float) as.a(this.b, this.c));
    }
}
