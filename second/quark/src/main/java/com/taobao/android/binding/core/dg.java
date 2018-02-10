package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class dg implements bg {
    dg() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        double min = Math.min(doubleValue, doubleValue4);
        if (min == 0.0d) {
            return Double.valueOf(doubleValue2);
        }
        doubleValue = min / doubleValue4;
        if (doubleValue == 1.0d) {
            return Double.valueOf(doubleValue2 + doubleValue3);
        }
        double d = doubleValue4 * 0.3d;
        if (doubleValue3 < Math.abs(doubleValue3)) {
            min = d / 4.0d;
        } else {
            min = (d / 6.283185307179586d) * Math.asin(doubleValue3 / doubleValue3);
        }
        doubleValue -= 1.0d;
        return Double.valueOf((-(Math.sin((((doubleValue * doubleValue4) - min) * 6.283185307179586d) / d) * (doubleValue3 * Math.pow(2.0d, 10.0d * doubleValue)))) + doubleValue2);
    }
}
