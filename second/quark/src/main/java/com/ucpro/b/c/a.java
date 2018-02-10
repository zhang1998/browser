package com.ucpro.b.c;

/* compiled from: ProGuard */
public final class a implements Runnable {
    public boolean a;
    private final Runnable b;

    public a(Runnable runnable) {
        this.b = runnable;
    }

    public final void run() {
        this.b.run();
        synchronized (this) {
            this.a = true;
            notifyAll();
        }
    }
}
