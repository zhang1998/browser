package com.e.b.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Map;

/* compiled from: ProGuard */
public final class a extends Handler {
    final /* synthetic */ b a;

    public a(b bVar, Looper looper) {
        this.a = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        if (message.obj != null) {
            Map map = (Map) message.obj;
            if (this.a.c != null) {
                this.a.c.a(map);
                return;
            }
            return;
        }
        this.a.c.a(null);
    }
}
