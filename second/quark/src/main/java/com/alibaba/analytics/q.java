package com.alibaba.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

/* compiled from: ProGuard */
public abstract class q extends Binder implements h {
    public q() {
        attachInterface(this, "com.alibaba.analytics.IAnalytics");
    }

    public static h a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.alibaba.analytics.IAnalytics");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
            return new a(iBinder);
        }
        return (h) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3 = 0;
        DimensionSet dimensionSet = null;
        String c;
        boolean z;
        boolean z2;
        String readString;
        String readString2;
        MeasureSet measureSet;
        String readString3;
        Transaction transaction;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a();
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                b(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                b();
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                c(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                c();
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                d();
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                c = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 13:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                e();
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                a(z);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                z = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z2 = true;
                }
                a(z, z2, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                d(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                f();
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                g();
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                h();
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                b(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                readString = parcel.readString();
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    measureSet = (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel);
                } else {
                    measureSet = null;
                }
                a(readString, readString2, measureSet);
                parcel2.writeNoException();
                return true;
            case 24:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                readString = parcel.readString();
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    measureSet = (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel);
                } else {
                    measureSet = null;
                }
                if (parcel.readInt() != 0) {
                    z2 = true;
                }
                a(readString, readString2, measureSet, z2);
                parcel2.writeNoException();
                return true;
            case 25:
                MeasureSet measureSet2;
                DimensionSet dimensionSet2;
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                readString2 = parcel.readString();
                readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    measureSet2 = (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel);
                } else {
                    measureSet2 = null;
                }
                if (parcel.readInt() != 0) {
                    dimensionSet2 = (DimensionSet) DimensionSet.CREATOR.createFromParcel(parcel);
                } else {
                    dimensionSet2 = null;
                }
                a(readString2, readString3, measureSet2, dimensionSet2);
                parcel2.writeNoException();
                return true;
            case 26:
                MeasureSet measureSet3;
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                readString = parcel.readString();
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    measureSet3 = (MeasureSet) MeasureSet.CREATOR.createFromParcel(parcel);
                } else {
                    measureSet3 = null;
                }
                if (parcel.readInt() != 0) {
                    dimensionSet = (DimensionSet) DimensionSet.CREATOR.createFromParcel(parcel);
                }
                if (parcel.readInt() != 0) {
                    z2 = true;
                }
                a(readString, readString2, measureSet3, dimensionSet, z2);
                parcel2.writeNoException();
                return true;
            case 27:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
                parcel2.writeNoException();
                return true;
            case 28:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                c(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 29:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                d(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 30:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                z = b(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (z) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 31:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString(), parcel.readString(), parcel.readDouble());
                parcel2.writeNoException();
                return true;
            case 32:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble());
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                e(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 34:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                f(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 35:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                z = c(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (z) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 36:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                b(parcel.readString(), parcel.readString(), parcel.readDouble());
                parcel2.writeNoException();
                return true;
            case 37:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                g(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 38:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                h(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 39:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                z = d(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (z) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 40:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                e(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 41:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 42:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 43:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 44:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                b(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 45:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                c(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 46:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                i(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 47:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                j(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 48:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                z = f(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (z) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 49:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                c(parcel.readString(), parcel.readString(), parcel.readDouble());
                parcel2.writeNoException();
                return true;
            case 50:
                DimensionValueSet dimensionValueSet;
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                readString = parcel.readString();
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    dimensionValueSet = (DimensionValueSet) DimensionValueSet.CREATOR.createFromParcel(parcel);
                } else {
                    dimensionValueSet = null;
                }
                a(readString, readString2, dimensionValueSet, parcel.readDouble());
                parcel2.writeNoException();
                return true;
            case 51:
                DimensionValueSet dimensionValueSet2;
                MeasureValueSet measureValueSet;
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                readString2 = parcel.readString();
                readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    dimensionValueSet2 = (DimensionValueSet) DimensionValueSet.CREATOR.createFromParcel(parcel);
                } else {
                    dimensionValueSet2 = null;
                }
                if (parcel.readInt() != 0) {
                    measureValueSet = (MeasureValueSet) MeasureValueSet.CREATOR.createFromParcel(parcel);
                } else {
                    measureValueSet = null;
                }
                a(readString2, readString3, dimensionValueSet2, measureValueSet);
                parcel2.writeNoException();
                return true;
            case 52:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                if (parcel.readInt() != 0) {
                    transaction = (Transaction) Transaction.f.createFromParcel(parcel);
                } else {
                    transaction = null;
                }
                a(transaction, parcel.readString());
                parcel2.writeNoException();
                return true;
            case 53:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                if (parcel.readInt() != 0) {
                    transaction = (Transaction) Transaction.f.createFromParcel(parcel);
                } else {
                    transaction = null;
                }
                b(transaction, parcel.readString());
                parcel2.writeNoException();
                return true;
            case 55:
                parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                c = d(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 1598968902:
                parcel2.writeString("com.alibaba.analytics.IAnalytics");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
