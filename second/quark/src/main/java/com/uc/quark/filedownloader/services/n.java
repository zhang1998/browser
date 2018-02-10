package com.uc.quark.filedownloader.services;

import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.uc.quark.filedownloader.e.j;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ d a;

    n(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        boolean b = this.a.b.b();
        boolean a = this.a.e.a();
        if (j.a) {
            Log.e("vanda", "kill process isIdle = " + b + "   isIdleList = " + a);
        }
        if (b && a) {
            try {
                this.a.a(true);
                if (!(this.a.c == null || this.a.c.get() == null)) {
                    this.a.f();
                    ((FileDownloadService) this.a.c.get()).stopSelf();
                }
                Process.killProcess(Process.myPid());
            } catch (RemoteException e) {
            }
        }
    }
}
