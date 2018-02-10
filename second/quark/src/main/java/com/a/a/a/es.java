package com.a.a.a;

import com.a.a.b;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: ProGuard */
public final class es implements UncaughtExceptionHandler {
    public ew a;
    private UncaughtExceptionHandler b;

    public es() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (b.f) {
            this.a.a(th);
        } else {
            this.a.a(null);
        }
        if (this.b != null && this.b != Thread.getDefaultUncaughtExceptionHandler()) {
            this.b.uncaughtException(thread, th);
        }
    }
}
