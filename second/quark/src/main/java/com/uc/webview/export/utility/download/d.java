package com.uc.webview.export.utility.download;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ DownloadTask c;
    final /* synthetic */ ValueCallback d;
    final /* synthetic */ ValueCallback e;
    final /* synthetic */ ValueCallback f;
    final /* synthetic */ ValueCallback g;
    final /* synthetic */ ValueCallback h;
    final /* synthetic */ UpdateTask i;

    d(UpdateTask updateTask, ValueCallback valueCallback, String str, DownloadTask downloadTask, ValueCallback valueCallback2, ValueCallback valueCallback3, ValueCallback valueCallback4, ValueCallback valueCallback5, ValueCallback valueCallback6) {
        this.i = updateTask;
        this.a = valueCallback;
        this.b = str;
        this.c = downloadTask;
        this.d = valueCallback2;
        this.e = valueCallback3;
        this.f = valueCallback4;
        this.g = valueCallback5;
        this.h = valueCallback6;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r13 = this;
        r12 = 1;
        r0 = r13.a;	 Catch:{ Throwable -> 0x018f }
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = r13.a;	 Catch:{ Throwable -> 0x018f }
        r1 = r13.i;	 Catch:{ Throwable -> 0x018f }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x018f }
    L_0x000c:
        r0 = r13.i;	 Catch:{ Throwable -> 0x018c }
        r0 = r0.i;	 Catch:{ Throwable -> 0x018c }
        if (r0 == 0) goto L_0x0028;
    L_0x0014:
        r0 = r13.i;	 Catch:{ Throwable -> 0x018c }
        r0 = r0.i;	 Catch:{ Throwable -> 0x018c }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x018c }
        r2 = 0;
        r3 = 3;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x018c }
        r1[r2] = r3;	 Catch:{ Throwable -> 0x018c }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x018c }
    L_0x0028:
        r0 = r13.b;	 Catch:{ Throwable -> 0x0149 }
        r0 = r0.toLowerCase();	 Catch:{ Throwable -> 0x0149 }
        r1 = ".7z";
        r0 = r0.endsWith(r1);	 Catch:{ Throwable -> 0x0149 }
        if (r0 != 0) goto L_0x0091;
    L_0x0036:
        r0 = r13.c;	 Catch:{ Throwable -> 0x0149 }
        r2 = r0.getFilePath();	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.i;	 Catch:{ Throwable -> 0x0149 }
        r0 = r0.e;	 Catch:{ Throwable -> 0x0149 }
        r1 = 0;
        r0 = r0[r1];	 Catch:{ Throwable -> 0x0149 }
        r0 = (android.content.Context) r0;	 Catch:{ Throwable -> 0x0149 }
        r1 = r13.i;	 Catch:{ Throwable -> 0x0149 }
        r1 = r1.e;	 Catch:{ Throwable -> 0x0149 }
        r3 = 0;
        r1 = r1[r3];	 Catch:{ Throwable -> 0x0149 }
        r1 = (android.content.Context) r1;	 Catch:{ Throwable -> 0x0149 }
        r3 = "com.UCMobile";
        r4 = r13.i;	 Catch:{ Throwable -> 0x0149 }
        r4 = r4.i;	 Catch:{ Throwable -> 0x0149 }
        r0 = com.uc.webview.export.internal.utility.c.a(r2, r0, r1, r3, r4);	 Catch:{ Throwable -> 0x0149 }
        if (r0 != 0) goto L_0x0086;
    L_0x0060:
        r0 = "sdk_dec7z_ls";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r0);	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.c;	 Catch:{ Throwable -> 0x0149 }
        r0.delete();	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.i;	 Catch:{ Throwable -> 0x0149 }
        r0 = r0.e;	 Catch:{ Throwable -> 0x0149 }
        r1 = 1;
        r2 = new java.lang.RuntimeException;	 Catch:{ Throwable -> 0x0149 }
        r3 = "Archive verify failed.";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0149 }
        r0[r1] = r2;	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.d;	 Catch:{ Throwable -> 0x0189 }
        if (r0 == 0) goto L_0x0085;
    L_0x007e:
        r0 = r13.d;	 Catch:{ Throwable -> 0x0189 }
        r1 = r13.i;	 Catch:{ Throwable -> 0x0189 }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x0189 }
    L_0x0085:
        return;
    L_0x0086:
        r0 = r13.a;	 Catch:{ Throwable -> 0x0186 }
        if (r0 == 0) goto L_0x0091;
    L_0x008a:
        r0 = r13.a;	 Catch:{ Throwable -> 0x0186 }
        r1 = r13.i;	 Catch:{ Throwable -> 0x0186 }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x0186 }
    L_0x0091:
        r0 = r13.i;	 Catch:{ Throwable -> 0x0149 }
        r9 = r0.getUpdateDir();	 Catch:{ Throwable -> 0x0149 }
        com.uc.webview.export.cyclone.UCCyclone.expectCreateDirFile(r9);	 Catch:{ Throwable -> 0x0149 }
        new java.io.File(r9, com.uc.webview.export.utility.download.UpdateTask.STOP_FLG_FILE_NAME).delete();	 Catch:{ Throwable -> 0x0149 }
        r0 = 0;
        com.uc.webview.export.utility.download.UpdateTask.a(r9, r0);	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.e;	 Catch:{ Throwable -> 0x0183, Exception -> 0x0117 }
        if (r0 == 0) goto L_0x00ac;
    L_0x00a5:
        r0 = r13.e;	 Catch:{ Throwable -> 0x0183, Exception -> 0x0117 }
        r1 = r13.i;	 Catch:{ Throwable -> 0x0183, Exception -> 0x0117 }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x0183, Exception -> 0x0117 }
    L_0x00ac:
        r0 = r13.i;	 Catch:{ Exception -> 0x0117 }
        r0 = r0.e;	 Catch:{ Exception -> 0x0117 }
        r1 = 0;
        r1 = r0[r1];	 Catch:{ Exception -> 0x0117 }
        r1 = (android.content.Context) r1;	 Catch:{ Exception -> 0x0117 }
        r0 = r13.b;	 Catch:{ Exception -> 0x0117 }
        r2 = ".7z";
        r2 = r0.endsWith(r2);	 Catch:{ Exception -> 0x0117 }
        r3 = r13.b;	 Catch:{ Exception -> 0x0117 }
        r0 = r13.i;	 Catch:{ Exception -> 0x0117 }
        r0 = r0.c;	 Catch:{ Exception -> 0x0117 }
        r4 = 1;
        r4 = r0[r4];	 Catch:{ Exception -> 0x0117 }
        r0 = r13.i;	 Catch:{ Exception -> 0x0117 }
        r0 = r0.c;	 Catch:{ Exception -> 0x0117 }
        r6 = 2;
        r6 = r0[r6];	 Catch:{ Exception -> 0x0117 }
        r8 = new java.io.File;	 Catch:{ Exception -> 0x0117 }
        r0 = r13.c;	 Catch:{ Exception -> 0x0117 }
        r0 = r0.getFilePath();	 Catch:{ Exception -> 0x0117 }
        r8.<init>(r0);	 Catch:{ Exception -> 0x0117 }
        r10 = 0;
        r11 = 0;
        com.uc.webview.export.cyclone.UCCyclone.decompressIfNeeded(r1, r2, r3, r4, r6, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0117 }
        r0 = r13.f;	 Catch:{ Throwable -> 0x0180, Exception -> 0x0117 }
        if (r0 == 0) goto L_0x00ee;
    L_0x00e7:
        r0 = r13.f;	 Catch:{ Throwable -> 0x0180, Exception -> 0x0117 }
        r1 = r13.i;	 Catch:{ Throwable -> 0x0180, Exception -> 0x0117 }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x0180, Exception -> 0x0117 }
    L_0x00ee:
        r0 = 1;
        com.uc.webview.export.utility.download.UpdateTask.a(r9, r0);	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.c;	 Catch:{ Throwable -> 0x0149 }
        r0.delete();	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.a;	 Catch:{ Throwable -> 0x017c }
        if (r0 == 0) goto L_0x0102;
    L_0x00fb:
        r0 = r13.a;	 Catch:{ Throwable -> 0x017c }
        r1 = r13.i;	 Catch:{ Throwable -> 0x017c }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x017c }
    L_0x0102:
        r0 = "sdk_ucm_s";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r0);	 Catch:{ Throwable -> 0x0149 }
        r0 = r13.g;	 Catch:{ Throwable -> 0x0114 }
        if (r0 == 0) goto L_0x0085;
    L_0x010b:
        r0 = r13.g;	 Catch:{ Throwable -> 0x0114 }
        r1 = r13.i;	 Catch:{ Throwable -> 0x0114 }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x0114 }
        goto L_0x0085;
    L_0x0114:
        r0 = move-exception;
        goto L_0x0085;
    L_0x0117:
        r0 = move-exception;
        r1 = r13.i;	 Catch:{ Throwable -> 0x017e }
        r1 = r1.i;	 Catch:{ Throwable -> 0x017e }
        if (r1 == 0) goto L_0x0148;
    L_0x0120:
        r1 = r13.i;	 Catch:{ Throwable -> 0x017e }
        r1 = r1.i;	 Catch:{ Throwable -> 0x017e }
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x017e }
        r3 = 0;
        r4 = 9;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x017e }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x017e }
        r3 = 1;
        r4 = r0.getClass();	 Catch:{ Throwable -> 0x017e }
        r4 = r4.getName();	 Catch:{ Throwable -> 0x017e }
        r4 = r4.hashCode();	 Catch:{ Throwable -> 0x017e }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x017e }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x017e }
        r1.onReceiveValue(r2);	 Catch:{ Throwable -> 0x017e }
    L_0x0148:
        throw r0;	 Catch:{ Throwable -> 0x0149 }
    L_0x0149:
        r0 = move-exception;
        r1 = "sdk_dec7z";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r1);
        r1 = r0.getClass();
        r1 = r1.getName();
        r1 = r1.hashCode();
        r2 = "sdk_ucm_le";
        r1 = java.lang.String.valueOf(r1);
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r2, r1);
        r1 = r13.i;
        r1 = r1.e;
        r1[r12] = r0;
        r0 = r13.h;	 Catch:{ Throwable -> 0x0179 }
        if (r0 == 0) goto L_0x0085;
    L_0x0170:
        r0 = r13.h;	 Catch:{ Throwable -> 0x0179 }
        r1 = r13.i;	 Catch:{ Throwable -> 0x0179 }
        r0.onReceiveValue(r1);	 Catch:{ Throwable -> 0x0179 }
        goto L_0x0085;
    L_0x0179:
        r0 = move-exception;
        goto L_0x0085;
    L_0x017c:
        r0 = move-exception;
        goto L_0x0102;
    L_0x017e:
        r1 = move-exception;
        goto L_0x0148;
    L_0x0180:
        r0 = move-exception;
        goto L_0x00ee;
    L_0x0183:
        r0 = move-exception;
        goto L_0x00ac;
    L_0x0186:
        r0 = move-exception;
        goto L_0x0091;
    L_0x0189:
        r0 = move-exception;
        goto L_0x0085;
    L_0x018c:
        r0 = move-exception;
        goto L_0x0028;
    L_0x018f:
        r0 = move-exception;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.utility.download.d.run():void");
    }
}
