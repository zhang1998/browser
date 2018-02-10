package com.uc.quark.filedownloader;

import android.os.Handler;
import android.os.Looper;
import com.uc.quark.filedownloader.e.f;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ProGuard */
public final class ao {
    static int d = 10;
    static int e = 5;
    final Executor a;
    final LinkedBlockingQueue<h> b;
    volatile Object c;
    private final Handler f;
    private final ArrayList<h> g;

    public static ao a() {
        return b.a;
    }

    private ao() {
        this.a = f.a(5, "BlockCompleted");
        this.c = new Object();
        this.g = new ArrayList();
        this.f = new Handler(Looper.getMainLooper(), new ab());
        this.b = new LinkedBlockingQueue();
    }

    final void a(h hVar) {
        this.f.sendMessage(this.f.obtainMessage(1, hVar));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void b() {
        /*
        r6 = this;
        r0 = 0;
        r2 = r6.c;
        monitor-enter(r2);
        r1 = r6.g;	 Catch:{ all -> 0x0018 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0018 }
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
    L_0x000d:
        return;
    L_0x000e:
        r1 = r6.b;	 Catch:{ all -> 0x0018 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0018 }
        if (r1 == 0) goto L_0x001b;
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        goto L_0x000d;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        r1 = c();	 Catch:{ all -> 0x0018 }
        if (r1 != 0) goto L_0x0039;
    L_0x0021:
        r1 = r6.b;	 Catch:{ all -> 0x0018 }
        r3 = r6.g;	 Catch:{ all -> 0x0018 }
        r1.drainTo(r3);	 Catch:{ all -> 0x0018 }
    L_0x0028:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        r1 = r6.f;
        r2 = r6.f;
        r3 = 2;
        r4 = r6.g;
        r2 = r2.obtainMessage(r3, r4);
        r4 = (long) r0;
        r1.sendMessageDelayed(r2, r4);
        goto L_0x000d;
    L_0x0039:
        r1 = d;	 Catch:{ all -> 0x0018 }
        r3 = r6.b;	 Catch:{ all -> 0x0018 }
        r3 = r3.size();	 Catch:{ all -> 0x0018 }
        r4 = e;	 Catch:{ all -> 0x0018 }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ all -> 0x0018 }
    L_0x0047:
        if (r0 >= r3) goto L_0x0057;
    L_0x0049:
        r4 = r6.g;	 Catch:{ all -> 0x0018 }
        r5 = r6.b;	 Catch:{ all -> 0x0018 }
        r5 = r5.remove();	 Catch:{ all -> 0x0018 }
        r4.add(r5);	 Catch:{ all -> 0x0018 }
        r0 = r0 + 1;
        goto L_0x0047;
    L_0x0057:
        r0 = r1;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.ao.b():void");
    }

    static boolean c() {
        return d > 0;
    }
}
