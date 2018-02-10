package com.uc.quark.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class c implements Creator<FileDownloadHeader> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FileDownloadHeader[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FileDownloadHeader(parcel);
    }
}
