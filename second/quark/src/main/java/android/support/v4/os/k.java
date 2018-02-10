package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class k implements Creator<ResultReceiver> {
    k() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ResultReceiver[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ResultReceiver(parcel);
    }
}
