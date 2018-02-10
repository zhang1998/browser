package com.loc;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: ProGuard */
public final class fa extends es implements UncaughtExceptionHandler {
    private static ExecutorService e;
    private Context d;

    private fa(Context context) {
        this.d = context;
        bn.a = new ez(context);
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
            } else if (this.b.toString().indexOf("com.amap.api") != -1) {
                this.c = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
            }
        } catch (Throwable th) {
        }
    }

    public static synchronized fa a(Context context, ep epVar) throws dw {
        fa faVar;
        synchronized (fa.class) {
            if (epVar == null) {
                throw new dw("sdk info is null");
            } else if (epVar.a() == null || "".equals(epVar.a())) {
                throw new dw("sdk name is invalid");
            } else {
                try {
                    if (es.a == null) {
                        es.a = new fa(context);
                    } else {
                        es.a.c = false;
                    }
                    es.a.a(context, epVar, es.a.c);
                } catch (Throwable th) {
                }
                faVar = (fa) es.a;
            }
        }
        return faVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a() {
        /*
        r1 = com.loc.fa.class;
        monitor-enter(r1);
        r0 = e;	 Catch:{ Throwable -> 0x002f, all -> 0x002a }
        if (r0 == 0) goto L_0x000c;
    L_0x0007:
        r0 = e;	 Catch:{ Throwable -> 0x002f, all -> 0x002a }
        r0.shutdown();	 Catch:{ Throwable -> 0x002f, all -> 0x002a }
    L_0x000c:
        r0 = com.loc.es.a;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        if (r0 == 0) goto L_0x0025;
    L_0x0010:
        r0 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r2 = com.loc.es.a;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        if (r0 != r2) goto L_0x0025;
    L_0x0018:
        r0 = com.loc.es.a;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r0 = r0.b;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = com.loc.es.a;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r0 = r0.b;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
    L_0x0025:
        r0 = 0;
        com.loc.es.a = r0;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
    L_0x0028:
        monitor-exit(r1);
        return;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x002d:
        r0 = move-exception;
        goto L_0x0028;
    L_0x002f:
        r0 = move-exception;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.fa.a():void");
    }

    public static synchronized ExecutorService b() {
        ExecutorService executorService;
        synchronized (fa.class) {
            try {
                if (e == null || e.isShutdown()) {
                    e = Executors.newSingleThreadExecutor();
                }
            } catch (Throwable th) {
            }
            executorService = e;
        }
        return executorService;
    }

    public static void b(ep epVar, String str, String str2) {
        if (es.a != null) {
            es.a.a(epVar, str, str2);
        }
    }

    public static void b(Throwable th, String str, String str2) {
        if (es.a != null) {
            es.a.a(th, 1, str, str2);
        }
    }

    protected final void a(Context context, ep epVar, boolean z) {
        try {
            ExecutorService b = b();
            if (b != null && !b.isShutdown()) {
                b.submit(new ey(this, context, epVar, z));
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
        }
    }

    protected final void a(ep epVar, String str, String str2) {
        ew.a(this.d, epVar, str, str2);
    }

    protected final void a(Throwable th, int i, String str, String str2) {
        ew.a(this.d, th, i, str, str2);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            a(th, 0, null, null);
            if (this.b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.b);
                } catch (Throwable th2) {
                }
                this.b.uncaughtException(thread, th);
            }
        }
    }
}
