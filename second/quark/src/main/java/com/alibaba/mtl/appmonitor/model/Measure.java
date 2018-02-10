package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.analytics.a.af;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public class Measure implements Parcelable {
    public static final Creator<Measure> CREATOR = new c();
    private static List<Double> d;
    public String a;
    protected Double b;
    List<Double> c;

    Measure() {
        this.b = Double.valueOf(0.0d);
    }

    static {
        d = null;
        List arrayList = new ArrayList(1);
        d = arrayList;
        arrayList.add(null);
    }

    public Measure(String str, Double d, List<Double> list) {
        double d2 = 0.0d;
        this.b = Double.valueOf(0.0d);
        if (list != null) {
            if (list.removeAll(d)) {
                af.c("bounds entity must not be null", new Object[0]);
            }
            Collections.sort(list);
            this.c = list;
        }
        this.a = str;
        if (d != null) {
            d2 = d.doubleValue();
        }
        this.b = Double.valueOf(d2);
    }

    public Measure(String str, Double d, Double d2, Double d3) {
        this(str, d, null);
        if (d2 != null || d3 != null) {
            a(d2, d3);
        }
    }

    public final void a(Double d, Double d2) {
        if (d == null || d2 == null) {
            af.c("min or max must not be null", new Object[0]);
            return;
        }
        this.c = new ArrayList(2);
        this.c.add(d);
        this.c.add(d2);
    }

    public final Double a() {
        if (this.c == null || this.c.size() <= 0) {
            return null;
        }
        return (Double) this.c.get(0);
    }

    public final Double b() {
        if (this.c == null || this.c.size() < 2) {
            return null;
        }
        return (Double) this.c.get(this.c.size() - 1);
    }

    public final Double c() {
        return this.b;
    }

    public final void a(Double d) {
        this.b = d;
    }

    public int hashCode() {
        return (this.a == null ? 0 : this.a.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Measure measure = (Measure) obj;
        if (this.a == null) {
            if (measure.a != null) {
                return false;
            }
            return true;
        } else if (this.a.equals(measure.a)) {
            return true;
        } else {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeList(this.c);
            parcel.writeString(this.a);
            parcel.writeInt(this.b == null ? 0 : 1);
            if (this.b != null) {
                parcel.writeDouble(this.b.doubleValue());
            }
        } catch (Throwable th) {
            af.b("writeToParcel", th, new Object[0]);
        }
    }

    static Measure a(Parcel parcel) {
        try {
            Double valueOf;
            List readArrayList = parcel.readArrayList(Measure.class.getClassLoader());
            String readString = parcel.readString();
            if ((parcel.readInt() == 0 ? 1 : 0) == 0) {
                valueOf = Double.valueOf(parcel.readDouble());
            } else {
                valueOf = null;
            }
            return new Measure(readString, valueOf, readArrayList);
        } catch (Throwable th) {
            af.b("readFromParcel", th, new Object[0]);
            return null;
        }
    }
}
