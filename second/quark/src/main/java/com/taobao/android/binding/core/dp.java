package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class dp implements bg {
    dp() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        double min = Math.min(doubleValue, doubleValue4);
        if (min < doubleValue4 / 2.0d) {
            return Double.valueOf((((doubleValue3 - dy.c(doubleValue4 - (min * 2.0d), 0.0d, doubleValue3, doubleValue4)) + 0.0d) * 0.5d) + doubleValue2);
        }
        return Double.valueOf(((dy.c((min * 2.0d) - doubleValue4, 0.0d, doubleValue3, doubleValue4) * 0.5d) + (0.5d * doubleValue3)) + doubleValue2);
    }
}
