package android.mini.support.v4.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProGuard */
final class d extends Handler {
    final /* synthetic */ g a;

    d(g gVar, Looper looper) {
        this.a = gVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                g.a(this.a);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
