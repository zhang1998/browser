package com.alibaba.appmonitor.b;

import com.alibaba.appmonitor.f.h;

/* compiled from: ProGuard */
final /* synthetic */ class g {
    static final /* synthetic */ int[] a = new int[h.values().length];

    static {
        try {
            a[h.ALARM.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[h.COUNTER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[h.STAT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
