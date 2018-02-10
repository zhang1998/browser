package com.uc.quark.p2p.service.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.uc.quark.p2p.service.message.MessageSnapshot;

/* compiled from: ProGuard */
final class a implements c {
    private IBinder a;

    a(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final void a(MessageSnapshot messageSnapshot) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCCallback");
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
