package android.mini.support.v4.view;

import android.mini.support.v4.view.a.ak;
import android.mini.support.v4.view.a.e;
import android.mini.support.v4.view.a.r;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class bw extends h {
    final /* synthetic */ ViewPager b;

    bw(ViewPager viewPager) {
        this.b = viewPager;
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        ak a = e.a(accessibilityEvent);
        a.a(a());
        if (accessibilityEvent.getEventType() == SpdyProtocol.SLIGHTSSL_0_RTT_MODE && this.b.c != null) {
            a.a(this.b.c.a());
            a.b(this.b.t);
            a.c(this.b.t);
        }
    }

    public final void a(View view, r rVar) {
        super.a(view, rVar);
        rVar.a(ViewPager.class.getName());
        rVar.a(a());
        if (this.b.canScrollHorizontally(1)) {
            rVar.a((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
        }
        if (this.b.canScrollHorizontally(-1)) {
            rVar.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        }
    }

    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case SpdyProtocol.SLIGHTSSL_0_RTT_MODE /*4096*/:
                if (!this.b.canScrollHorizontally(1)) {
                    return false;
                }
                this.b.setCurrentItem(this.b.t + 1);
                return true;
            case SpdyProtocol.SLIGHTSSL_1_RTT_MODE /*8192*/:
                if (!this.b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.b.setCurrentItem(this.b.t - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean a() {
        return this.b.c != null && this.b.c.a() > 1;
    }
}
