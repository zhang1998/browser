package com.taobao.weex.ui.component.b;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: ProGuard */
public final class j implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ float b;
    final /* synthetic */ float c;
    final /* synthetic */ l d;

    public j(l lVar, View view, float f, float f2) {
        this.d = lVar;
        this.a = view;
        this.b = f;
        this.c = f2;
    }

    public final void run() {
        ViewGroup viewGroup = (ViewGroup) this.a.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.a);
        }
        this.d.a.addView(this.a);
        this.a.setTranslationX(this.b);
        this.a.setTranslationY(this.c);
    }
}
