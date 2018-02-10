package com.uc.apollo.media.service;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.uc.apollo.preload.b;
import java.util.Map;

/* compiled from: ProGuard */
public interface h extends IInterface {

    /* compiled from: ProGuard */
    public abstract class a extends Binder implements h {

        /* compiled from: ProGuard */
        final class a implements h {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(i iVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.a.transact(4, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(5, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, u uVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    if (uVar != null) {
                        obtain.writeInt(1);
                        uVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void g(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void h(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int i(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void j(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bitmap k(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bitmap bitmap;
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2);
                    } else {
                        bitmap = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bitmap;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void e(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final y a(int i, int i2, y yVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    y yVar2;
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (yVar != null) {
                        obtain.writeInt(1);
                        yVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        yVar2 = (y) y.a.createFromParcel(obtain2);
                    } else {
                        yVar2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return yVar2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, int i2, int i3, int i4, boolean z, int i5) throws RemoteException {
                int i6 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (z) {
                        i6 = 1;
                    }
                    obtain.writeInt(i6);
                    obtain.writeInt(i5);
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean b(int i, String str, String str2) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(29, obtain, obtain2, 0);
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

            public final String a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    this.a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    this.a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, String str2, Map map, com.uc.apollo.preload.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.a.transact(34, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeString(str);
                    this.a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeString(str);
                    this.a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uc.apollo.media.service.IMediaPlayerService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.uc.apollo.media.service.IMediaPlayerService");
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uc.apollo.media.service.IMediaPlayerService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            y yVar = null;
            int i3 = 0;
            int readInt;
            int i4;
            int readInt2;
            boolean z;
            boolean z2;
            String a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    i aVar;
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.uc.apollo.media.service.IMediaPlayerServiceListener");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                            aVar = new a(readStrongBinder);
                        } else {
                            aVar = (i) queryLocalInterface;
                        }
                    }
                    a(aVar);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    c(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    e(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    u uVar;
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        uVar = (u) u.a.createFromParcel(parcel);
                    }
                    a(readInt, uVar);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    f(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    g(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    b(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    h(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    i4 = i(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i4);
                    return true;
                case 17:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    j(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    Bitmap k = k(parcel.readInt());
                    parcel2.writeNoException();
                    if (k != null) {
                        parcel2.writeInt(1);
                        k.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readInt(), parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    c(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    d(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    e(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    readInt = parcel.readInt();
                    readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        yVar = (y) y.a.createFromParcel(parcel);
                    }
                    yVar = a(readInt, readInt2, yVar);
                    parcel2.writeNoException();
                    if (yVar != null) {
                        parcel2.writeInt(1);
                        yVar.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 24:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    readInt = parcel.readInt();
                    readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(readInt, readInt2, z);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    i4 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    a(i4, z2);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    readInt = parcel.readInt();
                    readInt2 = parcel.readInt();
                    int readInt3 = parcel.readInt();
                    int readInt4 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    a(readInt, readInt2, readInt3, readInt4, z2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    z = b(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (z) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 30:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a = a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 31:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), com.uc.apollo.preload.a.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 38:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.uc.apollo.media.service.IMediaPlayerService");
                    a(com.uc.apollo.preload.b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.uc.apollo.media.service.IMediaPlayerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    y a(int i, int i2, y yVar) throws RemoteException;

    String a(int i, String str) throws RemoteException;

    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, float f, float f2) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(int i, int i2, int i3) throws RemoteException;

    void a(int i, int i2, int i3, int i4) throws RemoteException;

    void a(int i, int i2, int i3, int i4, boolean z, int i5) throws RemoteException;

    void a(int i, int i2, boolean z) throws RemoteException;

    void a(int i, u uVar) throws RemoteException;

    void a(int i, String str, String str2) throws RemoteException;

    void a(int i, boolean z) throws RemoteException;

    void a(i iVar) throws RemoteException;

    void a(b bVar) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, int i) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, String str2, Map map, com.uc.apollo.preload.a aVar) throws RemoteException;

    void b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(int i, int i2) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(String str, String str2) throws RemoteException;

    boolean b(int i, String str, String str2) throws RemoteException;

    String c(String str) throws RemoteException;

    void c() throws RemoteException;

    void c(int i) throws RemoteException;

    void c(int i, int i2) throws RemoteException;

    void d(int i) throws RemoteException;

    void d(int i, int i2) throws RemoteException;

    void e(int i) throws RemoteException;

    void e(int i, int i2) throws RemoteException;

    void f(int i) throws RemoteException;

    void g(int i) throws RemoteException;

    void h(int i) throws RemoteException;

    int i(int i) throws RemoteException;

    void j(int i) throws RemoteException;

    Bitmap k(int i) throws RemoteException;
}
