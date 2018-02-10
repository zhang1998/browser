package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class dj implements bg {
    dj() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        doubleValue4 = Math.min(doubleValue, doubleValue4) / doubleValue4;
        return Double.valueOf((((doubleValue4 * 2.70158d) - 1.70158d) * ((doubleValue3 * doubleValue4) * doubleValue4)) + doubleValue2);
    }
}
