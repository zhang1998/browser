package android.mini.support.v4.view;

import android.mini.support.v4.c.d;
import android.os.Parcel;

/* compiled from: ProGuard */
final class a implements d<AbsSavedState> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] a(int i) {
        return new AbsSavedState[i];
    }

    public final /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.a;
        }
        throw new IllegalStateException("superState must be null");
    }
}
