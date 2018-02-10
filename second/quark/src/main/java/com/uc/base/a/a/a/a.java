package com.uc.base.a.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: ProGuard */
public class a {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final HandlerThread b = new HandlerThread("UC Account SDK Looper Thread");
    private final Handler c;

    public a() {
        this.b.start();
        synchronized (this.b) {
            while (this.b.getLooper() == null) {
                try {
                    this.b.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        this.c = new Handler(this.b.getLooper());
    }

    public final void a(Runnable runnable) {
        this.c.post(runnable);
    }

    public final void b(Runnable runnable) {
        this.a.post(runnable);
    }
}
