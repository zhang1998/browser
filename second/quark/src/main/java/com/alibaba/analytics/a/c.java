package com.alibaba.analytics.a;

/* compiled from: ProGuard */
public final class c {
    public static int a(String str) {
        if (b.b(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }
}
