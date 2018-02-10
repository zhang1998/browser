package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class db implements bg {
    db() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        double doubleValue5 = ((Double) arrayList.get(4)).doubleValue();
        double doubleValue6 = ((Double) arrayList.get(5)).doubleValue();
        double doubleValue7 = ((Double) arrayList.get(6)).doubleValue();
        double doubleValue8 = ((Double) arrayList.get(7)).doubleValue();
        doubleValue = Math.min(doubleValue, doubleValue4);
        if (doubleValue == doubleValue4) {
            return Double.valueOf(doubleValue2 + doubleValue3);
        }
        dw a = dy.a((float) doubleValue5, (float) doubleValue6, (float) doubleValue7, (float) doubleValue8);
        if (a == null) {
            a = new dw((float) doubleValue5, (float) doubleValue6, (float) doubleValue7, (float) doubleValue8);
            dx a2 = dy.c;
            if (a2.a.size() >= 4) {
                a2.a.removeFirst();
            }
            a2.a.addLast(a);
        }
        return Double.valueOf((((double) a.getInterpolation((float) (doubleValue / doubleValue4))) * doubleValue3) + doubleValue2);
    }
}
