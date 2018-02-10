package com.taobao.android.binding.core;

import android.graphics.Color;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class by implements bg {
    by() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        if (arrayList.size() < 4) {
            return null;
        }
        return Integer.valueOf(Color.argb((int) (((Double) arrayList.get(3)).doubleValue() * 255.0d), (int) ((Double) arrayList.get(0)).doubleValue(), (int) ((Double) arrayList.get(1)).doubleValue(), (int) ((Double) arrayList.get(2)).doubleValue()));
    }
}
