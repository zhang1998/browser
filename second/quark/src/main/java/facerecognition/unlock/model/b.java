package facerecognition.unlock.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class b implements Creator<FaceUnlockParams> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FaceUnlockParams[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FaceUnlockParams(parcel);
    }
}
