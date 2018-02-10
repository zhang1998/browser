package com.uc.quark.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class e implements Creator<FileDownloadTaskList> {
    e() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FileDownloadTaskList[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FileDownloadTaskList(parcel);
    }
}
