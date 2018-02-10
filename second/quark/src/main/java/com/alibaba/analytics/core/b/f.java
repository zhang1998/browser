package com.alibaba.analytics.core.b;

import android.text.TextUtils;
import com.alibaba.analytics.core.h.e;
import com.alibaba.analytics.core.h.q;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class f implements q {
    private static f a;
    private Map<String, String> b = Collections.synchronizedMap(new HashMap());

    f() {
        e.a().a("loglevel", (q) this);
        b("loglevel", e.a().a("loglevel"));
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    public final String a(String str) {
        return (String) this.b.get(str);
    }

    public final void b(String str, String str2) {
        this.b.clear();
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    CharSequence optString = jSONObject.optString(str3);
                    if (!(TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString))) {
                        this.b.put(str3, optString);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
