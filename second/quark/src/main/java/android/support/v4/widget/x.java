package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: ProGuard */
final class x extends ContentObserver {
    final /* synthetic */ az a;

    public x(az azVar) {
        this.a = azVar;
        super(new Handler());
    }

    public final boolean deliverSelfNotifications() {
        return true;
    }

    public final void onChange(boolean z) {
        this.a.b();
    }
}
