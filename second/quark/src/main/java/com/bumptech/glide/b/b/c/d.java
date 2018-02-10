package com.bumptech.glide.b.b.c;

import android.util.Log;

/* compiled from: ProGuard */
enum d extends f {
    d(String str) {
        super(str, 1);
    }

    protected final void a(Throwable th) {
        if (th != null && Log.isLoggable("GlideExecutor", 6)) {
            Log.e("GlideExecutor", "Request threw uncaught throwable", th);
        }
    }
}
