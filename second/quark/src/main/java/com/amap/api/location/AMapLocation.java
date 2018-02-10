package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.loc.cq;
import com.loc.dm;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AMapLocation extends Location {
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private boolean l = true;
    private int m = 0;
    private String n = "success";
    private String o = "";
    private int p = 0;
    private double q = 0.0d;
    private double r = 0.0d;
    private int s = 0;
    private String t = "";

    public AMapLocation(Location location) {
        super(location);
        this.q = location.getLatitude();
        this.r = location.getLongitude();
    }

    public AMapLocation(String str) {
        super(str);
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.e;
    }

    public String getAddress() {
        return this.f;
    }

    public double getAltitude() {
        return super.getAltitude();
    }

    public String getAoiName() {
        return this.t;
    }

    public float getBearing() {
        return super.getBearing();
    }

    public String getCity() {
        return this.b;
    }

    public String getCityCode() {
        return this.d;
    }

    public String getCountry() {
        return this.h;
    }

    public String getDistrict() {
        return this.c;
    }

    public int getErrorCode() {
        return this.m;
    }

    public String getErrorInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.n);
        if (this.m != 0) {
            stringBuilder.append(" 请到http://lbs.amap.com/api/android-location-sdk/abouterrorcode/查看错误码说明.");
        }
        this.n = stringBuilder.toString();
        return this.n;
    }

    public double getLatitude() {
        return this.q;
    }

    public String getLocationDetail() {
        return this.o;
    }

    public int getLocationType() {
        return this.p;
    }

    public double getLongitude() {
        return this.r;
    }

    public String getPoiName() {
        return this.g;
    }

    public String getProvider() {
        return super.getProvider();
    }

    public String getProvince() {
        return this.a;
    }

    public String getRoad() {
        return this.i;
    }

    public int getSatellites() {
        return this.s;
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    public String getStreet() {
        return this.j;
    }

    public String getStreetNum() {
        return this.k;
    }

    public boolean isOffset() {
        return this.l;
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public void setAddress(String str) {
        this.f = str;
    }

    public void setAoiName(String str) {
        this.t = str;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public void setCountry(String str) {
        this.h = str;
    }

    public void setDistrict(String str) {
        this.c = str;
    }

    public void setErrorCode(int i) {
        if (this.m == 0) {
            this.n = dm.c(i);
            this.m = i;
        }
    }

    public void setErrorInfo(String str) {
        this.n = str;
    }

    public void setLatitude(double d) {
        this.q = d;
    }

    public void setLocationDetail(String str) {
        this.o = str;
    }

    public void setLocationType(int i) {
        this.p = i;
    }

    public void setLongitude(double d) {
        this.r = d;
    }

    public void setNumber(String str) {
        this.k = str;
    }

    public void setOffset(boolean z) {
        this.l = z;
    }

    public void setPoiName(String str) {
        this.g = str;
    }

    public void setProvince(String str) {
        this.a = str;
    }

    public void setRoad(String str) {
        this.i = str;
    }

    public void setSatellites(int i) {
        this.s = i;
    }

    public void setStreet(String str) {
        this.j = str;
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
            switch (i) {
                case 1:
                    jSONObject.put("country", this.h);
                    jSONObject.put("province", this.a);
                    jSONObject.put("city", this.b);
                    jSONObject.put("cityCode", this.d);
                    jSONObject.put("district", this.c);
                    jSONObject.put("adCode", this.e);
                    jSONObject.put("address", this.f);
                    jSONObject.put("road", this.i);
                    jSONObject.put("street", this.j);
                    jSONObject.put("number", this.k);
                    jSONObject.put("poiName", this.g);
                    jSONObject.put(INoCaptchaComponent.errorCode, this.m);
                    jSONObject.put("errorInfo", this.n);
                    jSONObject.put("locationDetail", this.o);
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("bearing", (double) getBearing());
                    jSONObject.put("speed", (double) getSpeed());
                    jSONObject.put("satellites", this.s);
                    jSONObject.put("aoiName", this.t);
                    Bundle extras = getExtras();
                    if (extras != null && extras.containsKey("desc")) {
                        jSONObject.put("desc", extras.getString("desc"));
                    }
                case 2:
                    jSONObject.put("time", getTime());
                    break;
                case 3:
                    break;
            }
        } catch (Throwable th) {
            cq.a(th, "AMapLocation", "toStr part2");
            jSONObject2 = null;
        }
        jSONObject.put("locationType", this.p);
        jSONObject.put("accuracy", (double) getAccuracy());
        jSONObject.put("latitude", getLatitude());
        jSONObject.put("longitude", getLongitude());
        jSONObject.put("provider", getProvider());
        jSONObject2 = jSONObject;
        return jSONObject2 == null ? null : jSONObject2.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.q);
            stringBuffer.append("longitude=" + this.r);
            stringBuffer.append("province=" + this.a + "#");
            stringBuffer.append("city=" + this.b + "#");
            stringBuffer.append("district=" + this.c + "#");
            stringBuffer.append("cityCode=" + this.d + "#");
            stringBuffer.append("adCode=" + this.e + "#");
            stringBuffer.append("address=" + this.f + "#");
            stringBuffer.append("country=" + this.h + "#");
            stringBuffer.append("road=" + this.i + "#");
            stringBuffer.append("poiName=" + this.g + "#");
            stringBuffer.append("street=" + this.j + "#");
            stringBuffer.append("streetNum=" + this.k + "#");
            stringBuffer.append("aoiName=" + this.t + "#");
            stringBuffer.append("errorCode=" + this.m + "#");
            stringBuffer.append("errorInfo=" + this.n + "#");
            stringBuffer.append("locationDetail=" + this.o + "#");
            stringBuffer.append("locationType=" + this.p);
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }
}
