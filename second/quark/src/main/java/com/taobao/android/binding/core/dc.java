package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class dc implements bg {
    dc() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        doubleValue = Math.min(doubleValue, doubleValue4);
        if (doubleValue == 0.0d) {
            return Double.valueOf(doubleValue2);
        }
        if (doubleValue == doubleValue4) {
            return Double.valueOf(doubleValue2 + doubleValue3);
        }
        doubleValue4 = doubleValue / (doubleValue4 / 2.0d);
        if (doubleValue4 < 1.0d) {
            return Double.valueOf((Math.pow(2.0d, (doubleValue4 - 1.0d) * 10.0d) * (doubleValue3 / 2.0d)) + doubleValue2);
        }
        return Double.valueOf((((-Math.pow(2.0d, (doubleValue4 - 1.0d) * -10.0d)) + 2.0d) * (doubleValue3 / 2.0d)) + doubleValue2);
    }
}
