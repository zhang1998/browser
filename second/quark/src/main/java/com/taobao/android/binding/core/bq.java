package com.taobao.android.binding.core;

import java.util.ArrayList;

/* compiled from: ProGuard */
final class bq implements bg {
    bq() {
    }

    public final Object a(ArrayList<Object> arrayList) {
        if (arrayList.size() <= 0) {
            return null;
        }
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        int size = arrayList.size();
        int i = 1;
        while (i < size) {
            double doubleValue2 = ((Double) arrayList.get(i)).doubleValue();
            if (doubleValue2 <= doubleValue) {
                doubleValue2 = doubleValue;
            }
            i++;
            doubleValue = doubleValue2;
        }
        return Double.valueOf(doubleValue);
    }
}
