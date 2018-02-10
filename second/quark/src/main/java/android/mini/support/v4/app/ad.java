package android.mini.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class ad implements Creator<FragmentManagerState> {
    ad() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FragmentManagerState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }
}
