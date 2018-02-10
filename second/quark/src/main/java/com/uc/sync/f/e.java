package com.uc.sync.f;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class e extends Handler {
    private WeakReference<h> a;

    public e(Looper looper, h hVar) {
        super(looper);
        this.a = new WeakReference(hVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r7) {
        /*
        r6 = this;
        r0 = r6.a;
        r0 = r0.get();
        r0 = (com.uc.sync.f.h) r0;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r1 = r7.what;
        switch(r1) {
            case 65537: goto L_0x0011;
            default: goto L_0x0010;
        };
    L_0x0010:
        goto L_0x000a;
    L_0x0011:
        r3 = r0.b;
        monitor-enter(r3);
        r1 = r0.b;	 Catch:{ all -> 0x001e }
        r1 = r1.size();	 Catch:{ all -> 0x001e }
        if (r1 != 0) goto L_0x0021;
    L_0x001c:
        monitor-exit(r3);	 Catch:{ all -> 0x001e }
        goto L_0x000a;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x001e }
        throw r0;
    L_0x0021:
        r4 = new android.util.SparseArray;	 Catch:{ all -> 0x001e }
        r4.<init>();	 Catch:{ all -> 0x001e }
        r1 = 0;
        r2 = r1;
    L_0x0028:
        r1 = r0.b;	 Catch:{ all -> 0x001e }
        r1 = r1.size();	 Catch:{ all -> 0x001e }
        if (r2 >= r1) goto L_0x004b;
    L_0x0030:
        r1 = r0.b;	 Catch:{ all -> 0x001e }
        r1 = r1.keyAt(r2);	 Catch:{ all -> 0x001e }
        r5 = r0.b;	 Catch:{ all -> 0x001e }
        r1 = r5.get(r1);	 Catch:{ all -> 0x001e }
        r1 = (com.uc.sync.f.o) r1;	 Catch:{ all -> 0x001e }
        r5 = r1.c;	 Catch:{ all -> 0x001e }
        if (r5 != 0) goto L_0x0047;
    L_0x0042:
        r5 = r1.a;	 Catch:{ all -> 0x001e }
        r4.put(r5, r1);	 Catch:{ all -> 0x001e }
    L_0x0047:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0028;
    L_0x004b:
        r1 = r4.size();	 Catch:{ all -> 0x001e }
        if (r1 <= 0) goto L_0x006b;
    L_0x0051:
        r0.a(r4);	 Catch:{ all -> 0x001e }
        r1 = new com.uc.sync.f.c;	 Catch:{ all -> 0x001e }
        r1.<init>(r4);	 Catch:{ all -> 0x001e }
        r0 = r0.d;	 Catch:{ all -> 0x001e }
        r2 = r0.a;	 Catch:{ all -> 0x001e }
        monitor-enter(r2);	 Catch:{ all -> 0x001e }
        r4 = r0.a;	 Catch:{ all -> 0x006d }
        r4.add(r1);	 Catch:{ all -> 0x006d }
        monitor-exit(r2);	 Catch:{ all -> 0x006d }
        r1 = r0.b;	 Catch:{ all -> 0x001e }
        if (r1 != 0) goto L_0x006b;
    L_0x0068:
        r0.a();	 Catch:{ all -> 0x001e }
    L_0x006b:
        monitor-exit(r3);	 Catch:{ all -> 0x001e }
        goto L_0x000a;
    L_0x006d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006d }
        throw r0;	 Catch:{ all -> 0x001e }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.sync.f.e.handleMessage(android.os.Message):void");
    }
}
