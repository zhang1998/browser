package com.loc;

import android.os.HandlerThread;

/* compiled from: ProGuard */
final class cm extends HandlerThread {
    final /* synthetic */ cn a;

    public cm(cn cnVar, String str) {
        this.a = cnVar;
        super(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void onLooperPrepared() {
        /*
        r6 = this;
        super.onLooperPrepared();	 Catch:{ Throwable -> 0x0058 }
        r0 = r6.a;	 Catch:{ Throwable -> 0x0058 }
        r1 = r0.l;	 Catch:{ Throwable -> 0x0058 }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x0058 }
        r0 = r6.a;	 Catch:{ all -> 0x0055 }
        r0 = r0.k;	 Catch:{ all -> 0x0055 }
        if (r0 != 0) goto L_0x0039;
    L_0x000e:
        r2 = r6.a;	 Catch:{ all -> 0x0055 }
        r0 = new com.loc.cl;	 Catch:{ all -> 0x0055 }
        r0.<init>(r2);	 Catch:{ all -> 0x0055 }
        r2.h = r0;	 Catch:{ all -> 0x0055 }
        r3 = "android.telephony.PhoneStateListener";
        r0 = 0;
        r4 = com.loc.dm.c();	 Catch:{ all -> 0x0055 }
        r5 = 7;
        if (r4 >= r5) goto L_0x003b;
    L_0x0021:
        r4 = "LISTEN_SIGNAL_STRENGTH";
        r0 = com.loc.dg.b(r3, r4);	 Catch:{ Throwable -> 0x0084 }
    L_0x0027:
        if (r0 != 0) goto L_0x0042;
    L_0x0029:
        r0 = r2.e;	 Catch:{ all -> 0x0055 }
        r3 = r2.h;	 Catch:{ all -> 0x0055 }
        r4 = 16;
        r0.listen(r3, r4);	 Catch:{ all -> 0x0055 }
    L_0x0032:
        r0 = com.loc.cn.e();	 Catch:{ Throwable -> 0x0065 }
        switch(r0) {
            case 0: goto L_0x0079;
            case 1: goto L_0x005a;
            case 2: goto L_0x006e;
            default: goto L_0x0039;
        };
    L_0x0039:
        monitor-exit(r1);	 Catch:{ all -> 0x0055 }
    L_0x003a:
        return;
    L_0x003b:
        r4 = "LISTEN_SIGNAL_STRENGTHS";
        r0 = com.loc.dg.b(r3, r4);	 Catch:{ Throwable -> 0x0086 }
        goto L_0x0027;
    L_0x0042:
        r3 = r2.e;	 Catch:{ Throwable -> 0x004c }
        r4 = r2.h;	 Catch:{ Throwable -> 0x004c }
        r0 = r0 | 16;
        r3.listen(r4, r0);	 Catch:{ Throwable -> 0x004c }
        goto L_0x0032;
    L_0x004c:
        r0 = move-exception;
        r3 = "CgiManager";
        r4 = "initPhoneStateListener1";
        com.loc.cq.a(r0, r3, r4);	 Catch:{ all -> 0x0055 }
        goto L_0x0032;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0055 }
        throw r0;	 Catch:{ Throwable -> 0x0058 }
    L_0x0058:
        r0 = move-exception;
        goto L_0x003a;
    L_0x005a:
        r0 = r2.a;	 Catch:{ Throwable -> 0x0065 }
        r3 = "phone_msim";
        r0 = com.loc.dm.a(r0, r3);	 Catch:{ Throwable -> 0x0065 }
        r2.f = r0;	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0039;
    L_0x0065:
        r0 = move-exception;
        r2 = "CgiManager";
        r3 = "initPhoneStateListener";
        com.loc.cq.a(r0, r2, r3);	 Catch:{ all -> 0x0055 }
        goto L_0x0039;
    L_0x006e:
        r0 = r2.a;	 Catch:{ Throwable -> 0x0065 }
        r3 = "phone2";
        r0 = com.loc.dm.a(r0, r3);	 Catch:{ Throwable -> 0x0065 }
        r2.f = r0;	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0039;
    L_0x0079:
        r0 = r2.a;	 Catch:{ Throwable -> 0x0065 }
        r3 = "phone2";
        r0 = com.loc.dm.a(r0, r3);	 Catch:{ Throwable -> 0x0065 }
        r2.f = r0;	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0039;
    L_0x0084:
        r3 = move-exception;
        goto L_0x0027;
    L_0x0086:
        r3 = move-exception;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cm.onLooperPrepared():void");
    }

    public final void run() {
        try {
            super.run();
        } catch (Throwable th) {
        }
    }
}
