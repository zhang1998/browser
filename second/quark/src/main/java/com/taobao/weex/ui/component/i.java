package com.taobao.weex.ui.component;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ l a;

    i(l lVar) {
        this.a = lVar;
    }

    public final void run() {
        this.a.a.showSoftInput(this.a.getHostView(), 1);
    }
}
