package com.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class ej {
    private static JSONObject b = new JSONObject();
    public final Map<String, Long> a = new HashMap();

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Long l;
            synchronized (this.a) {
                l = (Long) this.a.remove(str);
            }
            if (l != null) {
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                synchronized (b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        b = jSONObject;
                        jSONObject.put("page_name", str);
                        b.put("duration", currentTimeMillis);
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                synchronized (b) {
                    if (b.length() > 0) {
                        aj.a(context);
                        aj.a(em.a(), b, aq.b);
                        b = new JSONObject();
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
