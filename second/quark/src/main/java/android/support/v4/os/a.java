package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: ProGuard */
final class a<T> implements ClassLoaderCreator<T> {
    private final b<T> a;

    public a(b<T> bVar) {
        this.a = bVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }

    public final T[] newArray(int i) {
        return this.a.a(i);
    }
}
