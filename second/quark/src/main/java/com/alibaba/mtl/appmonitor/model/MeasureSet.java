package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class MeasureSet implements Parcelable {
    public static final Creator<MeasureSet> CREATOR = new b();
    public List<Measure> a = new ArrayList(3);

    public static MeasureSet a() {
        return new MeasureSet();
    }

    private MeasureSet() {
    }

    public final boolean a(MeasureValueSet measureValueSet) {
        if (this.a != null) {
            if (measureValueSet == null) {
                return false;
            }
            for (int i = 0; i < this.a.size(); i++) {
                Measure measure = (Measure) this.a.get(i);
                if (measure != null) {
                    String str = measure.a;
                    if (!measureValueSet.a.containsKey(str)) {
                        return false;
                    }
                    boolean z;
                    Double valueOf = Double.valueOf(measureValueSet.a(str).c);
                    if (valueOf == null || ((measure.a() != null && valueOf.doubleValue() < measure.a().doubleValue()) || (measure.b() != null && valueOf.doubleValue() >= measure.b().doubleValue()))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.a != null) {
            try {
                Object[] toArray = this.a.toArray();
                Parcelable[] parcelableArr = null;
                if (toArray != null) {
                    Measure[] measureArr = new Measure[toArray.length];
                    for (int i2 = 0; i2 < toArray.length; i2++) {
                        measureArr[i2] = (Measure) toArray[i2];
                    }
                    parcelableArr = measureArr;
                }
                parcel.writeParcelableArray(parcelableArr, i);
            } catch (Exception e) {
            }
        }
    }

    static MeasureSet a(Parcel parcel) {
        MeasureSet measureSet = new MeasureSet();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(MeasureSet.class.getClassLoader());
            if (readParcelableArray != null) {
                List arrayList = new ArrayList(readParcelableArray.length);
                for (Parcelable parcelable : readParcelableArray) {
                    arrayList.add((Measure) parcelable);
                }
                measureSet.a = arrayList;
            }
        } catch (Throwable th) {
        }
        return measureSet;
    }
}
