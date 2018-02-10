package android.mini.support.v4.c;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: ProGuard */
final class e<T> implements ClassLoaderCreator<T> {
    private final d<T> a;

    public e(d<T> dVar) {
        this.a = dVar;
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
