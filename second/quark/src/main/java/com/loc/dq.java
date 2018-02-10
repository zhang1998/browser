package com.loc;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.CoordinateConverter;

/* compiled from: ProGuard */
public final class dq {
    Handler a;
    Context b;
    LocationManager c;
    AMapLocationClientOption d;
    dh e = null;
    CoordinateConverter f = null;
    long g = 1000;
    long h = 0;
    boolean i = false;
    long j = 0;
    LocationListener k = new dp(this);

    public dq(Context context, h hVar) {
        this.b = context;
        this.f = new CoordinateConverter(this.b.getApplicationContext());
        this.a = hVar;
        this.c = (LocationManager) this.b.getSystemService("location");
        this.e = new dh();
    }
}
