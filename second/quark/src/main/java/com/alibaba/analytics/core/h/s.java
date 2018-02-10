package com.alibaba.analytics.core.h;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class s {
    Map<String, String> a = new HashMap();
    String b = null;

    private s() {
    }

    public static s a(String str) {
        try {
            s sVar = new s();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("stm")) {
                sVar.b = jSONObject.optString("stm");
            }
            if (jSONObject.has("arg1")) {
                Map hashMap = new HashMap();
                JSONObject optJSONObject = jSONObject.optJSONObject("arg1");
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        hashMap.put(str2, optJSONObject.optString(str2));
                    }
                }
                sVar.a = hashMap;
            }
            return sVar;
        } catch (Exception e) {
            return null;
        }
    }
}
