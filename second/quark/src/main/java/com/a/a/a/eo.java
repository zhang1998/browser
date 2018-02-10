package com.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class eo {
    public static String a = null;
    private static JSONObject e = new JSONObject();
    public Application b = null;
    public ActivityLifecycleCallbacks c = new ei(this);
    private final Map<String, Long> d = new HashMap();

    public eo(Activity activity) {
        if (activity != null) {
            this.b = activity.getApplication();
            this.b.registerActivityLifecycleCallbacks(this.c);
            if (a == null) {
                a(activity);
            }
        }
    }

    public static void a(Context context) {
        try {
            synchronized (e) {
                if (e.length() > 0) {
                    aj.a(context);
                    aj.a(em.a(), e, aq.a);
                    e = new JSONObject();
                }
            }
        } catch (Throwable th) {
        }
    }

    private void a(Activity activity) {
        a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.d) {
            this.d.put(a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void a() {
        long j = 0;
        try {
            synchronized (this.d) {
                if (this.d.containsKey(a)) {
                    j = System.currentTimeMillis() - ((Long) this.d.get(a)).longValue();
                    this.d.remove(a);
                }
            }
            synchronized (e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    e = jSONObject;
                    jSONObject.put("page_name", a);
                    e.put("duration", j);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }
}
