package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class cw implements bg {
    cw() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        return Double.valueOf(((Math.cos((Math.min(doubleValue, doubleValue4) / doubleValue4) * 1.5707963267948966d) * (-doubleValue3)) + doubleValue3) + doubleValue2);
    }
}
