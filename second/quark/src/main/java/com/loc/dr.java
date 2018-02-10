package com.loc;

import android.text.TextUtils;

/* compiled from: ProGuard */
final class dr implements Runnable {
    final /* synthetic */ ds a;

    dr(ds dsVar) {
        this.a = dsVar;
    }

    public final void run() {
        try {
            if (dm.a(this.a.b)) {
                Object toStr = this.a.b.toStr();
                Object obj = null;
                if (!TextUtils.isEmpty(toStr)) {
                    obj = ej.a(cp.c(toStr.getBytes("UTF-8"), this.a.a));
                }
                if (!TextUtils.isEmpty(obj)) {
                    toStr = new cw();
                    toStr.a = obj;
                    toStr.b = dm.a();
                    this.a.c.a(toStr, "_id=1");
                    this.a.d = dm.b();
                }
            }
        } catch (Throwable th) {
            cq.a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
