package com.alibaba.analytics.a;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: ProGuard */
public final class n {
    private static n a = new n();
    private a b = new a();
    private k c = new k();

    private n() {
    }

    public static n a() {
        return a;
    }

    public final String[] a(String[] strArr) {
        Comparator comparator = this.c;
        if (comparator == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
