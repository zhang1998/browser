package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaBrowserCompat.MediaItem;

/* compiled from: ProGuard */
final class g implements Creator<MediaItem> {
    g() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaItem[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MediaItem(parcel);
    }
}
