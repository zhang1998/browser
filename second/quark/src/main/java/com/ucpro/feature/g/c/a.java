package com.ucpro.feature.g.c;

import com.ucpro.feature.g.c.b.b;

/* compiled from: ProGuard */
final /* synthetic */ class a {
    static final /* synthetic */ int[] a = new int[b.values().length];

    static {
        try {
            a[b.WECHAT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[b.QQ.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[b.WEIBO.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
