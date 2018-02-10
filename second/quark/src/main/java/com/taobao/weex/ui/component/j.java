package com.taobao.weex.ui.component;

import com.taobao.weex.ui.view.k;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ l a;

    j(l lVar) {
        this.a = lVar;
    }

    public final void run() {
        this.a.a.hideSoftInputFromWindow(((k) this.a.getHostView()).getWindowToken(), 0);
    }
}
