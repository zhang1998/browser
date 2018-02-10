package com.loc;

import android.content.Context;
import android.net.NetworkInfo;
import com.uc.apollo.impl.SettingsConst;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class cz {
    private static cz d = null;
    bi a;
    bl b;
    int c;
    private int e;

    private cz() {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.e = cq.e;
        this.a = bi.a();
    }

    public static int a(NetworkInfo networkInfo) {
        return (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) ? networkInfo.getType() : -1;
    }

    public static synchronized cz a() {
        cz czVar;
        synchronized (cz.class) {
            if (d == null) {
                d = new cz();
            }
            czVar = d;
        }
        return czVar;
    }

    public final bq a(Context context, JSONObject jSONObject, dc dcVar, String str, boolean z) throws Exception {
        if (dm.a(jSONObject, "httptimeout")) {
            try {
                this.e = jSONObject.getInt("httptimeout");
            } catch (Throwable th) {
                cq.a(th, "LocNetManager", "req");
            }
        }
        if (a(dm.c(context)) == -1) {
            return null;
        }
        Map hashMap = new HashMap();
        bp daVar = new da(context, cq.a("loc", "2.8.0"));
        hashMap.clear();
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("gzipped", SettingsConst.TRUE);
        hashMap.put("Connection", "Keep-Alive");
        hashMap.put("User-Agent", "AMAP_Location_SDK_Android 2.8.0");
        hashMap.put("KEY", dx.f(context));
        hashMap.put("enginever", "4.2");
        String a = eg.a();
        String a2 = eg.a(context, a, "key=" + dx.f(context));
        hashMap.put("ts", a);
        hashMap.put("scode", a2);
        a = "loc";
        if (!z) {
            a = "locf";
        }
        hashMap.put("encr", SettingsConst.TRUE);
        daVar.i = z;
        daVar.j = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"2.8.0", a, Integer.valueOf(3)});
        daVar.f = hashMap;
        daVar.g = str;
        daVar.h = dm.a(dcVar.a());
        daVar.e = el.a(context);
        Map hashMap2 = new HashMap();
        hashMap2.put("output", "bin");
        hashMap2.put("policy", "2103");
        daVar.k = hashMap2;
        daVar.c = this.e;
        daVar.d = this.e;
        long b = dm.b();
        bq c = bi.c(daVar);
        this.c = Long.valueOf(dm.b() - b).intValue();
        return c;
    }

    public final String a(byte[] bArr, Context context, String str) {
        if (a(dm.c(context)) == -1) {
            return null;
        }
        String str2;
        Map hashMap = new HashMap();
        bp cyVar = new cy();
        hashMap.clear();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Connection", "Keep-Alive");
        cyVar.a = hashMap;
        cyVar.f = str;
        cyVar.g = bArr;
        cyVar.e = el.a(context);
        cyVar.c = cq.e;
        cyVar.d = cq.e;
        try {
            str2 = new String(bi.b(cyVar), "utf-8");
        } catch (Throwable th) {
            cq.a(th, "LocNetManager", "post");
            str2 = null;
        }
        return str2;
    }
}
