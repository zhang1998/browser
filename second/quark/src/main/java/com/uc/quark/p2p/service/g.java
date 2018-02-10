package com.uc.quark.p2p.service;

import android.os.Binder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.uc.quark.p2p.service.a.f;

/* compiled from: ProGuard */
public final class g extends a<f, f> {
    protected final /* bridge */ /* synthetic */ void a(IInterface iInterface, Binder binder) throws RemoteException {
        ((f) iInterface).a((f) binder);
    }

    public g() {
        super(P2pVideoPlayService.class);
    }

    public final boolean a(String str) {
        try {
            ((f) this.a).b(str);
        } catch (RemoteException e) {
        }
        return false;
    }

    public final boolean b(String str) {
        try {
            ((f) this.a).c(str);
        } catch (RemoteException e) {
        }
        return false;
    }

    public final void c(String str) {
        try {
            ((f) this.a).d(str);
        } catch (RemoteException e) {
        }
    }

    public final String d(String str) {
        try {
            return ((f) this.a).h(str);
        } catch (RemoteException e) {
            Log.e("vanda", "e = " + e);
            return "";
        }
    }

    public final void e(String str) {
        try {
            ((f) this.a).a(str);
        } catch (RemoteException e) {
        }
    }

    protected final /* synthetic */ Binder b() {
        return new f();
    }
}
