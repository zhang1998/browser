package com.uc.quark.p2p.service.a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ProGuard */
public abstract class e extends Binder implements f {
    public e() {
        attachInterface(this, "com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
    }

    public static f a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
            return new d(iBinder);
        }
        return (f) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z = false;
        long e;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                a(b.a(parcel.readStrongBinder()));
                return true;
            case 2:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                b(b.a(parcel.readStrongBinder()));
                return true;
            case 3:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                int i3;
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                boolean c = c(parcel.readString());
                parcel2.writeNoException();
                if (c) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                a();
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                d(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                e = e(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(e);
                return true;
            case 9:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                e = f(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(e);
                return true;
            case 10:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                byte g = g(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByte(g);
                return true;
            case 11:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                String h = h(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(h);
                return true;
            case 12:
                Notification notification;
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                } else {
                    notification = null;
                }
                a(readInt, notification);
                return true;
            case 13:
                parcel.enforceInterface("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                a(z);
                return true;
            case 1598968902:
                parcel2.writeString("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
