package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.e.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class DimensionValueSet implements Parcelable, a {
    public static final Creator<DimensionValueSet> CREATOR = new f();
    public Map<String, String> a;

    public static DimensionValueSet c() {
        return (DimensionValueSet) b.a().a(DimensionValueSet.class, new Object[0]);
    }

    @Deprecated
    public DimensionValueSet() {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
    }

    public final DimensionValueSet a(String str, String str2) {
        Map map = this.a;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }

    public final DimensionValueSet a(DimensionValueSet dimensionValueSet) {
        if (dimensionValueSet != null) {
            Map map = dimensionValueSet.a;
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    this.a.put(entry.getKey(), entry.getValue() != null ? (String) entry.getValue() : "null");
                }
            }
        }
        return this;
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
        DimensionValueSet dimensionValueSet = (DimensionValueSet) obj;
        if (this.a == null) {
            if (dimensionValueSet.a != null) {
                return false;
            }
            return true;
        } else if (this.a.equals(dimensionValueSet.a)) {
            return true;
        } else {
            return false;
        }
    }

    public void a() {
        this.a.clear();
    }

    public void a(Object... objArr) {
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

    static DimensionValueSet a(Parcel parcel) {
        DimensionValueSet dimensionValueSet = null;
        try {
            dimensionValueSet = c();
            dimensionValueSet.a = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
            return dimensionValueSet;
        } catch (Throwable th) {
            return dimensionValueSet;
        }
    }
}
