package com.ucpro.business.a.b;

import android.os.Message;
import android.webkit.ValueCallback;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ d b;

    e(d dVar, Message message) {
        this.b = dVar;
        this.a = message;
    }

    public final void run() {
        d.a(this.b);
        if (this.a.obj != null && (this.a.obj instanceof ValueCallback) && this.b.d != null && this.b.d.b()) {
            m.a(2, new f(this));
        }
    }
}
