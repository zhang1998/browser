package com.uc.quark.p2p.service;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.uc.m;
import com.uc.quark.p2p.service.a.c;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class e extends com.uc.quark.p2p.service.a.e implements b {
    private final WeakReference<P2pVideoPlayService> a;

    public e(WeakReference<P2pVideoPlayService> weakReference) {
        this.a = weakReference;
    }

    public final IBinder b() {
        return this;
    }

    public final void a(c cVar) throws RemoteException {
    }

    public final void b(c cVar) throws RemoteException {
    }

    public final void a(String str) throws RemoteException {
        if (!TextUtils.isEmpty(str)) {
            m.b = str;
        }
    }

    public final void b(String str) throws RemoteException {
        com.uc.c a = d.a(str);
        if (a != null) {
            a.a();
        }
    }

    public final boolean c(String str) throws RemoteException {
        com.uc.c a = d.a(str);
        if (a != null) {
            a.c();
        }
        return true;
    }

    public final void a() throws RemoteException {
    }

    public final void d(String str) throws RemoteException {
        com.uc.c a = d.a(str);
        if (a != null) {
            a.b();
        }
    }

    public final long e(String str) throws RemoteException {
        d.a(str);
        return 0;
    }

    public final long f(String str) throws RemoteException {
        d.a(str);
        return 0;
    }

    public final byte g(String str) throws RemoteException {
        return (byte) 0;
    }

    public final String h(String str) throws RemoteException {
        com.uc.c a = d.a(str);
        return a != null ? a.d() : "";
    }

    public final void a(int i, Notification notification) throws RemoteException {
        if (this.a != null && this.a.get() != null) {
            ((P2pVideoPlayService) this.a.get()).startForeground(i, notification);
        }
    }

    public final void a(boolean z) throws RemoteException {
        if (this.a != null && this.a.get() != null) {
            ((P2pVideoPlayService) this.a.get()).stopForeground(z);
        }
    }
}
