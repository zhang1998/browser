package com.alibaba.analytics.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class aa {
    public static am a(String str) {
        am amVar = new am();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                Object string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    amVar.a = true;
                }
            }
            if (jSONObject.has("ret")) {
                amVar.b = jSONObject.getString("ret");
            }
        } catch (JSONException e) {
        }
        return amVar;
    }
}
