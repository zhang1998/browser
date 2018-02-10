package com.uc.quark.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.uc.quark.filedownloader.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class FileDownloadHeader implements Parcelable {
    public static final Creator<FileDownloadHeader> CREATOR = new c();
    public HashMap<String, List<String>> a;

    public final void a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else if (str2 == null) {
            throw new NullPointerException("value == null");
        } else {
            if (this.a == null) {
                this.a = new HashMap();
            }
            List list = (List) this.a.get(str);
            if (list == null) {
                list = new ArrayList();
                this.a.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.a);
    }

    public FileDownloadHeader(String str) {
        String[] f = b.f(str);
        for (int i = 0; i < f.length; i += 2) {
            a(f[i], f[i + 1]);
        }
    }

    protected FileDownloadHeader(Parcel parcel) {
        this.a = parcel.readHashMap(String.class.getClassLoader());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : this.a.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list != null) {
                stringBuilder.append(str).append(": ").append((String) list.get(0)).append("\n");
            }
        }
        return new String(stringBuilder);
    }
}
