package com.ucpro.feature.navigation.view;

import android.os.Handler;
import android.os.Looper;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
public final class h implements Runnable {
    long a;
    Handler b = new e(getClass().getName() + 16, Looper.getMainLooper());
    aw c;
    boolean d = false;

    public final void a() {
        if (this.a != 0) {
            this.a = 0;
            this.d = false;
            this.b.removeCallbacks(this);
        }
    }

    public final void run() {
        this.d = false;
        if (this.a != 0 && this.c != null) {
            this.c.a();
        }
    }
}
