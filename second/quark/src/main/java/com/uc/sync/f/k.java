package com.uc.sync.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class k extends Handler {
    private WeakReference<a> a;

    k(Looper looper, a aVar) {
        super(looper);
        this.a = new WeakReference(aVar);
    }

    public final void handleMessage(Message message) {
        a aVar = (a) this.a.get();
        if (aVar != null) {
            switch (message.what) {
                case 262145:
                    if (message.obj instanceof j) {
                        aVar.b.a((j) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
