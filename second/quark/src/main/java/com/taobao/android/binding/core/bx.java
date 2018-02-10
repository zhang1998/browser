package com.taobao.android.binding.core;

import android.graphics.Color;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class bx implements bg {
    bx() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        if (arrayList.size() < 3) {
            return null;
        }
        return Integer.valueOf(Color.rgb((int) ((Double) arrayList.get(0)).doubleValue(), (int) ((Double) arrayList.get(1)).doubleValue(), (int) ((Double) arrayList.get(2)).doubleValue()));
    }
}
