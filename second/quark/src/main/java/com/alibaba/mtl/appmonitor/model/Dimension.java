package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class Dimension implements Parcelable {
    public static final Creator<Dimension> CREATOR = new e();
    protected String a;
    protected String b = "null";

    private Dimension(String str, String str2) {
        this.a = str;
        if (str2 == null) {
            str2 = "null";
        }
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
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
        Dimension dimension = (Dimension) obj;
        if (this.a == null) {
            if (dimension.a != null) {
                return false;
            }
            return true;
        } else if (this.a.equals(dimension.a)) {
            return true;
        } else {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
    }

    static Dimension a(Parcel parcel) {
        try {
            return new Dimension(parcel.readString(), parcel.readString());
        } catch (Throwable th) {
            return null;
        }
    }
}
