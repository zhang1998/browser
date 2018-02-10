package android.support.v4.media;

import android.os.Bundle;
import android.util.Log;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ String b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ h d;

    k(h hVar, n nVar, String str, Bundle bundle) {
        this.d = hVar;
        this.a = nVar;
        this.b = str;
        this.c = bundle;
    }

    public final void run() {
        f fVar = (f) this.d.a.b.get(this.a.a());
        if (fVar == null) {
            Log.w("MediaBrowserServiceCompat", "removeSubscription for callback that isn't registered id=" + this.b);
        } else if (!MediaBrowserServiceCompat.a(this.b, fVar, this.c)) {
            Log.w("MediaBrowserServiceCompat", "removeSubscription called for " + this.b + " which is not subscribed");
        }
    }
}
