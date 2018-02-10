package com.UCMobile.Apollo.download.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ProGuard */
public interface c extends IInterface {

    /* compiled from: ProGuard */
    public abstract class a extends Binder implements c {

        /* compiled from: ProGuard */
        final class a implements c {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.a.transact(1, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int[] iArr, int[] iArr2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(ParcelableObject parcelableObject) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    if (parcelableObject != null) {
                        obtain.writeInt(1);
                        parcelableObject.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    a(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    a(parcel.createIntArray(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    ParcelableObject parcelableObject;
                    parcel.enforceInterface("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    if (parcel.readInt() != 0) {
                        parcelableObject = (ParcelableObject) ParcelableObject.CREATOR.createFromParcel(parcel);
                    } else {
                        parcelableObject = null;
                    }
                    a(parcelableObject);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.UCMobile.Apollo.download.service.IRemoteDownloaderListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i, int i2) throws RemoteException;

    void a(int i, long j) throws RemoteException;

    void a(int i, String str) throws RemoteException;

    void a(ParcelableObject parcelableObject) throws RemoteException;

    void a(int[] iArr, int[] iArr2) throws RemoteException;
}
