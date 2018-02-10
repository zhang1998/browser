package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class ds {
    String a = null;
    AMapLocation b = null;
    n c;
    long d = 0;
    Runnable e = new dr(this);
    private Context f;
    private ExecutorService g = null;

    public ds(Context context) {
        this.f = context.getApplicationContext();
        try {
            this.a = cp.a("MD5", ei.i(this.f));
            this.c = new n(context, n.a(cx.class), dm.i());
        } catch (Throwable th) {
            cq.a(th, "LastLocationManager", "<init>:DBOperation");
        }
    }

    private synchronized void c() {
        if (this.g == null || this.g.isShutdown()) {
            this.g = fa.b();
        }
        this.g.submit(this.e);
    }

    private synchronized AMapLocation d() {
        AMapLocation aMapLocation = null;
        synchronized (this) {
            if (this.f != null) {
                AMapLocation a;
                try {
                    this.c = new n(this.f, n.a(cx.class), dm.i());
                    List a2 = this.c.a("_id=1", cw.class, false);
                    Object str = a2.size() > 0 ? new String(cp.d(ej.b(((cw) a2.get(0)).a), this.a), "UTF-8") : null;
                    if (!TextUtils.isEmpty(str)) {
                        a = cq.a(new JSONObject(str));
                        aMapLocation = a;
                    }
                } catch (Throwable th) {
                    cq.a(th, "LastLocationManager", "readLastFix");
                }
                a = null;
                aMapLocation = a;
            }
        }
        return aMapLocation;
    }

    public final synchronized AMapLocation a() {
        return this.b == null ? d() : this.b;
    }

    public final synchronized void a(AMapLocation aMapLocation) {
        if (!(this.f == null || !dm.a(aMapLocation) || aMapLocation.getLocationType() == 2)) {
            try {
                this.b = aMapLocation;
                if (dm.b() - this.d > 30000) {
                    c();
                }
            } catch (Throwable th) {
                cq.a(th, "LastLocationManager", "setLastFix");
            }
        }
    }

    public final synchronized void b() {
        try {
            c();
            if (this.g != null) {
                this.g.shutdown();
                this.g = null;
            }
            this.d = 0;
        } catch (Throwable th) {
            cq.a(th, "LastLocationManager", "destroy");
        }
    }
}
