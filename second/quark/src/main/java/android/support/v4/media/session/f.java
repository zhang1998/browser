package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class f implements Creator<ParcelableVolumeInfo> {
    f() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelableVolumeInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ParcelableVolumeInfo(parcel);
    }
}
