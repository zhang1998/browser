package com.taobao.weex.ui.view.refresh.core;

import android.animation.Animator;

/* compiled from: ProGuard */
final class f extends n {
    final /* synthetic */ WXSwipeLayout a;

    f(WXSwipeLayout wXSwipeLayout) {
        this.a = wXSwipeLayout;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.d();
    }
}
