package com.uc.quark.filedownloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.uc.quark.filedownloader.message.MessageSnapshot;

/* compiled from: ProGuard */
public abstract class f extends Binder implements c {
    public f() {
        attachInterface(this, "com.uc.quark.filedownloader.i.IFileDownloadIPCCallback");
    }

    public static c a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
            return new d(iBinder);
        }
        return (c) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                MessageSnapshot messageSnapshot;
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCCallback");
                if (parcel.readInt() != 0) {
                    messageSnapshot = (MessageSnapshot) MessageSnapshot.CREATOR.createFromParcel(parcel);
                } else {
                    messageSnapshot = null;
                }
                a(messageSnapshot);
                return true;
            case 1598968902:
                parcel2.writeString("com.uc.quark.filedownloader.i.IFileDownloadIPCCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
