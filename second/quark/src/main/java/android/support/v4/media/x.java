package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: ProGuard */
final class x implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ String b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ int d;
    final /* synthetic */ h e;

    x(h hVar, n nVar, String str, Bundle bundle, int i) {
        this.e = hVar;
        this.a = nVar;
        this.b = str;
        this.c = bundle;
        this.d = i;
    }

    public final void run() {
        IBinder a = this.a.a();
        this.e.a.b.remove(a);
        f fVar = new f(this.e.a);
        fVar.a = this.b;
        fVar.b = this.c;
        fVar.c = this.a;
        fVar.d = this.e.a.a();
        if (fVar.d == null) {
            new StringBuilder("No root for client ").append(this.b).append(" from service ").append(getClass().getName());
            try {
                this.a.b();
                return;
            } catch (RemoteException e) {
                Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.b);
                return;
            }
        }
        try {
            this.e.a.b.put(a, fVar);
            if (this.e.a.a != null) {
                this.a.a(fVar.d.a, this.e.a.a, fVar.d.b);
            }
        } catch (RemoteException e2) {
            Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.b);
            this.e.a.b.remove(a);
        }
    }
}
