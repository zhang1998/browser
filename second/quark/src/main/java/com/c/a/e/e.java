package com.c.a.e;

import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ProGuard */
public final class e {
    public boolean a;
    private Queue<Runnable> b = new LinkedBlockingQueue();
    private Queue<Runnable> c = new LinkedBlockingQueue();
    private final Object d = new Object();

    public final void a(Runnable runnable) {
        if (!this.a && runnable != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                synchronized (this.d) {
                    this.b.remove(runnable);
                    this.b.offer(runnable);
                }
                return;
            }
            runnable.run();
        }
    }

    public final void a() {
        synchronized (this.d) {
            this.c.addAll(this.b);
            this.b.clear();
        }
        while (this.c.size() > 0) {
            ((Runnable) this.c.poll()).run();
        }
    }
}
