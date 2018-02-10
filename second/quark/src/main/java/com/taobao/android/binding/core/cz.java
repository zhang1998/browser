package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class cz implements bg {
    cz() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        doubleValue = Math.min(doubleValue, doubleValue4);
        return Double.valueOf(doubleValue == 0.0d ? doubleValue2 : (Math.pow(2.0d, ((doubleValue / doubleValue4) - 1.0d) * 10.0d) * doubleValue3) + doubleValue2);
    }
}
