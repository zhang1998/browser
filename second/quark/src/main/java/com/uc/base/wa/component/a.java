package com.uc.base.wa.component;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ h a;

    a(h hVar) {
        this.a = hVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r9 = this;
        r8 = 4;
        r2 = 3;
        r7 = 1;
        r0 = r9.a;
        r0 = r0.b;
        r0.lock();
        r3 = r9.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r4 = r3.a();	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r4 == 0) goto L_0x0094;
    L_0x0012:
        r0 = r4.size();	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r0 <= 0) goto L_0x0094;
    L_0x0018:
        r5 = r4.iterator();	 Catch:{ Exception -> 0x0046, all -> 0x005e }
    L_0x001c:
        r0 = r5.hasNext();	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r0 == 0) goto L_0x0094;
    L_0x0022:
        r0 = r5.next();	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r0 = (com.uc.base.wa.component.b) r0;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r1 = r2;
    L_0x0029:
        if (r1 <= 0) goto L_0x001c;
    L_0x002b:
        r6 = r0.b;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        switch(r6) {
            case 0: goto L_0x0037;
            case 1: goto L_0x0076;
            default: goto L_0x0030;
        };	 Catch:{ Exception -> 0x0046, all -> 0x005e }
    L_0x0030:
        r6 = r0.c;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r6 != 0) goto L_0x001c;
    L_0x0034:
        r1 = r1 + -1;
        goto L_0x0029;
    L_0x0037:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r6.c;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r7 != r6) goto L_0x004f;
    L_0x003d:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r3.a(r6);	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r0.c = r6;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        goto L_0x0030;
    L_0x0046:
        r0 = move-exception;
        r0 = r9.a;
        r0 = r0.b;
        r0.unlock();
    L_0x004e:
        return;
    L_0x004f:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r6.c;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r8 != r6) goto L_0x0067;
    L_0x0055:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r3.a(r6);	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r0.c = r6;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        goto L_0x0030;
    L_0x005e:
        r0 = move-exception;
        r1 = r9.a;
        r1 = r1.b;
        r1.unlock();
        throw r0;
    L_0x0067:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r6.c;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r2 != r6) goto L_0x0030;
    L_0x006d:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r3.a(r6);	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r0.c = r6;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        goto L_0x0030;
    L_0x0076:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r6.c;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r7 != r6) goto L_0x0085;
    L_0x007c:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r3.b(r6);	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r0.c = r6;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        goto L_0x0030;
    L_0x0085:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r6.c;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        if (r8 != r6) goto L_0x0030;
    L_0x008b:
        r6 = r0.a;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r6 = r3.b(r6);	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        r0.c = r6;	 Catch:{ Exception -> 0x0046, all -> 0x005e }
        goto L_0x0030;
    L_0x0094:
        r0 = r9.a;
        r0 = r0.b;
        r0.unlock();
        if (r4 == 0) goto L_0x004e;
    L_0x009d:
        r3 = r4.iterator();
    L_0x00a1:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x004e;
    L_0x00a7:
        r0 = r3.next();
        r1 = r0;
        r1 = (com.uc.base.wa.component.b) r1;
        r0 = r1.d;
        r4 = r0.iterator();
    L_0x00b4:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00a1;
    L_0x00ba:
        r0 = r4.next();
        r0 = (com.uc.base.wa.component.d) r0;
        r5 = r1.c;
        r2 = r0.a;
        if (r2 == 0) goto L_0x00d6;
    L_0x00c6:
        r2 = new android.os.Handler;
        r6 = r0.a;
        r2.<init>(r6);
    L_0x00cd:
        r6 = new com.uc.base.wa.component.c;
        r6.<init>(r0, r5);
        r2.post(r6);
        goto L_0x00b4;
    L_0x00d6:
        r2 = new android.os.Handler;
        r6 = android.os.Looper.getMainLooper();
        r2.<init>(r6);
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.component.a.run():void");
    }
}
