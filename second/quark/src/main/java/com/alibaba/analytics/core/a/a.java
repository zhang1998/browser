package com.alibaba.analytics.core.a;

/* compiled from: ProGuard */
final /* synthetic */ class a {
    static final /* synthetic */ int[] a = new int[d.values().length];

    static {
        try {
            a[d.REALTIME.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[d.BATCH.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[d.LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[d.DEVELOPMENT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
