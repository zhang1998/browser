package com.amap.api.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.loc.ac;
import com.loc.au;
import com.loc.cq;
import com.loc.dj;

/* compiled from: ProGuard */
public class APSService extends Service {
    APSServiceBase a;

    public IBinder onBind(Intent intent) {
        try {
            return this.a.onBind(intent);
        } catch (Throwable th) {
            cq.a(th, "APSService", "onBind");
            return null;
        }
    }

    public void onCreate() {
        onCreate(this);
    }

    public void onCreate(Context context) {
        try {
            if (dj.d(context)) {
                Context context2 = context;
                this.a = (APSServiceBase) ac.a(context2, cq.a("loc", "2.8.0"), "com.amap.api.location.APSServiceWrapper", au.class, new Class[]{Context.class}, new Object[]{context});
            } else if (this.a == null) {
                this.a = new au(this);
            }
        } catch (Throwable th) {
        }
        try {
            if (this.a == null) {
                this.a = new au(this);
            }
            this.a.onCreate();
        } catch (Throwable th2) {
            cq.a(th2, "APSService", "onCreate");
        }
        super.onCreate();
    }

    public void onDestroy() {
        try {
            this.a.onDestroy();
        } catch (Throwable th) {
            cq.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            return this.a.onStartCommand(intent, i, i2);
        } catch (Throwable th) {
            cq.a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }
}
