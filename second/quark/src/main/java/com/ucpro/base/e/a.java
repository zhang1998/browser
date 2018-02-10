package com.ucpro.base.e;

/* compiled from: ProGuard */
final /* synthetic */ class a {
    static final /* synthetic */ int[] a = new int[g.values().length];

    static {
        try {
            a[g.RESUME.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[g.PAUSE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[g.STOP.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[g.EXIT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
