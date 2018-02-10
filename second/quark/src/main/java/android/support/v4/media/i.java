package android.support.v4.media;

import android.media.MediaDescription;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class i implements Creator<MediaDescriptionCompat> {
    i() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaDescriptionCompat[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        if (VERSION.SDK_INT < 21) {
            return new MediaDescriptionCompat(parcel);
        }
        return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
    }
}
