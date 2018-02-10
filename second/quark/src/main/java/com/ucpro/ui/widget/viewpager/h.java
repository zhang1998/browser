package com.ucpro.ui.widget.viewpager;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ ProViewPager a;

    h(ProViewPager proViewPager) {
        this.a = proViewPager;
    }

    public final void run() {
        this.a.setScrollState(0);
        this.a.b();
    }
}
