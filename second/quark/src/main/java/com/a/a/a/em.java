package com.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.a.a.b;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class em {
    public static Context a = null;
    private static String d = null;
    private final String b = "a_start_time";
    private final String c = "a_end_time";

    private static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        String string = sharedPreferences.getString("session_id", null);
        if (string == null) {
            return false;
        }
        long j = sharedPreferences.getLong("session_start_time", 0);
        long j2 = sharedPreferences.getLong("session_end_time", 0);
        if (j2 != 0) {
            Math.abs(j2 - j);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", string);
            jSONObject.put("__e", j);
            jSONObject.put("__f", j2);
            double[] a = b.a();
            if (a != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", a[0]);
                jSONObject2.put("lng", a[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put("__d", jSONObject2);
            }
            Class cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
            Method method2 = cls.getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
            if (context.getApplicationInfo().uid == -1) {
                return false;
            }
            long longValue = ((Long) method.invoke(null, new Object[]{Integer.valueOf(context.getApplicationInfo().uid)})).longValue();
            j = ((Long) method2.invoke(null, new Object[]{Integer.valueOf(r8)})).longValue();
            if (longValue > 0 && j > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("download_traffic", longValue);
                jSONObject3.put("upload_traffic", j);
                jSONObject.put("__c", jSONObject3);
            }
            aj.a(context);
            aj.a(string, jSONObject, aq.e);
            ej.a(a);
            eo.a(a);
            Editor edit = sharedPreferences.edit();
            edit.remove("session_start_time");
            edit.remove("session_end_time");
            edit.remove("a_start_time");
            edit.remove("a_end_time");
            edit.commit();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static String f(Context context) {
        String c = ey.c(context);
        String a = b.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (a == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis).append(a).append(c);
        c = fu.a(stringBuilder.toString());
        d = c;
        return c;
    }

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            if (sharedPreferences.getLong("a_start_time", 0) == 0 && b.e) {
                fw.d("onPause called before onResume");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = sharedPreferences.edit();
            edit.putLong("a_start_time", 0);
            edit.putLong("a_end_time", currentTimeMillis);
            edit.putLong("session_end_time", currentTimeMillis);
            edit.commit();
        }
    }

    public static boolean a(SharedPreferences sharedPreferences) {
        long j = sharedPreferences.getLong("a_start_time", 0);
        long j2 = sharedPreferences.getLong("a_end_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j != 0 && currentTimeMillis - j < b.g) {
            fw.d("onResume called before onPause");
            return false;
        } else if (currentTimeMillis - j2 <= b.g) {
            return false;
        } else {
            Object d = d(a);
            if (!TextUtils.isEmpty(d)) {
                long j3 = sharedPreferences.getLong("session_end_time", 0);
                if (j3 == 0) {
                    j3 = System.currentTimeMillis();
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("__f", j3);
                    aj.a(a);
                    aj.a(d, jSONObject, aq.d);
                } catch (Throwable th) {
                }
            }
            return true;
        }
    }

    public static String a(Context context, SharedPreferences sharedPreferences) {
        ef a = ef.a(context);
        String f = f(context);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", currentTimeMillis);
            aj.a(a);
            aj.a(f, jSONObject, aq.c);
        } catch (Throwable th) {
        }
        e(context);
        Editor edit = sharedPreferences.edit();
        edit.putString("session_id", f);
        edit.putLong("session_start_time", System.currentTimeMillis());
        edit.putLong("session_end_time", 0);
        edit.putLong("a_start_time", currentTimeMillis);
        edit.putLong("a_end_time", 0);
        edit.putInt("versioncode", Integer.parseInt(ey.a(context)));
        edit.putString("versionname", ey.b(context));
        edit.commit();
        a.a(Boolean.valueOf(true));
        return f;
    }

    public static boolean b(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (!(sharedPreferences == null || sharedPreferences.getString("session_id", null) == null)) {
            long j = sharedPreferences.getLong("a_start_time", 0);
            long j2 = sharedPreferences.getLong("a_end_time", 0);
            if (j > 0 && j2 == 0) {
                z = true;
                a(context);
            }
            j = sharedPreferences.getLong("session_end_time", 0);
            try {
                JSONObject jSONObject = new JSONObject();
                String str = "__f";
                if (j == 0) {
                    j = System.currentTimeMillis();
                }
                jSONObject.put(str, j);
                aj.a(a);
                aj.a(d(a), jSONObject, aq.d);
            } catch (Throwable th) {
            }
            e(context);
        }
        return z;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            String f = f(context);
            Editor edit = sharedPreferences.edit();
            long currentTimeMillis = System.currentTimeMillis();
            edit.putString("session_id", f);
            edit.putLong("session_start_time", System.currentTimeMillis());
            edit.putLong("session_end_time", 0);
            edit.putLong("a_start_time", currentTimeMillis);
            edit.putLong("a_end_time", 0);
            edit.putInt("versioncode", Integer.parseInt(ey.a(context)));
            edit.putString("versionname", ey.b(context));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("__e", currentTimeMillis);
                aj.a(a);
                aj.a(f, jSONObject, aq.c);
            } catch (Throwable th) {
            }
            edit.commit();
        }
    }

    public static String d(Context context) {
        if (d == null) {
            d = context.getSharedPreferences("umeng_general_config", 0).getString("session_id", null);
        }
        return d;
    }

    public static String a() {
        return d(a);
    }
}
