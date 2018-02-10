package com.amap.api.location;

import com.loc.cq;

/* compiled from: ProGuard */
public class AMapLocationClientOption implements Cloneable {
    static String a = "";
    private long b = 2000;
    private long c = ((long) cq.e);
    private boolean d = false;
    private boolean e = false;
    private boolean f = true;
    private boolean g = true;
    private AMapLocationMode h = AMapLocationMode.Hight_Accuracy;
    private boolean i = false;
    private boolean j = false;
    private boolean k = true;
    private boolean l = true;
    private boolean m = false;

    /* compiled from: ProGuard */
    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    private AMapLocationClientOption a(AMapLocationClientOption aMapLocationClientOption) {
        this.b = aMapLocationClientOption.b;
        this.d = aMapLocationClientOption.d;
        this.h = aMapLocationClientOption.h;
        this.e = aMapLocationClientOption.e;
        this.i = aMapLocationClientOption.i;
        this.j = aMapLocationClientOption.j;
        this.f = aMapLocationClientOption.f;
        this.g = aMapLocationClientOption.g;
        this.c = aMapLocationClientOption.c;
        this.k = aMapLocationClientOption.k;
        this.l = aMapLocationClientOption.l;
        this.m = aMapLocationClientOption.m;
        return this;
    }

    public static String getAPIKEY() {
        return a;
    }

    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
        }
        return new AMapLocationClientOption().a(this);
    }

    public long getHttpTimeOut() {
        return this.c;
    }

    public long getInterval() {
        return this.b;
    }

    public AMapLocationMode getLocationMode() {
        return this.h;
    }

    public boolean isGpsFirst() {
        return this.j;
    }

    public boolean isKillProcess() {
        return this.i;
    }

    public boolean isLocationCacheEnable() {
        return this.l;
    }

    public boolean isMockEnable() {
        return this.e;
    }

    public boolean isNeedAddress() {
        return this.f;
    }

    public boolean isOffset() {
        return this.k;
    }

    public boolean isOnceLocation() {
        return this.m ? true : this.d;
    }

    public boolean isOnceLocationLatest() {
        return this.m;
    }

    public boolean isWifiActiveScan() {
        return this.g;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.j = z;
        return this;
    }

    public void setHttpTimeOut(long j) {
        this.c = j;
    }

    public AMapLocationClientOption setInterval(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.b = j;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.i = z;
        return this;
    }

    public void setLocationCacheEnable(boolean z) {
        this.l = z;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.h = aMapLocationMode;
        return this;
    }

    public void setMockEnable(boolean z) {
        this.e = z;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f = z;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.k = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.d = z;
        return this;
    }

    public void setOnceLocationLatest(boolean z) {
        this.m = z;
    }

    public void setWifiActiveScan(boolean z) {
        this.g = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("interval:").append(String.valueOf(this.b)).append("#");
        stringBuilder.append("isOnceLocation:").append(String.valueOf(this.d)).append("#");
        stringBuilder.append("locationMode:").append(String.valueOf(this.h)).append("#");
        stringBuilder.append("isMockEnable:").append(String.valueOf(this.e)).append("#");
        stringBuilder.append("isKillProcess:").append(String.valueOf(this.i)).append("#");
        stringBuilder.append("isGpsFirst:").append(String.valueOf(this.j)).append("#");
        stringBuilder.append("isNeedAddress:").append(String.valueOf(this.f)).append("#");
        stringBuilder.append("isWifiActiveScan:").append(String.valueOf(this.g)).append("#");
        stringBuilder.append("httpTimeOut:").append(String.valueOf(this.c)).append("#");
        stringBuilder.append("isOffset:").append(String.valueOf(this.k)).append("#");
        stringBuilder.append("isLocationCacheEnable:").append(String.valueOf(this.l));
        return stringBuilder.toString();
    }
}
