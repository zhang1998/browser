package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

/* compiled from: ProGuard */
final class bu extends Handler {
    final /* synthetic */ FragmentActivity a;

    bu(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.e) {
                    this.a.a(false);
                    return;
                }
                return;
            case 2:
                this.a.d();
                this.a.b.b();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
