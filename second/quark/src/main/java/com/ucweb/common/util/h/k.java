package com.ucweb.common.util.h;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.ucweb.common.util.b.a;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
final class k implements IdleHandler {
    static final MessageQueue a = ((MessageQueue) a.a(Looper.getMainLooper(), "mQueue"));
    static final Handler b = new e("IdleHandler", Looper.getMainLooper());
    final Runnable c = new f(this);
    private Runnable d;

    public k(Runnable runnable) {
        this.d = runnable;
    }

    public final boolean queueIdle() {
        b.removeCallbacks(this.c);
        this.d.run();
        return false;
    }
}
