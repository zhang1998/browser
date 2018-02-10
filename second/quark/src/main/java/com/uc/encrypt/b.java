package com.uc.encrypt;

import android.content.Context;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ byte a;
    final /* synthetic */ Context b;

    b(byte b, Context context) {
        this.a = b;
        this.b = context;
    }

    public final void run() {
        m.a = this.a;
        System.currentTimeMillis();
        try {
            f.d().a(this.b);
            System.currentTimeMillis();
            f.c();
        } catch (Throwable e) {
            f.a(e, e.getErrorCode());
        } catch (Throwable e2) {
            f.a(e2, 2);
        }
    }
}
