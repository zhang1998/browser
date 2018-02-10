package android.support.v4.media;

import android.os.IBinder;

/* compiled from: ProGuard */
final class t implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ h b;

    t(h hVar, n nVar) {
        this.b = hVar;
        this.a = nVar;
    }

    public final void run() {
        IBinder a = this.a.a();
        this.b.a.b.remove(a);
        f fVar = new f(this.b.a);
        fVar.c = this.a;
        this.b.a.b.put(a, fVar);
    }
}
