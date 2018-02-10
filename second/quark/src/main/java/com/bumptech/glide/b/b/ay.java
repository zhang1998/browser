package com.bumptech.glide.b.b;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
final class ay {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new ax());

    ay() {
    }

    public final void a(au<?> auVar) {
        l.a();
        if (this.a) {
            this.b.obtainMessage(1, auVar).sendToTarget();
            return;
        }
        this.a = true;
        auVar.d();
        this.a = false;
    }
}
