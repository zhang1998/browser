package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class ce implements Creator<BackStackState> {
    ce() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BackStackState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BackStackState(parcel);
    }
}
