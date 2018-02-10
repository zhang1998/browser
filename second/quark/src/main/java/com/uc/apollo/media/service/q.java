package com.uc.apollo.media.service;

import com.uc.apollo.rebound.Spring;
import com.uc.apollo.rebound.SpringConfig;

/* compiled from: ProGuard */
final class q extends c {
    q() {
        super();
    }

    public final void onSpringUpdate(Spring spring) {
        o.a(this.a, spring);
        if (o.C.a == this.a && spring.getCurrentValue() > 0.97d) {
            boolean z;
            a k = o.C;
            if (k.d == Integer.MAX_VALUE && k.g == Integer.MAX_VALUE) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                k = o.C;
                k.a++;
                k.b = k.l;
                k.e = k.m;
                k.h = k.n;
                k.i = k.o;
                k.a(1.0d);
                if (k.d != Integer.MAX_VALUE) {
                    k.c = k.d;
                    k.d = Integer.MAX_VALUE;
                } else {
                    k.c = k.l;
                }
                if (k.g != Integer.MAX_VALUE) {
                    k.f = k.g;
                    k.g = Integer.MAX_VALUE;
                } else {
                    k.f = k.m;
                }
                k.q = false;
                if (o.x == null) {
                    o.x = o.v.createSpring();
                    o.x.a(SpringConfig.fromOrigamiTensionAndFriction(30.0d, 30.0d));
                    o.x.a(o.z);
                }
                o.x.setCurrentValue(0.0d);
                o.x.setEndValue(1.0d);
            }
        }
    }
}
