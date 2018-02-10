package com.bumptech.glide.b.b.c;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* compiled from: ProGuard */
final class c implements ThreadFactory {
    final f a;
    final boolean b;
    private final String c;
    private int d;

    c(String str, f fVar, boolean z) {
        this.c = str;
        this.a = fVar;
        this.b = z;
    }

    public final synchronized Thread newThread(@NonNull Runnable runnable) {
        Thread bVar;
        bVar = new b(this, runnable, "glide-" + this.c + "-thread-" + this.d);
        this.d++;
        return bVar;
    }
}
