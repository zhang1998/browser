package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class e implements Creator<MediaMetadataCompat> {
    e() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaMetadataCompat[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MediaMetadataCompat(parcel);
    }
}
