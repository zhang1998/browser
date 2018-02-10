package com.autonavi.aps.amapapi.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.loc.cq;
import com.loc.dm;
import com.uc.apollo.impl.SettingsConst;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* compiled from: ProGuard */
public class AmapLoc implements Parcelable {
    public static final Creator<AmapLoc> CREATOR = new a();
    public String A = "";
    public boolean B = true;
    public boolean C = true;
    public long D = 0;
    public JSONObject E = null;
    private double F = 0.0d;
    private float G = 0.0f;
    private float H = 0.0f;
    private String I = null;
    private String J = "";
    public String a = "";
    public double b = 0.0d;
    public double c = 0.0d;
    public float d = 0.0f;
    public long e = 0;
    public String f = "new";
    public int g = 0;
    public String h = "success";
    public int i = 0;
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public int x = -1;
    public String y = "";
    public String z = "";

    public AmapLoc(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.f = parcel.readString();
        this.h = parcel.readString();
        this.g = parcel.readInt();
        this.H = parcel.readFloat();
        this.G = parcel.readFloat();
        this.d = parcel.readFloat();
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
        this.F = parcel.readDouble();
        this.e = parcel.readLong();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.I = parcel.readString();
        this.w = parcel.readString();
        this.J = parcel.readString();
        this.y = parcel.readString();
        this.j = parcel.readString();
        this.x = parcel.readInt();
        this.i = parcel.readInt();
        this.z = parcel.readString();
        this.B = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.C = z;
        this.A = parcel.readString();
        this.D = parcel.readLong();
    }

    public AmapLoc(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (dm.a(jSONObject, "provider")) {
                    this.a = jSONObject.getString("provider");
                }
                if (dm.a(jSONObject, "lon")) {
                    a(jSONObject.getDouble("lon"));
                }
                if (dm.a(jSONObject, "lat")) {
                    b(jSONObject.getDouble("lat"));
                }
                if (dm.a(jSONObject, "altitude")) {
                    this.F = jSONObject.getDouble("altitude");
                }
                if (dm.a(jSONObject, "acc")) {
                    d(jSONObject.getString("acc"));
                }
                if (dm.a(jSONObject, "accuracy")) {
                    a((float) jSONObject.getLong("accuracy"));
                }
                if (dm.a(jSONObject, "speed")) {
                    this.G = (float) jSONObject.getLong("speed");
                }
                if (dm.a(jSONObject, "dir")) {
                    this.H = (float) jSONObject.getLong("dir");
                }
                if (dm.a(jSONObject, "bearing")) {
                    this.H = (float) jSONObject.getLong("bearing");
                }
                if (dm.a(jSONObject, "type")) {
                    this.f = jSONObject.getString("type");
                }
                if (dm.a(jSONObject, "retype")) {
                    this.k = jSONObject.getString("retype");
                }
                if (dm.a(jSONObject, "citycode")) {
                    this.m = jSONObject.getString("citycode");
                }
                if (dm.a(jSONObject, "desc")) {
                    this.n = jSONObject.getString("desc");
                }
                if (dm.a(jSONObject, "adcode")) {
                    this.o = jSONObject.getString("adcode");
                }
                if (dm.a(jSONObject, "country")) {
                    this.p = jSONObject.getString("country");
                }
                if (dm.a(jSONObject, "province")) {
                    this.q = jSONObject.getString("province");
                }
                if (dm.a(jSONObject, "city")) {
                    this.r = jSONObject.getString("city");
                }
                if (dm.a(jSONObject, "road")) {
                    this.t = jSONObject.getString("road");
                }
                if (dm.a(jSONObject, "street")) {
                    this.u = jSONObject.getString("street");
                }
                if (dm.a(jSONObject, "number")) {
                    this.z = jSONObject.getString("number");
                }
                if (dm.a(jSONObject, "poiname")) {
                    this.v = jSONObject.getString("poiname");
                }
                if (dm.a(jSONObject, "aoiname")) {
                    this.A = jSONObject.getString("aoiname");
                }
                if (dm.a(jSONObject, INoCaptchaComponent.errorCode)) {
                    a(jSONObject.getInt(INoCaptchaComponent.errorCode));
                }
                if (dm.a(jSONObject, "errorInfo")) {
                    this.h = jSONObject.getString("errorInfo");
                }
                if (dm.a(jSONObject, "locationType")) {
                    this.i = jSONObject.getInt("locationType");
                }
                if (dm.a(jSONObject, "locationDetail")) {
                    a(jSONObject.getString("locationDetail"));
                }
                if (dm.a(jSONObject, "cens")) {
                    e(jSONObject.getString("cens"));
                }
                if (dm.a(jSONObject, "poiid")) {
                    this.w = jSONObject.getString("poiid");
                }
                if (dm.a(jSONObject, "pid")) {
                    this.w = jSONObject.getString("pid");
                }
                if (dm.a(jSONObject, "floor")) {
                    b(jSONObject.getString("floor"));
                }
                if (dm.a(jSONObject, "flr")) {
                    b(jSONObject.getString("flr"));
                }
                if (dm.a(jSONObject, "coord")) {
                    c(jSONObject.getString("coord"));
                }
                if (dm.a(jSONObject, "mcell")) {
                    this.y = jSONObject.getString("mcell");
                }
                if (dm.a(jSONObject, "time")) {
                    this.e = jSONObject.getLong("time");
                }
                if (dm.a(jSONObject, "district")) {
                    this.s = jSONObject.getString("district");
                }
                if (dm.a(jSONObject, "isOffset")) {
                    this.B = jSONObject.getBoolean("isOffset");
                }
                if (dm.a(jSONObject, "isReversegeo")) {
                    this.C = jSONObject.getBoolean("isReversegeo");
                }
            } catch (Throwable th) {
                cq.a(th, "AmapLoc", "AmapLoc");
            }
        }
    }

    private void d(String str) {
        this.d = Float.parseFloat(str);
    }

    private void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (Object obj : str.split("\\*")) {
                if (!TextUtils.isEmpty(obj)) {
                    String[] split = obj.split(",");
                    a(Double.parseDouble(split[0]));
                    b(Double.parseDouble(split[1]));
                    a((float) Integer.parseInt(split[2]));
                    break;
                }
            }
            this.I = str;
        }
    }

    public final void a(double d) {
        this.b = dm.a(d);
    }

    public final void a(float f) {
        d(String.valueOf(Math.round(f)));
    }

    public final void a(int i) {
        if (this.g == 0) {
            this.h = dm.c(i);
            this.g = i;
        }
    }

    public final void a(String str) {
        if (this.j == null || this.j.length() == 0) {
            this.j = str;
        }
    }

    public final JSONObject b(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1:
                    jSONObject.put("altitude", this.F);
                    jSONObject.put("speed", (double) this.G);
                    jSONObject.put("bearing", (double) this.H);
                    jSONObject.put("retype", this.k);
                    jSONObject.put("citycode", this.m);
                    jSONObject.put("desc", this.n);
                    jSONObject.put("adcode", this.o);
                    jSONObject.put("country", this.p);
                    jSONObject.put("province", this.q);
                    jSONObject.put("city", this.r);
                    jSONObject.put("district", this.s);
                    jSONObject.put("road", this.t);
                    jSONObject.put("street", this.u);
                    jSONObject.put("number", this.z);
                    jSONObject.put("poiname", this.v);
                    jSONObject.put("cens", this.I);
                    jSONObject.put("poiid", this.w);
                    jSONObject.put("floor", this.J);
                    jSONObject.put("coord", this.x);
                    jSONObject.put("mcell", this.y);
                    jSONObject.put(INoCaptchaComponent.errorCode, this.g);
                    jSONObject.put("errorInfo", this.h);
                    jSONObject.put("locationType", this.i);
                    jSONObject.put("locationDetail", this.j);
                    jSONObject.put("aoiname", this.A);
                    if (this.E != null && dm.a(jSONObject, "offpct")) {
                        jSONObject.put("offpct", this.E.getString("offpct"));
                        break;
                    }
                case 2:
                    break;
                case 3:
                    break;
                default:
                    return jSONObject;
            }
            jSONObject.put("time", this.e);
            jSONObject.put("provider", this.a);
            jSONObject.put("lon", this.b);
            jSONObject.put("lat", this.c);
            jSONObject.put("accuracy", (double) this.d);
            jSONObject.put("type", this.f);
            jSONObject.put("isOffset", this.B);
            jSONObject.put("isReversegeo", this.C);
            return jSONObject;
        } catch (Throwable th) {
            cq.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public final void b(double d) {
        this.c = dm.a(d);
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                str = null;
                cq.a(th, "AmapLoc", "setFloor");
            }
        }
        this.J = str;
    }

    public final String c(int i) {
        JSONObject b = b(i);
        return b == null ? null : b.toString();
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.a.equals("gps")) {
                this.x = 0;
                return;
            } else if (str.equals(SettingsConst.FALSE)) {
                this.x = 0;
                return;
            } else if (str.equals(SettingsConst.TRUE)) {
                this.x = 1;
                return;
            }
        }
        this.x = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeString(this.a);
        parcel.writeString(this.f);
        parcel.writeString(this.h);
        parcel.writeInt(this.g);
        parcel.writeFloat(this.H);
        parcel.writeFloat(this.G);
        parcel.writeFloat(this.d);
        parcel.writeDouble(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.F);
        parcel.writeLong(this.e);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.I);
        parcel.writeString(this.w);
        parcel.writeString(this.J);
        parcel.writeString(this.y);
        parcel.writeString(this.j);
        parcel.writeInt(this.x);
        parcel.writeInt(this.i);
        parcel.writeString(this.z);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
        if (!this.C) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.A);
        parcel.writeLong(this.D);
    }
}
