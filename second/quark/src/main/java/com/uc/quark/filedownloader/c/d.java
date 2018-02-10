package com.uc.quark.filedownloader.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.uc.quark.filedownloader.message.MessageSnapshot;

/* compiled from: ProGuard */
final class d implements c {
    private IBinder a;

    d(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final void a(MessageSnapshot messageSnapshot) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.filedownloader.i.IFileDownloadIPCCallback");
            if (messageSnapshot != null) {
                obtain.writeInt(1);
                messageSnapshot.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
