package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: ProGuard */
public final class an implements UncaughtExceptionHandler {
    private static an a;
    private UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private Context c;
    private ep d;

    private an(Context context, ep epVar) {
        this.c = context.getApplicationContext();
        this.d = epVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized an a(Context context, ep epVar) {
        an anVar;
        synchronized (an.class) {
            if (a == null) {
                a = new an(context, epVar);
            }
            anVar = a;
        }
        return anVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String a = eq.a(th);
        try {
            if (!TextUtils.isEmpty(a)) {
                if ((a.contains("amapdynamic") || a.contains("admic")) && a.contains("com.amap.api")) {
                    n nVar = new n(this.c, ao.b());
                    if (a.contains("loc")) {
                        ak.a(nVar, this.c, "loc");
                    }
                    if (a.contains("navi")) {
                        ak.a(nVar, this.c, "navi");
                    }
                    if (a.contains("sea")) {
                        ak.a(nVar, this.c, "sea");
                    }
                    if (a.contains("2dmap")) {
                        ak.a(nVar, this.c, "2dmap");
                    }
                    if (a.contains("3dmap")) {
                        ak.a(nVar, this.c, "3dmap");
                    }
                } else if (a.contains("com.autonavi.aps.amapapi.offline")) {
                    ak.a(new n(this.c, ao.b()), this.c, "OfflineLocation");
                } else if (a.contains("com.data.carrier_v4")) {
                    ak.a(new n(this.c, ao.b()), this.c, "Collection");
                }
            }
        } catch (Throwable th2) {
            es.a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }
}
