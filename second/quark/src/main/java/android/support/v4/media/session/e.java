package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat.CustomAction;

/* compiled from: ProGuard */
final class e implements Creator<CustomAction> {
    e() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CustomAction[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CustomAction(parcel);
    }
}
