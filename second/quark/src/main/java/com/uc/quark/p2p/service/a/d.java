package com.uc.quark.p2p.service.a;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ProGuard */
final class d implements f {
    private IBinder a;

    d(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final void a(c cVar) throws RemoteException {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            if (cVar != null) {
                iBinder = cVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void b(c cVar) throws RemoteException {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            if (cVar != null) {
                iBinder = cVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void b(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean c(String str) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void d(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final long e(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final long f(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final byte g(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            byte readByte = obtain2.readByte();
            return readByte;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String h(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeString(str);
            this.a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void a(int i, Notification notification) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            obtain.writeInt(i);
            if (notification != null) {
                obtain.writeInt(1);
                notification.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(12, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(boolean z) throws RemoteException {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uc.quark.p2p.service.i.IP2pVideoPlayIPCService");
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.a.transact(13, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
