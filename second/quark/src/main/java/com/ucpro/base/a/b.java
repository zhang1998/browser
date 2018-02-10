package com.ucpro.base.a;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class b extends Handler {
    private WeakReference<f> a;

    public b(f fVar) {
        this.a = new WeakReference(fVar);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.get() != null) {
                    ((f) this.a.get()).a((Message) message.obj, message.arg1 == 1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
