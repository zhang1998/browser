package com.ucpro.services.location;

import android.util.Log;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;

/* compiled from: ProGuard */
final class l implements AMapLocationListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void onLocationChanged(AMapLocation aMapLocation) {
        this.a.e.removeMessages(0);
        if (aMapLocation.getErrorCode() != 0) {
            Log.e("LocationClientWrapper", "requestLocation via amap failed: " + aMapLocation.toString());
            this.a.e.sendEmptyMessage(0);
            return;
        }
        this.a.c.a(aMapLocation);
    }
}
