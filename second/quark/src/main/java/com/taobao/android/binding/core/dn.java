package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class dn implements bg {
    dn() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        return Double.valueOf(((doubleValue3 - dy.c(doubleValue4 - Math.min(doubleValue, doubleValue4), 0.0d, doubleValue3, doubleValue4)) + doubleValue2));
    }
}
