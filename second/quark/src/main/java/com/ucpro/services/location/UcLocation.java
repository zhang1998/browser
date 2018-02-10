package com.ucpro.services.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class UcLocation extends Location {
    public static final Creator<UcLocation> CREATOR = new d();
    String a;
    String b;
    String c;
    String d;
    String e;
    int f;
    String g;
    String h;
    String i;
    String j;
    boolean k = true;

    public UcLocation() {
        super("default");
    }

    public String toString() {
        return "latitude : " + getLatitude() + " longitude : " + getLongitude() + "\n province : " + this.b + " city : " + this.c + " district : " + this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.j);
        parcel.writeString(this.i);
        parcel.writeInt(this.k ? 1 : 0);
    }
}
