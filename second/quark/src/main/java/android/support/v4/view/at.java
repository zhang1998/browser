package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.b.ad;
import android.support.v4.view.b.s;
import android.support.v4.view.b.w;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class at extends co {
    final /* synthetic */ ViewPager a;

    at(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        ad a = w.a(accessibilityEvent);
        a.a(a());
        if (accessibilityEvent.getEventType() == SpdyProtocol.SLIGHTSSL_0_RTT_MODE && this.a.h != null) {
            a.a(this.a.h.a());
            a.b(this.a.i);
            a.c(this.a.i);
        }
    }

    public final void a(View view, s sVar) {
        super.a(view, sVar);
        sVar.b(ViewPager.class.getName());
        sVar.i(a());
        if (this.a.canScrollHorizontally(1)) {
            sVar.a((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
        }
        if (this.a.canScrollHorizontally(-1)) {
            sVar.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        }
    }

    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case SpdyProtocol.SLIGHTSSL_0_RTT_MODE /*4096*/:
                if (!this.a.canScrollHorizontally(1)) {
                    return false;
                }
                this.a.setCurrentItem(this.a.i + 1);
                return true;
            case SpdyProtocol.SLIGHTSSL_1_RTT_MODE /*8192*/:
                if (!this.a.canScrollHorizontally(-1)) {
                    return false;
                }
                this.a.setCurrentItem(this.a.i - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean a() {
        return this.a.h != null && this.a.h.a() > 1;
    }
}
