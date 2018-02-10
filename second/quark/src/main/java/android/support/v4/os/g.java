package android.support.v4.os;

import android.os.Bundle;

/* compiled from: ProGuard */
public final class g implements Runnable {
    final int a;
    final Bundle b;
    final /* synthetic */ ResultReceiver c;

    public g(ResultReceiver resultReceiver, int i, Bundle bundle) {
        this.c = resultReceiver;
        this.a = i;
        this.b = bundle;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
