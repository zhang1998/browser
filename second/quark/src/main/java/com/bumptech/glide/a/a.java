package com.bumptech.glide.a;

import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class a implements Callable<Void> {
    final /* synthetic */ f a;

    a(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ Object call() throws Exception {
        return a();
    }

    private Void a() throws Exception {
        synchronized (this.a) {
            if (this.a.j == null) {
            } else {
                this.a.g();
                if (this.a.e()) {
                    this.a.d();
                    this.a.l = 0;
                }
            }
        }
        return null;
    }
}
