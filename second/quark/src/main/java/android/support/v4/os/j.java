package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class j<T> implements Creator<T> {
    final b<T> a;

    public j(b<T> bVar) {
        this.a = bVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public final T[] newArray(int i) {
        return this.a.a(i);
    }
}
