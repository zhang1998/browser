package com.uc.quark.filedownloader.services;

import android.app.Notification;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.UCMobile.Apollo.ApolloMetaData;
import com.uc.quark.filedownloader.c.e;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.message.MessageSnapshot;
import com.uc.quark.filedownloader.message.b;
import com.uc.quark.filedownloader.message.c;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.networkstate.FileDownloadNetworkStateReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class d extends e implements c, q {
    private final RemoteCallbackList<com.uc.quark.filedownloader.c.c> a = new RemoteCallbackList();
    private final w b;
    private final WeakReference<FileDownloadService> c;
    private final Handler d;
    private final z e;
    private FileDownloadNetworkStateReceiver f;
    private final Runnable g = new n(this);

    private synchronized int b(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        beginBroadcast = this.a.beginBroadcast();
        int i = 0;
        while (i < beginBroadcast) {
            try {
                ((com.uc.quark.filedownloader.c.c) this.a.getBroadcastItem(i)).a(messageSnapshot);
                i++;
            } catch (RemoteException e) {
                j.a(this, "callback error", new Object[0]);
                this.a.finishBroadcast();
            } catch (Throwable th) {
                this.a.finishBroadcast();
            }
        }
        this.a.finishBroadcast();
        return beginBroadcast;
    }

    d(WeakReference<FileDownloadService> weakReference) {
        this.c = weakReference;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f = new FileDownloadNetworkStateReceiver();
        ((FileDownloadService) this.c.get()).registerReceiver(this.f, intentFilter);
        int i = c.a;
        this.b = new w();
        this.e = new z(c.b);
        this.d = new Handler(Looper.getMainLooper());
        b.a.a(this);
    }

    public final void f() {
        if (this.c != null && this.c.get() != null && this.f != null) {
            try {
                ((FileDownloadService) this.c.get()).unregisterReceiver(this.f);
            } catch (Exception e) {
            }
        }
    }

    public final void a(com.uc.quark.filedownloader.c.c cVar) throws RemoteException {
        this.a.register(cVar);
    }

    public final void b(com.uc.quark.filedownloader.c.c cVar) throws RemoteException {
        this.a.unregister(cVar);
    }

    public final boolean a(String str, String str2) throws RemoteException {
        return this.b.a(str, str2);
    }

    public final void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3, String str3, int i4, long j, String str4) throws RemoteException {
        w wVar = this.b;
        if (!wVar.a(str, str2)) {
            ae aeVar = new ae(wVar.b, wVar.a, wVar.c);
            aeVar.a = str;
            aeVar.b = str2;
            aeVar.c = z;
            aeVar.d = i;
            aeVar.e = i2;
            aeVar.f = i3;
            aeVar.g = z2;
            aeVar.h = fileDownloadHeader;
            aeVar.i = z3;
            aeVar.j = false;
            aeVar.k = str3;
            aeVar.n = i4;
            aeVar.o = j;
            aeVar.p = str4;
            aeVar.l = com.uc.quark.filedownloader.e.b.a(str, str2, z);
            g gVar = wVar.c;
            synchronized (gVar.a) {
                if (gVar.a.size() == gVar.c) {
                    gVar.b.put(aeVar.l, aeVar);
                    aeVar.i();
                } else {
                    gVar.a.put(aeVar.l, aeVar);
                    aeVar.i();
                    aeVar.j();
                }
                if (j.a) {
                    Log.e("vanda", "execTask size:" + gVar.a.size());
                }
            }
        }
    }

    public final boolean a(int i) throws RemoteException {
        return this.b.c(i);
    }

    public final void a() throws RemoteException {
        w wVar = this.b;
        synchronized (wVar.c) {
            g gVar = wVar.c;
            if (j.a) {
                j.d(gVar, "pause all tasks %d", Integer.valueOf(gVar.a.size()));
            }
            for (int i = 0; i < gVar.b.size(); i++) {
                ((ae) gVar.b.valueAt(i)).g();
            }
            gVar.b.clear();
            int[] iArr = new int[gVar.a.size()];
            for (int i2 = 0; i2 < gVar.a.size(); i2++) {
                iArr[i2] = gVar.a.keyAt(i2);
            }
            for (int c : iArr) {
                gVar.c(c);
            }
        }
    }

    public final boolean b(int i) throws RemoteException {
        return true;
    }

    public final long c(int i) throws RemoteException {
        com.uc.quark.filedownloader.model.b a = this.b.a.a(i);
        if (a == null) {
            return 0;
        }
        return a.g;
    }

    public final long d(int i) throws RemoteException {
        com.uc.quark.filedownloader.model.b a = this.b.a.a(i);
        if (a == null) {
            return 0;
        }
        return a.h;
    }

    public final byte e(int i) throws RemoteException {
        com.uc.quark.filedownloader.model.b a = this.b.a.a(i);
        if (a == null) {
            return (byte) 0;
        }
        return a.f;
    }

    public final boolean b() throws RemoteException {
        return this.b.b() && this.e.a();
    }

    public final String g(int i) throws RemoteException {
        return this.b.a(i);
    }

    public final boolean h(int i) throws RemoteException {
        return this.b.b(i);
    }

    public final void a(int i, Notification notification) throws RemoteException {
        if (this.c != null && this.c.get() != null) {
            ((FileDownloadService) this.c.get()).startForeground(i, notification);
        }
    }

    public final void a(boolean z) throws RemoteException {
        if (this.c != null && this.c.get() != null) {
            ((FileDownloadService) this.c.get()).stopForeground(z);
        }
    }

    public final boolean f(int i) throws RemoteException {
        return this.b.d(i);
    }

    public final void c() {
    }

    public final byte[] e() {
        return this.b.a();
    }

    public final void a(Bundle bundle) throws RemoteException {
        if (bundle != null) {
            try {
                for (Map map : (List) bundle.getParcelableArrayList(com.uc.quark.filedownloader.e.e.d).get(0)) {
                    this.e.a((String) map.get("url"), (String) map.get("path"), ((Boolean) map.get("path_as_directory")).booleanValue(), ((Integer) map.get("progress_times")).intValue(), ((Integer) map.get("progress_times_min")).intValue(), ((Integer) map.get("auto_retry_times")).intValue(), ((Boolean) map.get("force_re_download")).booleanValue(), new FileDownloadHeader((String) map.get(ApolloMetaData.KEY_HEADER)), ((Boolean) map.get("is_wifi_request")).booleanValue(), true, "");
                }
            } catch (Throwable e) {
                Log.e("hjw-video", "startList exception:", e);
            }
        }
    }

    public final void a(Bundle bundle, boolean z) throws RemoteException {
        if (bundle != null) {
            ArrayList integerArrayList = bundle.getIntegerArrayList(com.uc.quark.filedownloader.e.e.e);
            if (integerArrayList != null) {
                Iterator it = integerArrayList.iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    this.e.b(intValue);
                    if (z) {
                        this.e.c(intValue);
                    }
                }
            }
        }
    }

    public final IBinder g() {
        return this;
    }

    public final void a(MessageSnapshot messageSnapshot) {
        b(messageSnapshot);
        byte i = messageSnapshot.i();
        if (i == (byte) -3 || i == (byte) -2 || i == (byte) -1 || i == (byte) -5) {
            if (!messageSnapshot.j()) {
                d();
            }
        } else if (i == (byte) 3 || i == (byte) 7 || i == (byte) 1) {
            this.d.removeCallbacks(this.g);
        }
    }

    public final void d() {
        this.d.removeCallbacks(this.g);
        this.d.postDelayed(this.g, 30000);
    }

    public final void h() {
        b.a.a(null);
    }
}
