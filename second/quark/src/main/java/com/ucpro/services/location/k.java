package com.ucpro.services.location;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;

/* compiled from: ProGuard */
public final class k {
    LocationManager a;
    AMapLocationClient b;
    c c;
    LocationListener d = new a(this);
    Handler e = new i(this, Looper.getMainLooper());
    private AMapLocationClientOption f;
    private Context g;
    private AMapLocationListener h = new l(this);

    public k(Context context, c cVar) {
        this.g = context;
        this.c = cVar;
        try {
            this.b = new AMapLocationClient(this.g);
            this.b.setLocationListener(this.h);
            this.b.setLocationOption(a());
        } catch (Exception e) {
            Log.e("LocationClientWrapper", "AMapLocationClient init fail");
        }
    }

    public final void a(boolean z) {
        if (this.b != null) {
            AMapLocationClientOption a = a();
            a.setOffset(z);
            this.b.setLocationOption(a);
            try {
                this.b.startLocation();
            } catch (Exception e) {
                Log.e("LocationClientWrapper", "Invoke AMapLocationClient.startLocation failed");
            }
            this.e.sendEmptyMessageDelayed(0, 10000);
            return;
        }
        a("network");
        this.e.sendEmptyMessageDelayed(1, 10000);
    }

    private AMapLocationClientOption a() {
        if (this.f == null) {
            this.f = new AMapLocationClientOption();
            this.f.setLocationMode(AMapLocationMode.Battery_Saving);
            this.f.setOnceLocation(true);
        }
        return this.f;
    }

    final void a(String str) {
        if (this.a == null) {
            this.a = (LocationManager) this.g.getSystemService("location");
        }
        try {
            this.a.requestLocationUpdates(str, 0, 0.0f, this.d);
        } catch (Exception e) {
            Log.e("LocationClientWrapper", "Invoke requestLocationUpdatesBySystem failed");
        }
    }
}
