package com.bumptech.glide.b.b.c;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class g extends ThreadPoolExecutor {
    private static final long b = TimeUnit.SECONDS.toMillis(10);
    private final boolean a;

    public static g a() {
        return new g(1, "disk-cache", f.d, true);
    }

    public static g b() {
        return new g(d(), "source", f.d, false);
    }

    public static g c() {
        return new g(0, Integer.MAX_VALUE, b, "source-unlimited", f.d, false, false, new SynchronousQueue());
    }

    private g(int i, String str, f fVar, boolean z) {
        this(i, i, str, fVar, z);
    }

    private g(int i, int i2, String str, f fVar, boolean z) {
        this(i, i2, 0, str, fVar, z, false, new PriorityBlockingQueue());
    }

    private g(int i, int i2, long j, String str, f fVar, boolean z, boolean z2, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, TimeUnit.MILLISECONDS, blockingQueue, new c(str, fVar, z));
        this.a = false;
    }

    public final void execute(Runnable runnable) {
        if (this.a) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @NonNull
    public final Future<?> submit(Runnable runnable) {
        return a(super.submit(runnable));
    }

    private <T> Future<T> a(Future<T> future) {
        if (this.a) {
            Object obj = null;
            while (!future.isDone()) {
                try {
                    future.get();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e2) {
                    obj = 1;
                } catch (Throwable th) {
                    if (obj != null) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
        }
        return future;
    }

    @NonNull
    public final <T> Future<T> submit(Runnable runnable, T t) {
        return a(super.submit(runnable, t));
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return a(super.submit(callable));
    }

    private static int d() {
        File[] listFiles;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            listFiles = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        return Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), listFiles != null ? listFiles.length : 0));
    }
}
