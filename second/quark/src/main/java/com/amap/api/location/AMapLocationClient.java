package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.loc.ac;
import com.loc.cq;
import com.loc.dj;
import com.loc.ep;
import com.loc.j;

/* compiled from: ProGuard */
public class AMapLocationClient {
    Context a;
    LocationManagerBase b;

    public AMapLocationClient(Context context) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                cq.a(th, "AMapLocationClient", "AMapLocationClient 1");
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.b = a(this.a, null);
    }

    public AMapLocationClient(Context context, Intent intent) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                cq.a(th, "AMapLocationClient", "AMapLocationClient 2");
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.b = a(this.a, intent);
    }

    private LocationManagerBase a(Context context, Intent intent) {
        LocationManagerBase locationManagerBase;
        try {
            ep a = cq.a("loc", "2.8.0");
            dj.a(context, a);
            boolean c = dj.c(context);
            dj.a(context);
            if (c) {
                locationManagerBase = (LocationManagerBase) ac.a(context, a, "com.amap.api.location.LocationManagerWrapper", j.class, new Class[]{Context.class, Intent.class}, new Object[]{context, intent});
            } else {
                locationManagerBase = new j(context, intent);
            }
        } catch (Throwable th) {
            locationManagerBase = new j(context, intent);
        }
        return locationManagerBase == null ? new j(context, intent) : locationManagerBase;
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.a = str;
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "setApiKey");
        }
    }

    public void addGeoFenceAlert(String str, double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            this.b.addGeoFenceAlert(str, d, d2, f, j, pendingIntent);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "addGeoFenceAlert");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            if (this.b != null) {
                return this.b.getLastKnownLocation();
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "getLastKnownLocation");
        }
        return null;
    }

    public String getVersion() {
        return "2.8.0";
    }

    public boolean isStarted() {
        try {
            if (this.b != null) {
                return this.b.isStarted();
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "isStarted");
        }
        return false;
    }

    public void onDestroy() {
        try {
            this.b.onDestroy();
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "onDestroy");
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            this.b.removeGeoFenceAlert(pendingIntent);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "removeGeoFenceAlert 2");
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent, String str) {
        try {
            this.b.removeGeoFenceAlert(pendingIntent, str);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "removeGeoFenceAlert 1");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                cq.a(th, "AMapLocationClient", "setLocationListener");
                return;
            }
        }
        this.b.setLocationListener(aMapLocationListener);
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            try {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            } catch (Throwable th) {
                cq.a(th, "AMapLocationClient", "setLocationOption");
                return;
            }
        }
        this.b.setLocationOption(aMapLocationClientOption);
    }

    public void startAssistantLocation() {
        try {
            this.b.startAssistantLocation();
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "startAssistantLocation");
        }
    }

    public void startLocation() {
        try {
            this.b.startLocation();
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            this.b.startAssistantLocation();
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            this.b.stopLocation();
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            this.b.unRegisterLocationListener(aMapLocationListener);
        } catch (Throwable th) {
            cq.a(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }
}
