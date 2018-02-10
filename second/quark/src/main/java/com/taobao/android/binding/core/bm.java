package com.taobao.android.binding.core;

import java.util.ArrayList;

/* compiled from: ProGuard */
final class bm implements bg {
    bm() {
    }

    public final Object a(ArrayList<Object> arrayList) {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        if (doubleValue > 0.0d) {
            return Integer.valueOf(1);
        }
        if (doubleValue == 0.0d) {
            return Integer.valueOf(0);
        }
        if (doubleValue < 0.0d) {
            return Integer.valueOf(-1);
        }
        return Double.valueOf(Double.NaN);
    }
}
