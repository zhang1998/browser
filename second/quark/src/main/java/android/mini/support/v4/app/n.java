package android.mini.support.v4.app;

import android.mini.support.v4.app.Fragment.SavedState;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class n implements Creator<SavedState> {
    n() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }
}
