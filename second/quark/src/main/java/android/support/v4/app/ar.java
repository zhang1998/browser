package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class ar implements Creator<FragmentState> {
    ar() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FragmentState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FragmentState(parcel);
    }
}
