package com.ucpro.base.weex.b;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class b {
    public String a;
    public String b;
    public HashMap<String, String> c;
    private JSONObject d;

    public b(String str) {
        try {
            this.d = new JSONObject(str);
            this.a = this.d.getString("event_category");
            this.b = this.d.getString("event_action");
            this.c = this.d.has("key_value") ? a(this.d.getString("key_value")) : a(null);
        } catch (JSONException e) {
        }
    }

    private static HashMap a(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.getString(str2));
            }
        }
        return hashMap;
    }
}
