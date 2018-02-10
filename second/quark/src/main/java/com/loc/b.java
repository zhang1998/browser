package com.loc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

/* compiled from: ProGuard */
final class b implements ServiceConnection {
    final /* synthetic */ j a;

    b(j jVar) {
        this.a = jVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.i = new Messenger(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.i = null;
    }
}
