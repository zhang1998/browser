package com.taobao.android.binding.core;

import java.util.ArrayList;

/* compiled from: ProGuard */
final class di implements bg {
    di() {
    }

    public final Object a(ArrayList<Object> arrayList) {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        double min = Math.min(doubleValue, doubleValue4);
        if (min == 0.0d) {
            return Double.valueOf(doubleValue2);
        }
        doubleValue = min / (doubleValue4 / 2.0d);
        if (doubleValue == 2.0d) {
            return Double.valueOf(doubleValue2 + doubleValue3);
        }
        double d = doubleValue4 * 0.44999999999999996d;
        if (doubleValue3 < Math.abs(doubleValue3)) {
            min = d / 4.0d;
        } else {
            min = (d / 6.283185307179586d) * Math.asin(doubleValue3 / doubleValue3);
        }
        if (doubleValue < 1.0d) {
            doubleValue -= 1.0d;
            return Double.valueOf(((Math.sin((((doubleValue * doubleValue4) - min) * 6.283185307179586d) / d) * (doubleValue3 * Math.pow(2.0d, 10.0d * doubleValue))) * -0.5d) + doubleValue2);
        }
        doubleValue -= 1.0d;
        return Double.valueOf((((Math.sin((((doubleValue * doubleValue4) - min) * 6.283185307179586d) / d) * (Math.pow(2.0d, -10.0d * doubleValue) * doubleValue3)) * 0.5d) + doubleValue3) + doubleValue2);
    }
}
