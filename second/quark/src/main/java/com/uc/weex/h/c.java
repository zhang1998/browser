package com.uc.weex.h;

import java.lang.reflect.Constructor;
import java.util.concurrent.Semaphore;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ Constructor a;
    final /* synthetic */ Semaphore b;
    final /* synthetic */ d c;

    c(d dVar, Constructor constructor, Semaphore semaphore) {
        this.c = dVar;
        this.a = constructor;
        this.b = semaphore;
    }

    public final void run() {
        try {
            this.c.i = (com.uc.weex.c) this.a.newInstance(new Object[]{this.c});
        } catch (Exception e) {
        }
        this.b.release();
    }
}
