package com.taobao.weex.ui.component;

import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;

/* compiled from: ProGuard */
final class ax implements Runnable {
    final /* synthetic */ ab a;
    final /* synthetic */ be b;

    ax(be beVar, ab abVar) {
        this.b = beVar;
        this.a = abVar;
    }

    public final void run() {
        ((BaseBounceView) this.b.getHostView()).setHeaderView(this.a);
    }
}
