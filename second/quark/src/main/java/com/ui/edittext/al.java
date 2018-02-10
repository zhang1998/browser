package com.ui.edittext;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ui.edittext.TextView.SavedState;

/* compiled from: ProGuard */
final class al implements Creator<SavedState> {
    al() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }
}
