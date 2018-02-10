package com.loc;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.CoordinateConverter.CoordType;
import com.amap.api.location.DPoint;

/* compiled from: ProGuard */
final class dp implements LocationListener {
    final /* synthetic */ dq a;

    dp(dq dqVar) {
        this.a = dqVar;
    }

    public final void onLocationChanged(Location location) {
        if (location != null) {
            try {
                Bundle extras = location.getExtras();
                int i = extras != null ? extras.getInt("satellites") : 0;
                if (i > 0 || this.a.d.isMockEnable()) {
                    long b = dm.b();
                    this.a.e.b = b;
                    if (b - this.a.j >= this.a.g) {
                        AMapLocation aMapLocation;
                        if (cq.a(location.getLatitude(), location.getLongitude()) && this.a.d.isOffset()) {
                            aMapLocation = new AMapLocation(location);
                            aMapLocation.setLocationType(1);
                            DPoint convert = this.a.f.coord(new DPoint(location.getLatitude(), location.getLongitude())).from(CoordType.GPS).convert();
                            aMapLocation.setLatitude(convert.getLatitude());
                            aMapLocation.setLongitude(convert.getLongitude());
                        } else {
                            aMapLocation = new AMapLocation(location);
                            aMapLocation.setLatitude(location.getLatitude());
                            aMapLocation.setLongitude(location.getLongitude());
                            aMapLocation.setLocationType(1);
                        }
                        aMapLocation.setSatellites(i);
                        Message message = new Message();
                        message.obj = aMapLocation;
                        message.what = 2;
                        if (this.a.a != null) {
                            this.a.a.sendMessage(message);
                        }
                        if (!cq.o) {
                            cq.o = true;
                            dl.a(this.a.b, "pref", "colde", true);
                        }
                        this.a.j = dm.b();
                    } else if (this.a.a != null) {
                        this.a.a.sendEmptyMessage(5);
                    }
                    if (this.a.h != 0 && !this.a.i) {
                        di.b(this.a.b, this.a.e);
                        this.a.i = true;
                    }
                }
            } catch (Throwable th) {
                cq.a(th, "GPSLocation", "onLocationChanged");
            }
        }
    }

    public final void onProviderDisabled(String str) {
        try {
            if ("gps".equals(str) && this.a.a != null) {
                this.a.a.sendEmptyMessage(3);
            }
        } catch (Throwable th) {
            cq.a(th, "GPSLocation", "onProviderDisabled");
        }
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0 || i == 1) {
            try {
                if (this.a.a != null) {
                    this.a.a.sendEmptyMessage(3);
                }
            } catch (Throwable th) {
                cq.a(th, "GPSLocation", "onStatusChanged");
            }
        }
    }
}
