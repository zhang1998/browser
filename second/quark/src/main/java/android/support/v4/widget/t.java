package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.b.ad;
import android.support.v4.view.b.s;
import android.support.v4.view.b.w;
import android.support.v4.view.co;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class t extends co {
    t() {
    }

    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int min;
        switch (i) {
            case SpdyProtocol.SLIGHTSSL_0_RTT_MODE /*4096*/:
                min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.a(min);
                return true;
            case SpdyProtocol.SLIGHTSSL_1_RTT_MODE /*8192*/:
                min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.a(min);
                return true;
            default:
                return false;
        }
    }

    public final void a(View view, s sVar) {
        super.a(view, sVar);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        sVar.b(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            int a = nestedScrollView.getScrollRange();
            if (a > 0) {
                sVar.i(true);
                if (nestedScrollView.getScrollY() > 0) {
                    sVar.a((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                }
                if (nestedScrollView.getScrollY() < a) {
                    sVar.a((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                }
            }
        }
    }

    public final void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        ad a = w.a(accessibilityEvent);
        a.a(nestedScrollView.getScrollRange() > 0);
        ad.a.e(a.b, nestedScrollView.getScrollX());
        ad.a.f(a.b, nestedScrollView.getScrollY());
        ad.a.a(a.b, nestedScrollView.getScrollX());
        ad.a.b(a.b, nestedScrollView.getScrollRange());
    }
}
