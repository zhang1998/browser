package com.uc.apollo.media.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: ProGuard */
public interface i extends IInterface {

    /* compiled from: ProGuard */
    public abstract class a extends Binder implements i {

        /* compiled from: ProGuard */
        final class a implements i {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2, int i3, w wVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (wVar != null) {
                        obtain.writeInt(1);
                        wVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeString(str);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeString(str);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final float c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeString(str);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    float readFloat = obtain2.readFloat();
                    return readFloat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean d(String str) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeString(str);
                    this.a.transact(11, obtain, obtain2, 0);
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

            public final String e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeString(str);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeString(str);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeMap(map);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.uc.apollo.media.service.IMediaPlayerServiceListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    b(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    w wVar;
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    int readInt = parcel.readInt();
                    int readInt2 = parcel.readInt();
                    int readInt3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        wVar = (w) w.a.createFromParcel(parcel);
                    } else {
                        wVar = null;
                    }
                    a(readInt, readInt2, readInt3, wVar);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 9:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    int b = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b);
                    return true;
                case 10:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    float c = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeFloat(c);
                    return true;
                case 11:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    boolean d = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(d ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 13:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a = f(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 14:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    a(parcel.readInt(), parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    c(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a(String str) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(int i, int i2, int i3) throws RemoteException;

    void a(int i, int i2, int i3, int i4) throws RemoteException;

    void a(int i, int i2, int i3, w wVar) throws RemoteException;

    void a(int i, int i2, Map map) throws RemoteException;

    int b(String str) throws RemoteException;

    void b(int i) throws RemoteException;

    void b(int i, int i2, int i3) throws RemoteException;

    float c(String str) throws RemoteException;

    void c(int i, int i2, int i3) throws RemoteException;

    boolean d(String str) throws RemoteException;

    String e(String str) throws RemoteException;

    String f(String str) throws RemoteException;
}
