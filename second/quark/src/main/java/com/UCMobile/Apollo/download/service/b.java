package com.UCMobile.Apollo.download.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ProGuard */
public interface b extends IInterface {

    /* compiled from: ProGuard */
    public abstract class a extends Binder implements b {

        /* compiled from: ProGuard */
        final class a implements b {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    obtain.writeString(str);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.UCMobile.Apollo.download.service.IPlayingDownloader");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    a = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    a = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    a = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 4:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    a = d();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 5:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    a = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 6:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    a = a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 7:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    String f = f();
                    parcel2.writeNoException();
                    parcel2.writeString(f);
                    return true;
                case 9:
                    c cVar;
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        cVar = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                            cVar = new a(readStrongBinder);
                        } else {
                            cVar = (c) queryLocalInterface;
                        }
                    }
                    a(cVar);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.UCMobile.Apollo.download.service.IPlayingDownloader");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a() throws RemoteException;

    int a(String str, String str2) throws RemoteException;

    void a(c cVar) throws RemoteException;

    void a(String str) throws RemoteException;

    int b() throws RemoteException;

    int c() throws RemoteException;

    int d() throws RemoteException;

    int e() throws RemoteException;

    String f() throws RemoteException;
}
