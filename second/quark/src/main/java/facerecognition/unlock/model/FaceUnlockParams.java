package facerecognition.unlock.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class FaceUnlockParams implements Parcelable {
    public static final Creator<FaceUnlockParams> CREATOR = new b();
    public int a;
    public int b;
    public int c;
    public float d;
    public float e;

    public FaceUnlockParams(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
    }

    public int describeContents() {
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
    }

    public String toString() {
        return "type = " + this.a + ", max_try = " + this.b + ", max_bad_try = " + this.c + ", threshold = " + this.d + ", alpha = " + this.e;
    }
}
