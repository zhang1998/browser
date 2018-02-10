package android.mini.support.v4.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class b<T> implements Creator<T> {
    final d<T> a;

    public b(d<T> dVar) {
        this.a = dVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public final T[] newArray(int i) {
        return this.a.a(i);
    }
}
