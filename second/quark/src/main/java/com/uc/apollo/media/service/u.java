package com.uc.apollo.media.service;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.uc.apollo.media.impl.DataSource;
import com.uc.apollo.media.impl.DataSourceFD;
import com.uc.apollo.media.impl.DataSourceURI;
import java.io.IOException;

/* compiled from: ProGuard */
public final class u implements Parcelable {
    public static final Creator<u> a = new v();
    private DataSource b;

    /* compiled from: ProGuard */
    final class a extends DataSourceFD {
        ParcelFileDescriptor a;

        a(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
            this.fd = parcelFileDescriptor.getFileDescriptor();
        }

        public final void reset() {
            super.reset();
            if (this.a != null) {
                try {
                    this.a.close();
                } catch (IOException e) {
                }
                this.a = null;
            }
        }
    }

    public u(DataSource dataSource) {
        this.b = dataSource;
    }

    public final DataSource a() {
        return this.b;
    }

    public final String toString() {
        return this.b.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public static DataSource a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            DataSourceURI dataSourceURI = new DataSourceURI();
            dataSourceURI.title = parcel.readString();
            dataSourceURI.pageUri = parcel.readString();
            dataSourceURI.uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
            dataSourceURI.headers = parcel.readHashMap(null);
            return dataSourceURI;
        } else if (readInt != 1) {
            return null;
        } else {
            DataSource aVar = new a(parcel.readFileDescriptor());
            aVar.offset = parcel.readLong();
            aVar.length = parcel.readLong();
            return aVar;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        DataSource dataSource = this.b;
        if (dataSource instanceof DataSourceURI) {
            parcel.writeInt(0);
            DataSourceURI dataSourceURI = (DataSourceURI) dataSource;
            parcel.writeString(dataSourceURI.title);
            parcel.writeString(dataSourceURI.pageUri);
            dataSourceURI.uri.writeToParcel(parcel, i);
            parcel.writeMap(dataSourceURI.headers);
        } else if (dataSource instanceof DataSourceFD) {
            parcel.writeInt(1);
            DataSourceFD dataSourceFD = (DataSourceFD) dataSource;
            parcel.writeFileDescriptor(dataSourceFD.fd);
            parcel.writeLong(dataSourceFD.offset);
            parcel.writeLong(dataSourceFD.length);
        } else {
            parcel.writeInt(-1);
        }
    }
}
