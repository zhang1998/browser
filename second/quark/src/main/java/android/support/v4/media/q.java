package android.support.v4.media;

import android.support.v4.os.ResultReceiver;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ResultReceiver b;
    final /* synthetic */ h c;

    q(h hVar, String str, ResultReceiver resultReceiver) {
        this.c = hVar;
        this.a = str;
        this.b = resultReceiver;
    }

    public final void run() {
        MediaBrowserServiceCompat.a(this.c.a, this.a, this.b);
    }
}
