package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class v implements Creator<RatingCompat> {
    v() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RatingCompat[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }
}
