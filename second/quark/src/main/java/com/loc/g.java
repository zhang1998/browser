package com.loc;

import android.os.Looper;
import android.os.Message;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ j a;

    g(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        dq dqVar;
        try {
            dqVar = this.a.c;
            dqVar.d = this.a.a;
            long interval = dqVar.d.getInterval();
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = dqVar.b.getMainLooper();
            }
            dqVar.g = interval;
            dqVar.h = dm.b();
            dqVar.e.a = dqVar.h;
            dqVar.c.requestLocationUpdates("gps", 1000, 0.0f, dqVar.k, myLooper);
        } catch (SecurityException e) {
            if (AMapLocationMode.Device_Sensors.equals(dqVar.d.getLocationMode())) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider("gps");
                aMapLocation.setErrorCode(12);
                aMapLocation.setLocationType(1);
                obtain.what = 2;
                obtain.obj = aMapLocation;
                if (dqVar.a != null) {
                    dqVar.a.sendMessage(obtain);
                }
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationManager$GPSTask", "run");
        }
    }
}
