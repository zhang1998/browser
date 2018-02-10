package com.g.b.a.b.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.g.a.b;
import com.g.a.c;

/* compiled from: ProGuard */
final class a implements ServiceConnection {
    final /* synthetic */ c a;

    a(c cVar) {
        this.a = cVar;
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.a.a(new com.g.b.a.c.a("SSO failed--Service Disconnected"));
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c a = b.a(iBinder);
        try {
            String a2 = a.a();
            String b = a.b();
            this.a.c.getApplicationContext().unbindService(this.a.f);
            if (!this.a.a(a2, b, this.a.d)) {
                this.a.a.a(new com.g.b.a.c.a("SSO failed--Start SSO failed"));
            }
        } catch (RemoteException e) {
        }
    }
}
