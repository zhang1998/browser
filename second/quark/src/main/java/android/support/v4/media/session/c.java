package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class c implements Creator<ResultReceiverWrapper> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ResultReceiverWrapper[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ResultReceiverWrapper(parcel);
    }
}
