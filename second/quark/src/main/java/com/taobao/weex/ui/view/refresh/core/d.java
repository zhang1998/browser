package com.taobao.weex.ui.view.refresh.core;

import android.animation.Animator;

/* compiled from: ProGuard */
final class d extends n {
    final /* synthetic */ WXSwipeLayout a;

    d(WXSwipeLayout wXSwipeLayout) {
        this.a = wXSwipeLayout;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.b.a();
        if (this.a.g != null) {
            this.a.g.b();
        }
    }
}
