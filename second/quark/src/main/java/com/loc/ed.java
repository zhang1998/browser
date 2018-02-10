package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class ed extends bj {
    private String f;
    private Map<String, String> g = null;

    ed(Context context, ep epVar, String str) {
        super(context, epVar);
        this.f = str;
    }

    private Map<String, String> j() {
        Object q = ei.q(this.a);
        if (!TextUtils.isEmpty(q)) {
            q = ek.b(new StringBuilder(q).reverse().toString());
        }
        Map<String, String> hashMap = new HashMap();
        hashMap.put("authkey", this.f);
        hashMap.put("plattype", "android");
        hashMap.put("product", this.b.a());
        hashMap.put("version", this.b.b());
        hashMap.put("output", "json");
        hashMap.put("androidversion", VERSION.SDK_INT);
        hashMap.put("deviceId", q);
        if (!(this.g == null || this.g.isEmpty())) {
            hashMap.putAll(this.g);
        }
        if (VERSION.SDK_INT >= 21) {
            try {
                ApplicationInfo applicationInfo = this.a.getApplicationInfo();
                Field declaredField = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                q = (String) declaredField.get(applicationInfo);
            } catch (Throwable th) {
                es.a(th, "ConfigManager", "getcpu");
            }
            if (TextUtils.isEmpty(q)) {
                q = Build.CPU_ABI;
            }
            hashMap.put("abitype", q);
            hashMap.put("ext", this.b.c());
            return hashMap;
        }
        q = null;
        if (TextUtils.isEmpty(q)) {
            q = Build.CPU_ABI;
        }
        hashMap.put("abitype", q);
        hashMap.put("ext", this.b.c());
        return hashMap;
    }

    public final Map<String, String> b() {
        return null;
    }

    public final String c() {
        return "https://restapi.amap.com/v3/iasdkauth";
    }

    protected final String g() {
        return "3.0";
    }

    public final byte[] h() {
        return null;
    }

    public final byte[] i() {
        return eq.a(eq.a(j()));
    }
}
