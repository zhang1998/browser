package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ProGuard */
public abstract class c extends Binder implements f {
    public c() {
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    public static f a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
            return new i(iBinder);
        }
        return (f) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                Bundle bundle;
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                a(readInt, bundle);
                return true;
            case 1598968902:
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
