package com.taobao.weex.ui.component.b;

import android.view.View;
import com.taobao.weex.ui.view.l;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ m b;
    final /* synthetic */ l c;

    k(l lVar, View view, m mVar) {
        this.c = lVar;
        this.a = view;
        this.b = mVar;
    }

    public final void run() {
        this.c.a.removeView(this.a);
        m mVar = this.b;
        ((l) mVar.getHostView()).removeView(mVar.c);
        ((l) mVar.getHostView()).addView(mVar.d);
        mVar.d.setTranslationX(0.0f);
        mVar.d.setTranslationY(0.0f);
    }
}
