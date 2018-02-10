package android.mini.support.v4.app;

import android.os.Handler;
import android.os.Message;

/* compiled from: ProGuard */
final class o extends Handler {
    final /* synthetic */ FragmentActivity a;

    o(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.g) {
                    this.a.a(false);
                    return;
                }
                return;
            case 2:
                this.a.b();
                this.a.d.b();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
