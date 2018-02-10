package com.g.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ProGuard */
public abstract class b extends Binder implements c {
    public static c a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
            return new a(iBinder);
        }
        return (c) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String a;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                a = b();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 3:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                a = c();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.sina.sso.RemoteSSO");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
