package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.uc.apollo.media.MediaDefines;
import java.util.Hashtable;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class cv {
    private static cv c = null;
    Hashtable<String, JSONObject> a = new Hashtable();
    boolean b = false;

    private cv() {
    }

    public static synchronized cv a() {
        cv cvVar;
        synchronized (cv.class) {
            if (c == null) {
                c = new cv();
            }
            cvVar = c;
        }
        return cvVar;
    }

    public final void a(Context context) {
        if (ch.a && !this.b) {
            dm.b();
            try {
                cu.a().c(context);
            } catch (Throwable th) {
                cq.a(th, "HeatMap", "loadDB");
            }
            this.b = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r10, java.lang.String r11, com.autonavi.aps.amapapi.model.AmapLoc r12) {
        /*
        r9 = this;
        monitor-enter(r9);
        r3 = 0;
        r0 = com.loc.dm.a(r12);	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x000e;
    L_0x0008:
        if (r10 == 0) goto L_0x000e;
    L_0x000a:
        r0 = com.loc.ch.a;	 Catch:{ all -> 0x0065 }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r9);
        return;
    L_0x0010:
        r0 = r9.a;	 Catch:{ all -> 0x0065 }
        r0 = r0.size();	 Catch:{ all -> 0x0065 }
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 <= r1) goto L_0x002a;
    L_0x001a:
        r0 = r12.c;	 Catch:{ all -> 0x0065 }
        r2 = r12.b;	 Catch:{ all -> 0x0065 }
        r3 = com.loc.cj.a(r0, r2);	 Catch:{ all -> 0x0065 }
        r0 = r9.a;	 Catch:{ all -> 0x0065 }
        r0 = r0.containsKey(r3);	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x000e;
    L_0x002a:
        if (r3 != 0) goto L_0x0034;
    L_0x002c:
        r0 = r12.c;	 Catch:{ all -> 0x0065 }
        r2 = r12.b;	 Catch:{ all -> 0x0065 }
        r3 = com.loc.cj.a(r0, r2);	 Catch:{ all -> 0x0065 }
    L_0x0034:
        r0 = new org.json.JSONObject;	 Catch:{ all -> 0x0065 }
        r0.<init>();	 Catch:{ all -> 0x0065 }
        r1 = "key";
        r0.put(r1, r11);	 Catch:{ Throwable -> 0x005c }
        r1 = "lat";
        r4 = r12.c;	 Catch:{ Throwable -> 0x005c }
        r0.put(r1, r4);	 Catch:{ Throwable -> 0x005c }
        r1 = "lon";
        r4 = r12.b;	 Catch:{ Throwable -> 0x005c }
        r0.put(r1, r4);	 Catch:{ Throwable -> 0x005c }
        r4 = r0.toString();	 Catch:{ Throwable -> 0x005c }
        r5 = 1;
        r6 = com.loc.dm.a();	 Catch:{ Throwable -> 0x005c }
        r8 = 1;
        r1 = r9;
        r2 = r10;
        r1.a(r2, r3, r4, r5, r6, r8);	 Catch:{ Throwable -> 0x005c }
        goto L_0x000e;
    L_0x005c:
        r0 = move-exception;
        r1 = "HeatMap";
        r2 = "update";
        com.loc.cq.a(r0, r1, r2);	 Catch:{ all -> 0x0065 }
        goto L_0x000e;
    L_0x0065:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cv.a(android.content.Context, java.lang.String, com.autonavi.aps.amapapi.model.AmapLoc):void");
    }

    public final synchronized void a(Context context, String str, String str2, int i, long j, boolean z) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (ch.a) {
                    JSONObject jSONObject = (JSONObject) this.a.get(str);
                    JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
                    try {
                        jSONObject2.put("x", str2);
                        jSONObject2.put("time", j);
                        if (this.a.containsKey(str)) {
                            jSONObject2.put("num", jSONObject2.getInt("num") + i);
                        } else {
                            jSONObject2.put("num", i);
                        }
                    } catch (Throwable th) {
                        cq.a(th, "HeatMap", "update1");
                    }
                    this.a.put(str, jSONObject2);
                    if (i >= MediaDefines.MSG_ENABLE_VR_MODE && !cq.n) {
                        cq.n = true;
                        dl.a(context, "pref", "ddex", true);
                    }
                    if (z) {
                        try {
                            cu.a().a(context, str, str2, j);
                        } catch (Throwable th2) {
                            cq.a(th2, "HeatMap", "update");
                        }
                    }
                }
            }
        }
    }
}
