package android.mini.support.v4.view;

import android.mini.support.v4.c.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = c.a(new a());
    public static final AbsSavedState a = new AbsSavedState() {
    };
    public final Parcelable b;

    private AbsSavedState() {
        this.b = null;
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == a) {
            parcelable = null;
        }
        this.b = parcelable;
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = a;
        }
        this.b = readParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
    }
}
