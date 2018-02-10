package com.ucpro.feature.webwindow;

import com.ucpro.feature.webwindow.e.a.a;

/* compiled from: ProGuard */
final class q implements a {
    final /* synthetic */ bb a;

    q(bb bbVar) {
        this.a = bbVar;
    }

    public final void a(int i) {
        if (this.a.y != null && !this.a.J) {
            ab c = this.a.y;
            if (!c.i && c.j) {
                if (c.h == -1) {
                    c.h = i;
                    return;
                }
                int i2 = c.h - i;
                if (i2 < (-c.getScrollThresholdForChangeAddressBar())) {
                    c.e();
                } else if (i2 > c.getScrollThresholdForChangeAddressBar() && c.f != 0) {
                    c.d();
                }
            }
        }
    }
}
