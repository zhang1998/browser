package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class bz implements bg {
    bz() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        int a = ci.a((String) arrayList.get(0));
        int a2 = ci.a((String) arrayList.get(1));
        return ci.B.evaluate((float) ((Double) arrayList.get(2)).doubleValue(), Integer.valueOf(a), Integer.valueOf(a2));
    }
}
