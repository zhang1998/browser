package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.analytics.a.af;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class DimensionSet implements Parcelable {
    public static final Creator<DimensionSet> CREATOR = new h();
    public List<Dimension> a = new ArrayList(3);

    private DimensionSet() {
    }

    public final void a(DimensionValueSet dimensionValueSet) {
        if (this.a != null && dimensionValueSet != null) {
            for (Dimension dimension : this.a) {
                if (dimension.b() != null) {
                    if (((String) dimensionValueSet.a.get(dimension.a())) == null) {
                        dimensionValueSet.a(dimension.a(), dimension.b());
                    }
                }
            }
        }
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
                    Dimension[] dimensionArr = new Dimension[toArray.length];
                    for (int i2 = 0; i2 < toArray.length; i2++) {
                        dimensionArr[i2] = (Dimension) toArray[i2];
                    }
                    parcelableArr = dimensionArr;
                }
                parcel.writeParcelableArray(parcelableArr, i);
            } catch (Exception e) {
            }
        }
    }

    static DimensionSet a(Parcel parcel) {
        DimensionSet dimensionSet = new DimensionSet();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(DimensionSet.class.getClassLoader());
            if (readParcelableArray != null) {
                if (dimensionSet.a == null) {
                    dimensionSet.a = new ArrayList();
                }
                int i = 0;
                while (i < readParcelableArray.length) {
                    if (readParcelableArray[i] == null || !(readParcelableArray[i] instanceof Dimension)) {
                        af.a("DimensionSet", "parcelables[i]:", readParcelableArray[i]);
                    } else {
                        dimensionSet.a.add((Dimension) readParcelableArray[i]);
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            af.c("DimensionSet", "[readFromParcel]", th);
        }
        return dimensionSet;
    }
}
