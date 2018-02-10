package com.uc.quark.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.UCMobile.Apollo.ApolloMetaData;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: ProGuard */
public class FileDownloadTaskList implements Parcelable {
    public static final Creator<FileDownloadTaskList> CREATOR = new e();
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public String i;
    public FileDownloadHeader j;
    public HashMap<String, Serializable> k = new HashMap();

    public FileDownloadTaskList(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, FileDownloadHeader fileDownloadHeader) {
        this.a = str;
        this.b = str2;
        this.c = false;
        this.d = z;
        this.e = z2;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.j = fileDownloadHeader;
        if (this.j != null) {
            this.i = this.j.toString();
        }
        this.k.put("url", this.a);
        this.k.put("path", this.b);
        this.k.put("path_as_directory", Boolean.valueOf(this.c));
        this.k.put("force_re_download", Boolean.valueOf(this.d));
        this.k.put("is_wifi_request", Boolean.valueOf(this.e));
        this.k.put("progress_times", Integer.valueOf(this.f));
        this.k.put("progress_times_min", Integer.valueOf(this.g));
        this.k.put("auto_retry_times", Integer.valueOf(this.h));
        this.k.put(ApolloMetaData.KEY_HEADER, this.i);
    }

    protected FileDownloadTaskList(Parcel parcel) {
        this.k = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.k);
    }
}
