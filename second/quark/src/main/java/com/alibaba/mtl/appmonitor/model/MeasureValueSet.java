package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.e.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class MeasureValueSet implements Parcelable, a {
    public static final Creator<MeasureValueSet> CREATOR = new d();
    public Map<String, MeasureValue> a = new LinkedHashMap();

    public final MeasureValueSet a(String str, double d) {
        this.a.put(str, b.a().a(MeasureValue.class, Double.valueOf(d)));
        return this;
    }

    public final void a(String str, MeasureValue measureValue) {
        this.a.put(str, measureValue);
    }

    public final MeasureValue a(String str) {
        return (MeasureValue) this.a.get(str);
    }

    public final void a() {
        for (a a : this.a.values()) {
            b.a().a(a);
        }
        this.a.clear();
    }

    public final void a(Object... objArr) {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.a);
    }

    static MeasureValueSet a(Parcel parcel) {
        try {
            MeasureValueSet measureValueSet = (MeasureValueSet) b.a().a(MeasureValueSet.class, new Object[0]);
            try {
                measureValueSet.a = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
                return measureValueSet;
            } catch (Throwable th) {
                return measureValueSet;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public final void a(List<Measure> list) {
        if (list != null) {
            for (String str : this.a.keySet()) {
                MeasureValue measureValue = (MeasureValue) this.a.get(str);
                for (Measure measure : list) {
                    if (str.equalsIgnoreCase(measure.a)) {
                        break;
                    }
                }
                Measure measure2 = null;
                measureValue.a(measure2);
            }
        }
    }
}
