package com.taobao.weex.ui.component;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.taobao.weex.ui.view.WXCircleViewPager;
import com.taobao.weex.utils.WXViewUtils;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class bh extends SimpleOnGestureListener {
    private static final int a = WXViewUtils.f(50.0f);
    private static final int b = WXViewUtils.f(250.0f);
    private static final int c = WXViewUtils.f(200.0f);
    private WeakReference<WXCircleViewPager> d;

    bh(WXCircleViewPager wXCircleViewPager) {
        this.d = new WeakReference(wXCircleViewPager);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        WXCircleViewPager wXCircleViewPager = (WXCircleViewPager) this.d.get();
        if (wXCircleViewPager == null) {
            return false;
        }
        try {
            if (Math.abs(motionEvent.getY() - motionEvent2.getY()) > ((float) b)) {
                return false;
            }
            if (motionEvent.getX() - motionEvent2.getX() <= ((float) a) || Math.abs(f) <= ((float) c) || wXCircleViewPager.e() != 1) {
                if (motionEvent2.getX() - motionEvent.getX() > ((float) a) && Math.abs(f) > ((float) c) && wXCircleViewPager.e() == 0) {
                    wXCircleViewPager.a(1, false);
                    return true;
                }
                return false;
            }
            wXCircleViewPager.a(0, false);
            return true;
        } catch (Exception e) {
        }
    }
}
