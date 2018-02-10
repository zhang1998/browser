package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class d implements Creator<PlaybackStateCompat> {
    d() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PlaybackStateCompat[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat(parcel);
    }
}
