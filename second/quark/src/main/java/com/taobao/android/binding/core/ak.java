package com.taobao.android.binding.core;

import android.view.View;
import com.taobao.weex.ac;

/* compiled from: ProGuard */
final class ak implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ double b;
    final /* synthetic */ ac c;
    final /* synthetic */ double d;
    final /* synthetic */ al e;

    ak(al alVar, View view, double d, ac acVar, double d2) {
        this.e = alVar;
        this.a = view;
        this.b = d;
        this.c = acVar;
        this.d = d2;
    }

    public final void run() {
        this.a.setTranslationX((float) as.a(this.b, this.c));
        this.a.setTranslationY((float) as.a(this.d, this.c));
    }
}
