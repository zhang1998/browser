package com.bumptech.glide.b.b.c;

/* compiled from: ProGuard */
enum e extends f {
    e(String str) {
        super(str, 2);
    }

    protected final void a(Throwable th) {
        super.a(th);
        if (th != null) {
            throw new RuntimeException("Request threw uncaught throwable", th);
        }
    }
}
