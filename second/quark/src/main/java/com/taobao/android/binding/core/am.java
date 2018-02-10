package com.taobao.android.binding.core;

import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class am implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ double b;
    final /* synthetic */ ac c;
    final /* synthetic */ an d;

    am(an anVar, View view, double d, ac acVar) {
        this.d = anVar;
        this.a = view;
        this.b = d;
        this.c = acVar;
    }

    public final void run() {
        this.a.setTranslationX((float) as.a(this.b, this.c));
    }
}
