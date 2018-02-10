package com.uc.quark.filedownloader.c;

import android.app.Notification;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.uc.quark.filedownloader.model.FileDownloadHeader;

/* compiled from: ProGuard */
public abstract class e extends Binder implements b {
    public e() {
        attachInterface(this, "com.uc.quark.filedownloader.i.IFileDownloadIPCService");
    }

    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
            return new a(iBinder);
        }
        return (b) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean a;
        Bundle bundle;
        long c;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a(f.a(parcel.readStrongBinder()));
                return true;
            case 2:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                b(f.a(parcel.readStrongBinder()));
                return true;
            case 3:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 4:
                FileDownloadHeader fileDownloadHeader;
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean z = parcel.readInt() != 0;
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    fileDownloadHeader = (FileDownloadHeader) FileDownloadHeader.CREATOR.createFromParcel(parcel);
                } else {
                    fileDownloadHeader = null;
                }
                a(readString, readString2, z, readInt, readInt2, readInt3, z2, fileDownloadHeader, parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a = a(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 6:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a();
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                a(bundle, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a = b(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 9:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                c = c(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(c);
                return true;
            case 10:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                c = d(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(c);
                return true;
            case 11:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                byte e = e(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeByte(e);
                return true;
            case 12:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a = b();
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 13:
                Notification notification;
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                int readInt4 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                } else {
                    notification = null;
                }
                a(readInt4, notification);
                return true;
            case 14:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a(parcel.readInt() != 0);
                return true;
            case 15:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a = f(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 16:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                c();
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                d();
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                byte[] e2 = e();
                parcel2.writeNoException();
                parcel2.writeByteArray(e2);
                return true;
            case 19:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                a(bundle);
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                String g = g(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(g);
                return true;
            case 21:
                parcel.enforceInterface("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                a = h(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 1598968902:
                parcel2.writeString("com.uc.quark.filedownloader.i.IFileDownloadIPCService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
