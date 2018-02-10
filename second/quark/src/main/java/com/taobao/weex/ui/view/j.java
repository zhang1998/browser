package com.taobao.weex.ui.view;

import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class j implements Runnable {
    private WeakReference<WXCircleViewPager> a;

    private j(WXCircleViewPager wXCircleViewPager) {
        this.a = new WeakReference(wXCircleViewPager);
    }

    public final void run() {
        WXLogUtils.d("[CircleViewPager] trigger auto play action");
        WXCircleViewPager wXCircleViewPager = (WXCircleViewPager) this.a.get();
        if (wXCircleViewPager != null) {
            WXCircleViewPager.c(wXCircleViewPager);
            wXCircleViewPager.removeCallbacks(this);
            wXCircleViewPager.postDelayed(this, wXCircleViewPager.getIntervalTime());
        }
    }
}
