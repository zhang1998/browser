package com.ucpro.feature.webwindow.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class i {
    public String a;
    public String b;
    public String c;
    public HashMap<String, String> d;
    private boolean e;

    public i(JSONObject jSONObject) {
        boolean z = true;
        this.a = jSONObject.optString("category");
        this.b = jSONObject.optString("event_category");
        this.c = jSONObject.optString("event_action");
        this.d = a(jSONObject.optString("key_value"));
        if (jSONObject.optInt("real_time", 0) != 1) {
            z = false;
        }
        this.e = z;
    }

    private static HashMap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject b = b(str);
        if (b == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator keys = b.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, b.optString(str2));
        }
        return hashMap;
    }

    private static JSONObject b(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }
}
