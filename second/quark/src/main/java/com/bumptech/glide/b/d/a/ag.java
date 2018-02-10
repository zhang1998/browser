package com.bumptech.glide.b.d.a;

import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: ProGuard */
final class ag implements Lock {
    ag() {
    }

    public final void lock() {
    }

    public final void lockInterruptibly() throws InterruptedException {
    }

    public final boolean tryLock() {
        return true;
    }

    public final boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return true;
    }

    public final void unlock() {
    }

    @NonNull
    public final Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }
}
