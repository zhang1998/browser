package android.mini.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class bn implements Creator<FullSpanItem> {
    bn() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FullSpanItem[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FullSpanItem(parcel);
    }
}
