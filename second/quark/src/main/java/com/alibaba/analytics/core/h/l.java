package com.alibaba.analytics.core.h;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class l {
    private static final Random a = new Random();
    private int b = 0;
    private Map<String, Integer> c = new HashMap();

    private l() {
    }

    final boolean a(String str) {
        if (str != null) {
            try {
                for (String str2 : this.c.keySet()) {
                    if (str2.startsWith("%") && str2.endsWith("%")) {
                        if (str.contains(str2.substring(1, str2.length() - 1))) {
                            if (a(((Integer) this.c.get(str2)).intValue())) {
                                return true;
                            }
                            return false;
                        }
                    } else if (str.equals(str2)) {
                        if (a(((Integer) this.c.get(str2)).intValue())) {
                            return true;
                        }
                        return false;
                    }
                }
            } catch (Throwable th) {
            }
        }
        return a(this.b);
    }

    private static boolean a(int i) {
        if (i != 0 && a.nextInt(10000) < i) {
            return true;
        }
        return false;
    }

    public static l b(String str) {
        try {
            l lVar = new l();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("cp")) {
                lVar.b = jSONObject.optInt("cp");
            }
            if (jSONObject.has("arg1")) {
                Map hashMap = new HashMap();
                JSONObject optJSONObject = jSONObject.optJSONObject("arg1");
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        hashMap.put(str2, Integer.valueOf(Integer.parseInt(optJSONObject.optString(str2))));
                    }
                }
                lVar.c = hashMap;
            }
            return lVar;
        } catch (Exception e) {
            return null;
        }
    }
}
