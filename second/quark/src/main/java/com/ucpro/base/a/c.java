package com.ucpro.base.a;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class c extends Handler {
    private WeakReference<g> a;

    public c(g gVar) {
        this.a = new WeakReference(gVar);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.get() != null) {
                    ((g) this.a.get()).a((Message) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
