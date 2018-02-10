package android.support.v4.os;

import android.os.Bundle;

/* compiled from: ProGuard */
final class h extends c {
    final /* synthetic */ ResultReceiver a;

    h(ResultReceiver resultReceiver) {
        this.a = resultReceiver;
    }

    public final void a(int i, Bundle bundle) {
        if (this.a.b != null) {
            this.a.b.post(new g(this.a, i, bundle));
        } else {
            this.a.a(i, bundle);
        }
    }
}
