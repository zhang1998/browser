package com.loc;

import android.content.Context;

/* compiled from: ProGuard */
final class ev implements Runnable {
    final /* synthetic */ Context a;

    ev(Context context) {
        this.a = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r2 = 0;
        r0 = 0;
        r5 = com.loc.ew.d(r0);	 Catch:{ RejectedExecutionException -> 0x0141, Throwable -> 0x0111, all -> 0x012c }
        r0 = 1;
        r4 = com.loc.ew.d(r0);	 Catch:{ RejectedExecutionException -> 0x0146, Throwable -> 0x0138, all -> 0x0131 }
        r0 = 2;
        r3 = com.loc.ew.d(r0);	 Catch:{ RejectedExecutionException -> 0x014b, Throwable -> 0x013c, all -> 0x0135 }
        r0 = r10.a;	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r5.b(r0);	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r0 = r10.a;	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r4.b(r0);	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r0 = r10.a;	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r3.b(r0);	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r0 = r10.a;	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        com.loc.bw.a(r0);	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r6 = r10.a;	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        r0 = com.loc.bt.a(r6);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        if (r0 != 0) goto L_0x003c;
    L_0x002c:
        if (r5 == 0) goto L_0x0031;
    L_0x002e:
        r5.a();
    L_0x0031:
        if (r4 == 0) goto L_0x0036;
    L_0x0033:
        r4.a();
    L_0x0036:
        if (r3 == 0) goto L_0x003b;
    L_0x0038:
        r3.a();
    L_0x003b:
        return;
    L_0x003c:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r0 = "f.log";
        r0 = com.loc.ew.a(r6, r0);	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        r7 = new java.io.File;	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        r7.<init>(r0);	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        r0 = r7.getParentFile();	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        r0 = r0.exists();	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        if (r0 != 0) goto L_0x005c;
    L_0x0055:
        r0 = r7.getParentFile();	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        r0.mkdirs();	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
    L_0x005c:
        r1 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        r1.<init>(r7);	 Catch:{ Throwable -> 0x00ba, all -> 0x00cb }
        r0 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x0154 }
        r0 = com.loc.eq.a(r0);	 Catch:{ Throwable -> 0x0154 }
        r1.write(r0);	 Catch:{ Throwable -> 0x0154 }
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.close();	 Catch:{ Throwable -> 0x00c9, RejectedExecutionException -> 0x00a6 }
    L_0x0071:
        r0 = com.loc.ew.f;	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r0 = com.loc.ew.a(r6, r0);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r0 = com.loc.bt.a(r0);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        if (r1 == 0) goto L_0x00e3;
    L_0x0081:
        r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        if (r0 != 0) goto L_0x002c;
    L_0x0087:
        r0 = com.loc.eq.a(r2);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r0 = com.loc.eq.c(r0);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r1 = new com.loc.ex;	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r2 = "6";
        r1.<init>(r0, r2);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        com.loc.bi.a();	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        com.loc.bi.b(r1);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        goto L_0x002c;
    L_0x009d:
        r0 = move-exception;
        r1 = "OfflineLocManager";
        r2 = "updateOfflineLocData";
        com.loc.es.a(r0, r1, r2);	 Catch:{ RejectedExecutionException -> 0x00a6, Throwable -> 0x013f }
        goto L_0x002c;
    L_0x00a6:
        r0 = move-exception;
        r2 = r3;
        r0 = r4;
        r1 = r5;
    L_0x00aa:
        if (r1 == 0) goto L_0x00af;
    L_0x00ac:
        r1.a();
    L_0x00af:
        if (r0 == 0) goto L_0x00b4;
    L_0x00b1:
        r0.a();
    L_0x00b4:
        if (r2 == 0) goto L_0x003b;
    L_0x00b6:
        r2.a();
        goto L_0x003b;
    L_0x00ba:
        r0 = move-exception;
        r1 = r2;
    L_0x00bc:
        r7 = "OfflineLocManager";
        r8 = "updateLogUpdateTime";
        com.loc.es.a(r0, r7, r8);	 Catch:{ all -> 0x0150 }
        if (r1 == 0) goto L_0x0071;
    L_0x00c5:
        r1.close();	 Catch:{ Throwable -> 0x00c9, RejectedExecutionException -> 0x00a6 }
        goto L_0x0071;
    L_0x00c9:
        r0 = move-exception;
        goto L_0x0071;
    L_0x00cb:
        r0 = move-exception;
    L_0x00cc:
        if (r2 == 0) goto L_0x00d1;
    L_0x00ce:
        r2.close();	 Catch:{ Throwable -> 0x012a, RejectedExecutionException -> 0x00a6 }
    L_0x00d1:
        throw r0;	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
    L_0x00d2:
        r0 = move-exception;
    L_0x00d3:
        if (r5 == 0) goto L_0x00d8;
    L_0x00d5:
        r5.a();
    L_0x00d8:
        if (r4 == 0) goto L_0x00dd;
    L_0x00da:
        r4.a();
    L_0x00dd:
        if (r3 == 0) goto L_0x00e2;
    L_0x00df:
        r3.a();
    L_0x00e2:
        throw r0;
    L_0x00e3:
        r1 = com.loc.bt.b(r6);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r1 = com.loc.eq.a(r1);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r1 = com.loc.eg.a(r6, r1);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r2.<init>();	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r6 = "{\"pinfo\":\"";
        r6 = r2.append(r6);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r1 = r6.append(r1);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r6 = "\",\"els\":[";
        r1.append(r6);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r2.append(r0);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r0 = "]}";
        r2.append(r0);	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009d, RejectedExecutionException -> 0x00a6 }
        goto L_0x0081;
    L_0x0111:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        r5 = r2;
    L_0x0115:
        r1 = "Log";
        r2 = "processLog";
        com.loc.es.a(r0, r1, r2);	 Catch:{ all -> 0x00d2 }
        if (r5 == 0) goto L_0x0121;
    L_0x011e:
        r5.a();
    L_0x0121:
        if (r4 == 0) goto L_0x0126;
    L_0x0123:
        r4.a();
    L_0x0126:
        if (r3 == 0) goto L_0x003b;
    L_0x0128:
        goto L_0x0038;
    L_0x012a:
        r1 = move-exception;
        goto L_0x00d1;
    L_0x012c:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x00d3;
    L_0x0131:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        goto L_0x00d3;
    L_0x0135:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00d3;
    L_0x0138:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
        goto L_0x0115;
    L_0x013c:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0115;
    L_0x013f:
        r0 = move-exception;
        goto L_0x0115;
    L_0x0141:
        r0 = move-exception;
        r0 = r2;
        r1 = r2;
        goto L_0x00aa;
    L_0x0146:
        r0 = move-exception;
        r0 = r2;
        r1 = r5;
        goto L_0x00aa;
    L_0x014b:
        r0 = move-exception;
        r0 = r4;
        r1 = r5;
        goto L_0x00aa;
    L_0x0150:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00cc;
    L_0x0154:
        r0 = move-exception;
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ev.run():void");
    }
}
