package com.uc.quark.p2p.service.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.uc.quark.p2p.service.message.MessageSnapshot;

/* compiled from: ProGuard */
public abstract class b extends Binder implements c {
    public b() {
        attachInterface(this, "com.uc.quark.p2p.service.i.IP2pVideoPlayIPCCallback");
    }

    public static c a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
            return new a(iBinder);
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
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCCallback");
                if (parcel.readInt() != 0) {
                    messageSnapshot = (MessageSnapshot) MessageSnapshot.CREATOR.createFromParcel(parcel);
                } else {
                    messageSnapshot = null;
                }
                a(messageSnapshot);
                return true;
            case 1598968902:
                parcel2.writeString("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
