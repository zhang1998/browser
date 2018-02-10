package com.a.a.a;

import org.json.JSONArray;

/* compiled from: ProGuard */
public final class bo {
    public static JSONArray a(String str) {
        String[] split = str.split("!");
        JSONArray jSONArray = new JSONArray();
        for (Object put : split) {
            jSONArray.put(put);
        }
        return jSONArray;
    }
}
