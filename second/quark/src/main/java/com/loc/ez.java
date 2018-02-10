package com.loc;

import android.content.Context;

/* compiled from: ProGuard */
final class ez implements bo {
    private Context a;

    ez(Context context) {
        this.a = context;
    }

    public final void a() {
        try {
            ew.b(this.a);
        } catch (Throwable th) {
            es.a(th, "LogNetListener", "onNetCompleted");
        }
    }
}
