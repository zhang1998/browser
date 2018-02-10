package com.uc.webview.export.internal.setup;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
final class bh extends Handler {
    final /* synthetic */ bg a;
    private UCAsyncTask b = null;

    bh(bg bgVar, Looper looper) {
        this.a = bgVar;
        super(looper);
    }

    private static void a(UCAsyncTask uCAsyncTask) {
        if (uCAsyncTask != null) {
            synchronized (uCAsyncTask.d) {
                uCAsyncTask.mPercent = (int) ((100.0f * ((float) UCAsyncTask.e(uCAsyncTask))) / ((float) ((Integer) uCAsyncTask.invokeO(UCAsyncTask.getTaskCount, new Object[0])).intValue()));
            }
            uCAsyncTask.callback("progress");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchMessage(android.os.Message r12) {
        /*
        r11 = this;
        r4 = 1;
        r1 = 0;
        r5 = 0;
        r0 = com.uc.webview.export.internal.setup.UCAsyncTask.n;	 Catch:{ Throwable -> 0x0124 }
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x0124 }
        if (r0 == 0) goto L_0x01d4;
    L_0x000d:
        r0 = new com.uc.webview.export.cyclone.UCElapseTime;	 Catch:{ Throwable -> 0x0124 }
        r0.<init>();	 Catch:{ Throwable -> 0x0124 }
    L_0x0012:
        r6 = r0;
    L_0x0013:
        r0 = r12.getCallback();	 Catch:{ Throwable -> 0x012b }
        r2 = r0 instanceof com.uc.webview.export.internal.setup.UCAsyncTask;	 Catch:{ Throwable -> 0x012b }
        if (r2 == 0) goto L_0x0040;
    L_0x001b:
        r0 = (com.uc.webview.export.internal.setup.UCAsyncTask) r0;	 Catch:{ Throwable -> 0x012b }
        r11.b = r0;	 Catch:{ Throwable -> 0x012b }
        r0 = r11.b;	 Catch:{ Throwable -> 0x012b }
        r2 = r0.l;	 Catch:{ Throwable -> 0x012b }
        r8 = 0;
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0039;
    L_0x002b:
        r0 = r11.b;	 Catch:{ Throwable -> 0x01ce }
        r2 = r0.l;	 Catch:{ Throwable -> 0x01ce }
        java.lang.Thread.sleep(r2);	 Catch:{ Throwable -> 0x01ce }
    L_0x0034:
        r0 = r11.b;	 Catch:{ Throwable -> 0x012b }
        r0.l = 0;	 Catch:{ Throwable -> 0x012b }
    L_0x0039:
        r0 = r11.b;	 Catch:{ Throwable -> 0x012b }
        r2 = "start";
        r0.callback(r2);	 Catch:{ Throwable -> 0x012b }
    L_0x0040:
        r0 = r11.b;	 Catch:{ Throwable -> 0x012b }
        r2 = r0.h;	 Catch:{ Throwable -> 0x012b }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x012b }
        r0 = r11.b;	 Catch:{ all -> 0x0128 }
        r0 = r0.g;	 Catch:{ all -> 0x0128 }
        if (r0 == 0) goto L_0x0050;
    L_0x004f:
        r12 = r1;
    L_0x0050:
        monitor-exit(r2);	 Catch:{ all -> 0x0128 }
        if (r12 == 0) goto L_0x008a;
    L_0x0053:
        r0 = r11.b;	 Catch:{ Throwable -> 0x012b }
        r2 = r11.a;	 Catch:{ Throwable -> 0x012b }
        r2 = r2.a;	 Catch:{ Throwable -> 0x012b }
        r2 = r2.h;	 Catch:{ Throwable -> 0x012b }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x012b }
        r3 = r11.a;	 Catch:{ all -> 0x0151 }
        r3 = r3.a;	 Catch:{ all -> 0x0151 }
        r3 = r3.f;	 Catch:{ all -> 0x0151 }
        if (r3 == 0) goto L_0x0089;
    L_0x0068:
        r3 = r11.a;	 Catch:{ all -> 0x0151 }
        r3 = r3.a;	 Catch:{ all -> 0x0151 }
        r3.f = false;	 Catch:{ all -> 0x0151 }
        r3 = "pause";
        r0.callback(r3);	 Catch:{ all -> 0x0151 }
        r3 = r11.a;	 Catch:{ all -> 0x0151 }
        r3 = r3.a;	 Catch:{ all -> 0x0151 }
        r3 = r3.h;	 Catch:{ all -> 0x0151 }
        r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r3.a(r8);	 Catch:{ all -> 0x0151 }
        r3 = "resume";
        r0.callback(r3);	 Catch:{ all -> 0x0151 }
    L_0x0089:
        monitor-exit(r2);	 Catch:{ all -> 0x0151 }
    L_0x008a:
        if (r12 == 0) goto L_0x009a;
    L_0x008c:
        r0 = r11.b;	 Catch:{ Throwable -> 0x012b }
        r0 = r0.mException;	 Catch:{ Throwable -> 0x012b }
        if (r0 != 0) goto L_0x009a;
    L_0x0092:
        super.dispatchMessage(r12);	 Catch:{ Throwable -> 0x012b }
        r0 = r11.b;	 Catch:{ Throwable -> 0x012b }
        a(r0);	 Catch:{ Throwable -> 0x012b }
    L_0x009a:
        r0 = com.uc.webview.export.internal.setup.UCAsyncTask.n;	 Catch:{ Throwable -> 0x015b }
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x015b }
        if (r0 == 0) goto L_0x01d1;
    L_0x00a4:
        r0 = r11.b;	 Catch:{ Throwable -> 0x015b }
    L_0x00a6:
        r2 = r0;
    L_0x00a7:
        r0 = r11.b;
        r7 = r0.d;
        monitor-enter(r7);
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r0 = r0.mException;	 Catch:{ all -> 0x01a6 }
        if (r0 == 0) goto L_0x015f;
    L_0x00b4:
        r3 = r4;
    L_0x00b5:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r8 = r0.g;	 Catch:{ all -> 0x01a6 }
        if (r3 != 0) goto L_0x00bf;
    L_0x00bd:
        if (r8 == 0) goto L_0x00c9;
    L_0x00bf:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r9 = 10012; // 0x271c float:1.403E-41 double:4.9466E-320;
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x01a6 }
        r0.invoke(r9, r10);	 Catch:{ all -> 0x01a6 }
    L_0x00c9:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r0 = r0.b;	 Catch:{ all -> 0x01a6 }
        if (r0 == 0) goto L_0x0163;
    L_0x00d1:
        r0 = r0.poll();	 Catch:{ Throwable -> 0x0188 }
        r0 = (java.lang.Runnable) r0;	 Catch:{ Throwable -> 0x0188 }
        if (r0 == 0) goto L_0x0162;
    L_0x00d9:
        monitor-exit(r7);	 Catch:{ all -> 0x01a6 }
    L_0x00da:
        if (r0 == 0) goto L_0x01b4;
    L_0x00dc:
        r1 = r11.a;
        r1 = r1.a;
        r1 = r1.j;
        r1.post(r0);
    L_0x00e7:
        r0 = com.uc.webview.export.internal.setup.UCAsyncTask.n;	 Catch:{ Throwable -> 0x01cb }
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x01cb }
        if (r0 == 0) goto L_0x0123;
    L_0x00f1:
        r0 = r11.a;	 Catch:{ Throwable -> 0x01cb }
        r0 = r0.a;	 Catch:{ Throwable -> 0x01cb }
        r1 = r0.o;	 Catch:{ Throwable -> 0x01cb }
        r3 = new android.util.Pair;	 Catch:{ Throwable -> 0x01cb }
        if (r2 != 0) goto L_0x01c1;
    L_0x00fd:
        r0 = "null";
    L_0x00ff:
        r2 = new android.util.Pair;	 Catch:{ Throwable -> 0x01cb }
        r4 = r6.getMilis();	 Catch:{ Throwable -> 0x01cb }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x01cb }
        r6 = r6.getMilisCpu();	 Catch:{ Throwable -> 0x01cb }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x01cb }
        r2.<init>(r4, r5);	 Catch:{ Throwable -> 0x01cb }
        r3.<init>(r0, r2);	 Catch:{ Throwable -> 0x01cb }
        r1.add(r3);	 Catch:{ Throwable -> 0x01cb }
        r0 = r11.a;	 Catch:{ Throwable -> 0x01cb }
        r0 = r0.a;	 Catch:{ Throwable -> 0x01cb }
        r1 = "cost";
        r0.callback(r1);	 Catch:{ Throwable -> 0x01cb }
    L_0x0123:
        return;
    L_0x0124:
        r0 = move-exception;
        r6 = r1;
        goto L_0x0013;
    L_0x0128:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0128 }
        throw r0;	 Catch:{ Throwable -> 0x012b }
    L_0x012b:
        r0 = move-exception;
        r3 = r11.b;
        r2 = r0 instanceof com.uc.webview.export.internal.setup.UCSetupException;
        if (r2 == 0) goto L_0x0154;
    L_0x0132:
        r0 = (com.uc.webview.export.internal.setup.UCSetupException) r0;
    L_0x0134:
        r3.setException(r0);
        r0 = r11.b;	 Catch:{ Throwable -> 0x014e }
        r2 = r0.d;	 Catch:{ Throwable -> 0x014e }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x014e }
        r0 = r11.b;	 Catch:{ all -> 0x014b }
        r3 = 10012; // 0x271c float:1.403E-41 double:4.9466E-320;
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x014b }
        r0.invoke(r3, r7);	 Catch:{ all -> 0x014b }
        monitor-exit(r2);	 Catch:{ all -> 0x014b }
        goto L_0x009a;
    L_0x014b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x014b }
        throw r0;	 Catch:{ Throwable -> 0x014e }
    L_0x014e:
        r0 = move-exception;
        goto L_0x009a;
    L_0x0151:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0151 }
        throw r0;	 Catch:{ Throwable -> 0x012b }
    L_0x0154:
        r2 = new com.uc.webview.export.internal.setup.UCSetupException;
        r2.<init>(r0);
        r0 = r2;
        goto L_0x0134;
    L_0x015b:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00a7;
    L_0x015f:
        r3 = r5;
        goto L_0x00b5;
    L_0x0162:
        r1 = r0;
    L_0x0163:
        if (r8 == 0) goto L_0x0195;
    L_0x0165:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r3 = "stop";
        r0.callback(r3);	 Catch:{ all -> 0x01a6 }
    L_0x016c:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r3 = "die";
        r0.callback(r3);	 Catch:{ all -> 0x01a6 }
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r0 = r0.a;	 Catch:{ all -> 0x01a6 }
        r11.b = r0;	 Catch:{ all -> 0x01a6 }
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        a(r0);	 Catch:{ all -> 0x01a6 }
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        if (r0 != 0) goto L_0x01b1;
    L_0x0184:
        monitor-exit(r7);	 Catch:{ all -> 0x01a6 }
        r0 = r1;
        goto L_0x00da;
    L_0x0188:
        r0 = move-exception;
        r3 = r11.b;	 Catch:{ all -> 0x01a6 }
        r9 = new com.uc.webview.export.internal.setup.UCSetupException;	 Catch:{ all -> 0x01a6 }
        r9.<init>(r0);	 Catch:{ all -> 0x01a6 }
        r3.setException(r9);	 Catch:{ all -> 0x01a6 }
        r3 = r4;
        goto L_0x0163;
    L_0x0195:
        if (r3 == 0) goto L_0x01a9;
    L_0x0197:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r3 = "exception";
        r0.callback(r3);	 Catch:{ all -> 0x01a6 }
    L_0x019e:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r3 = "gone";
        r0.callback(r3);	 Catch:{ all -> 0x01a6 }
        goto L_0x016c;
    L_0x01a6:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x01a6 }
        throw r0;
    L_0x01a9:
        r0 = r11.b;	 Catch:{ all -> 0x01a6 }
        r3 = "success";
        r0.callback(r3);	 Catch:{ all -> 0x01a6 }
        goto L_0x019e;
    L_0x01b1:
        monitor-exit(r7);	 Catch:{ all -> 0x01a6 }
        goto L_0x00a7;
    L_0x01b4:
        r0 = r11.a;
        r0 = r0.a;
        r1 = 10008; // 0x2718 float:1.4024E-41 double:4.9446E-320;
        r3 = new java.lang.Object[r5];
        r0.invokeO(r1, r3);
        goto L_0x00e7;
    L_0x01c1:
        r0 = r2.getClass();	 Catch:{ Throwable -> 0x01cb }
        r0 = r0.getSimpleName();	 Catch:{ Throwable -> 0x01cb }
        goto L_0x00ff;
    L_0x01cb:
        r0 = move-exception;
        goto L_0x0123;
    L_0x01ce:
        r0 = move-exception;
        goto L_0x0034;
    L_0x01d1:
        r0 = r1;
        goto L_0x00a6;
    L_0x01d4:
        r0 = r1;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.bh.dispatchMessage(android.os.Message):void");
    }
}
