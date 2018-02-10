package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class dr implements bg {
    dr() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        doubleValue4 = Math.min(doubleValue, doubleValue4) / (doubleValue4 / 2.0d);
        if (doubleValue4 < 1.0d) {
            return Double.valueOf((doubleValue4 * ((doubleValue3 / 2.0d) * doubleValue4)) + doubleValue2);
        }
        doubleValue4 -= 1.0d;
        return Double.valueOf((((doubleValue4 * (doubleValue4 - 2.0d)) - 1.0d) * ((-doubleValue3) / 2.0d)) + doubleValue2);
    }
}
