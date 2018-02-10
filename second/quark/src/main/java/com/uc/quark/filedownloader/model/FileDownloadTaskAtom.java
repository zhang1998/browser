package com.uc.quark.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class FileDownloadTaskAtom implements Parcelable {
    public static final Creator<FileDownloadTaskAtom> CREATOR = new a();
    private String a;
    private String b;
    private long c;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
    }

    protected FileDownloadTaskAtom(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readLong();
    }
}
