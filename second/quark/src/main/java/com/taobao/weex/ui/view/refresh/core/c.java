package com.taobao.weex.ui.view.refresh.core;

import android.animation.Animator;

/* compiled from: ProGuard */
public final class c extends n {
    final /* synthetic */ WXSwipeLayout a;

    public c(WXSwipeLayout wXSwipeLayout) {
        this.a = wXSwipeLayout;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.c();
        this.a.a = false;
    }
}
