package com.ucpro.services.location;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.location.AMapLocation;
import com.ucpro.services.b.a;
import com.ucpro.services.b.c;
import com.ucpro.services.b.e;
import com.ucpro.services.b.h;
import com.ucpro.services.b.i;
import com.ucweb.common.util.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class LocationDex extends Handler {
    private static final String TAG = "LocationDex";
    private boolean mIsLocationRequestStarted = false;
    private c mLocationCallback = new h(this);
    private k mLocationClient = new k(d.a(), this.mLocationCallback);
    private List<e> mNoOffsetRequestListeners = new ArrayList();
    private List<e> mOffsetRequestListeners = new ArrayList();
    private long mStartLocationRequestTime;

    public LocationDex(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        Map map = (Map) message.obj;
        switch (message.what) {
            case 0:
                requestLocationUpdates((e) map.get("listener"));
                return;
            case 1:
                requestLocationUpdates((e) map.get("listener"), ((Boolean) map.get("isOffset")).booleanValue());
                return;
            case 2:
                removeUpdates((e) map.get("listener"));
                return;
            case 3:
                destroy();
                return;
            default:
                Log.e(TAG, "LocationDex received unexpected msg, msgCode: " + message.what);
                return;
        }
    }

    public void requestLocationUpdates(e eVar) {
        requestLocationUpdates(eVar, true);
    }

    public void requestLocationUpdates(e eVar, boolean z) {
        if (z) {
            this.mOffsetRequestListeners.add(eVar);
        } else {
            this.mNoOffsetRequestListeners.add(eVar);
        }
        e b = e.b();
        Context a = d.a();
        String[] strArr = c.c;
        i mVar = new m(this, z);
        int a2 = e.a();
        h hVar = new h(new a(a, a2, strArr));
        hVar.b = mVar;
        b.a(a2, hVar);
        if (hVar.a == null) {
            return;
        }
        if (hVar.a.a()) {
            hVar.b();
        } else if (hVar.a.c()) {
            hVar.a.b();
        } else {
            hVar.a.d();
        }
    }

    public void destroy() {
        k kVar = this.mLocationClient;
        try {
            if (kVar.a != null) {
                kVar.a.removeUpdates(kVar.d);
                kVar.a = null;
            }
            if (kVar.b != null) {
                if (kVar.b.isStarted()) {
                    kVar.b.stopLocation();
                }
                kVar.b.onDestroy();
                kVar.b = null;
            }
        } catch (Exception e) {
            Log.e("LocationClientWrapper", "Invoke destroy() failed");
        }
    }

    public void removeUpdates(e eVar) {
        if (this.mOffsetRequestListeners.contains(eVar)) {
            new StringBuilder("remove updates from requestLists:").append(eVar);
            this.mOffsetRequestListeners.remove(eVar);
        } else if (this.mNoOffsetRequestListeners.contains(eVar)) {
            this.mNoOffsetRequestListeners.remove(eVar);
            new StringBuilder("remove updates from requestLists:").append(eVar);
        }
    }

    private void doStatisticsWork() {
    }

    private UcLocation convertLocation(Location location) {
        UcLocation ucLocation = new UcLocation();
        ucLocation.set(location);
        return ucLocation;
    }

    private UcLocation convertLocation(AMapLocation aMapLocation) {
        UcLocation ucLocation = new UcLocation();
        ucLocation.set(aMapLocation);
        ucLocation.setProvider(aMapLocation.getProvider());
        ucLocation.setTime(aMapLocation.getTime());
        ucLocation.setLatitude(aMapLocation.getLatitude());
        ucLocation.setLongitude(aMapLocation.getLongitude());
        ucLocation.setSpeed(aMapLocation.getSpeed());
        ucLocation.setBearing(aMapLocation.getBearing());
        ucLocation.setAccuracy(aMapLocation.getAccuracy());
        ucLocation.setExtras(aMapLocation.getExtras());
        ucLocation.a = aMapLocation.getCountry();
        ucLocation.b = aMapLocation.getProvince();
        ucLocation.c = aMapLocation.getCity();
        ucLocation.d = aMapLocation.getDistrict();
        ucLocation.e = aMapLocation.getAdCode();
        ucLocation.f = aMapLocation.getErrorCode();
        ucLocation.g = aMapLocation.getAddress();
        ucLocation.h = aMapLocation.getCityCode();
        ucLocation.j = aMapLocation.getRoad();
        ucLocation.i = aMapLocation.getPoiName();
        ucLocation.k = aMapLocation.isOffset();
        return ucLocation;
    }

    private void dispatchResponse(UcLocation ucLocation) {
        for (e a : this.mOffsetRequestListeners) {
            a.a(ucLocation);
        }
        this.mOffsetRequestListeners.clear();
        for (e a2 : this.mNoOffsetRequestListeners) {
            a2.a(ucLocation);
        }
        this.mNoOffsetRequestListeners.clear();
    }

    private void dispatchResponse(UcLocation ucLocation, boolean z) {
        if (z) {
            for (e a : this.mOffsetRequestListeners) {
                a.a(ucLocation);
            }
            this.mOffsetRequestListeners.clear();
            if (!this.mNoOffsetRequestListeners.isEmpty()) {
                this.mLocationClient.a(false);
                return;
            }
            return;
        }
        for (e a2 : this.mNoOffsetRequestListeners) {
            a2.a(ucLocation);
        }
        this.mNoOffsetRequestListeners.clear();
        if (!this.mOffsetRequestListeners.isEmpty()) {
            this.mLocationClient.a(true);
        }
    }

    private void sendNotification(UcLocation ucLocation) {
    }

    private void updateSystemInfo(UcLocation ucLocation) {
        if (ucLocation != null) {
            double latitude = ucLocation.getLatitude();
            double longitude = ucLocation.getLongitude();
            String str = ucLocation.c;
            String str2 = ucLocation.d;
            String str3 = ucLocation.b;
            UcLocation ucLocation2 = new UcLocation();
            ucLocation2.c = str;
            ucLocation2.d = str2;
            if (!com.ucweb.common.util.n.a.a(str3)) {
                str = str3;
            }
            ucLocation2.b = str;
            ucLocation2.setSpeed(ucLocation.getSpeed());
            ucLocation2.setLatitude((double) ((int) (latitude * 360000.0d)));
            ucLocation2.setLongitude((double) ((int) (longitude * 360000.0d)));
            j a = j.a();
            com.ucpro.model.a.a("0ccac052b04067871c7d107b8c0d8854", String.valueOf(ucLocation2.getLatitude()));
            com.ucpro.model.a.a("4cedc8ccd5b2f5668f7b648d39d273bf", String.valueOf(ucLocation2.getLongitude()));
            com.ucpro.model.a.a("c3e0cecf7555c78b91e14f155970ad09", j.a(ucLocation2.a));
            com.ucpro.model.a.a("a529b24200b3b4be836a663b483b3d80", j.a(ucLocation2.b));
            com.ucpro.model.a.a("e525c34fa4184d5629f854c866407dc8", j.a(ucLocation2.c));
            com.ucpro.model.a.a("f845992cd24312dfe772f52173aba9bf", j.a(ucLocation2.d));
            a.a = ucLocation2;
        }
    }
}
