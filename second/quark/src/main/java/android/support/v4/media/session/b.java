package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;

/* compiled from: ProGuard */
final class b implements Creator<QueueItem> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new QueueItem[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new QueueItem(parcel);
    }
}
