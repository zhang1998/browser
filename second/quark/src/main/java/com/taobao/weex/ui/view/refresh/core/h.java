package com.taobao.weex.ui.view.refresh.core;

import android.animation.Animator;

/* compiled from: ProGuard */
final class h extends n {
    final /* synthetic */ WXSwipeLayout a;

    h(WXSwipeLayout wXSwipeLayout) {
        this.a = wXSwipeLayout;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.i.a();
        if (this.a.h != null) {
            this.a.h.b();
        }
    }
}
