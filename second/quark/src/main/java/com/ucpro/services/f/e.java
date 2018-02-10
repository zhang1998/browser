package com.ucpro.services.f;

import java.io.IOException;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ IOException a;
    final /* synthetic */ f b;

    e(f fVar, IOException iOException) {
        this.b = fVar;
        this.a = iOException;
    }

    public final void run() {
        if (this.b.a.b != null) {
            this.b.a.b.a(this.a != null ? this.a.getMessage() : "");
        }
    }
}
