package com.loc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ProGuard */
public abstract class du extends Binder implements dv {
    public static dv a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.service.locationprovider.ILocationProviderService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dv)) ? new dt(iBinder) : (dv) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.amap.api.service.locationprovider.ILocationProviderService");
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                int a = a(bundle);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 1598968902:
                parcel2.writeString("com.amap.api.service.locationprovider.ILocationProviderService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
