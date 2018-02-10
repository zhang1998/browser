package com.loc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: ProGuard */
final class cc implements ServiceConnection {
    final /* synthetic */ cf a;
    final /* synthetic */ cg b;

    cc(cg cgVar, cf cfVar) {
        this.b = cgVar;
        this.a = cfVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.c = du.a(iBinder);
        this.a.a(0);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.b.c = null;
    }
}
