package com.uc.webview.export.internal.uc.wa;

/* compiled from: ProGuard */
final class e extends Thread {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r13 = this;
        r0 = r13.a;	 Catch:{ Throwable -> 0x00d3 }
        r0.e();	 Catch:{ Throwable -> 0x00d3 }
        r4 = r13.a;	 Catch:{ Throwable -> 0x00d3 }
        monitor-enter(r4);	 Catch:{ Throwable -> 0x00d3 }
        r0 = r13.a;	 Catch:{ all -> 0x00d0 }
        r0 = r0.j;	 Catch:{ all -> 0x00d0 }
        r1 = "UC_WA_STAT";
        r2 = 4;
        r0 = r0.getSharedPreferences(r1, r2);	 Catch:{ all -> 0x00d0 }
        r1 = com.uc.webview.export.internal.uc.wa.a.h();	 Catch:{ all -> 0x00d0 }
        r2 = 0;
        r6 = r0.getLong(r1, r2);	 Catch:{ all -> 0x00d0 }
        r1 = com.uc.webview.export.utility.Utils.sWAPrintLog;	 Catch:{ all -> 0x00d0 }
        if (r1 == 0) goto L_0x0047;
    L_0x0023:
        r1 = "SDKWaStat";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r3 = "==handlUpload==last upload time:";
        r2.<init>(r3);	 Catch:{ all -> 0x00d0 }
        r3 = new java.text.SimpleDateFormat;	 Catch:{ all -> 0x00d0 }
        r5 = "yyyy-MM-dd HH:mm:ss";
        r3.<init>(r5);	 Catch:{ all -> 0x00d0 }
        r5 = new java.util.Date;	 Catch:{ all -> 0x00d0 }
        r5.<init>(r6);	 Catch:{ all -> 0x00d0 }
        r3 = r3.format(r5);	 Catch:{ all -> 0x00d0 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00d0 }
        r2 = r2.toString();	 Catch:{ all -> 0x00d0 }
        com.uc.webview.export.internal.utility.Log.d(r1, r2);	 Catch:{ all -> 0x00d0 }
    L_0x0047:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00d0 }
        r2 = 0;
        r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r1 == 0) goto L_0x008f;
    L_0x0051:
        r2 = r8 - r6;
        r10 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r1 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r1 >= 0) goto L_0x008f;
    L_0x005a:
        r1 = java.util.Calendar.getInstance();	 Catch:{ all -> 0x00d0 }
        r1.setTimeInMillis(r6);	 Catch:{ all -> 0x00d0 }
        r2 = 11;
        r2 = r1.get(r2);	 Catch:{ all -> 0x00d0 }
        r1.setTimeInMillis(r8);	 Catch:{ all -> 0x00d0 }
        r3 = 11;
        r1 = r1.get(r3);	 Catch:{ all -> 0x00d0 }
        if (r2 < 0) goto L_0x007a;
    L_0x0072:
        r3 = 12;
        if (r2 >= r3) goto L_0x007a;
    L_0x0076:
        r3 = 12;
        if (r1 >= r3) goto L_0x0084;
    L_0x007a:
        r3 = 12;
        if (r2 < r3) goto L_0x00c3;
    L_0x007e:
        if (r1 < 0) goto L_0x00c3;
    L_0x0080:
        r2 = 12;
        if (r1 >= r2) goto L_0x00c3;
    L_0x0084:
        r1 = com.uc.webview.export.utility.Utils.sWAPrintLog;	 Catch:{ all -> 0x00d0 }
        if (r1 == 0) goto L_0x008f;
    L_0x0088:
        r1 = "SDKWaStat";
        r2 = "跨0点或12点";
        com.uc.webview.export.internal.utility.Log.d(r1, r2);	 Catch:{ all -> 0x00d0 }
    L_0x008f:
        r3 = 0;
        r1 = 1;
        r5 = new java.lang.String[r1];	 Catch:{ all -> 0x00d0 }
        r1 = 0;
        r2 = 0;
        r5[r1] = r2;	 Catch:{ all -> 0x00d0 }
        r10 = 0;
        r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r1 == 0) goto L_0x01a0;
    L_0x009d:
        r1 = r13.a;	 Catch:{ all -> 0x00d0 }
        r10 = r1.a(r0);	 Catch:{ all -> 0x00d0 }
        r0 = com.uc.webview.export.internal.SDKFactory.v;	 Catch:{ all -> 0x00d0 }
        if (r0 == 0) goto L_0x00b9;
    L_0x00a7:
        r0 = r13.a;	 Catch:{ all -> 0x00d0 }
        r0 = r0.j;	 Catch:{ all -> 0x00d0 }
        r0 = r0.getPackageName();	 Catch:{ all -> 0x00d0 }
        r1 = "com.taobao.taobao";
        r0 = r0.equals(r1);	 Catch:{ all -> 0x00d0 }
        if (r0 != 0) goto L_0x019e;
    L_0x00b9:
        r0 = r13.a;	 Catch:{ all -> 0x00d0 }
        r2 = com.uc.webview.export.internal.uc.wa.a.a(r0, r5);	 Catch:{ all -> 0x00d0 }
        if (r2 != 0) goto L_0x00dc;
    L_0x00c1:
        monitor-exit(r4);	 Catch:{ all -> 0x00d0 }
    L_0x00c2:
        return;
    L_0x00c3:
        r0 = com.uc.webview.export.utility.Utils.sWAPrintLog;	 Catch:{ all -> 0x00d0 }
        if (r0 == 0) goto L_0x00ce;
    L_0x00c7:
        r0 = "SDKWaStat";
        r1 = "时间间隔小于12小时,不上传";
        com.uc.webview.export.internal.utility.Log.d(r0, r1);	 Catch:{ all -> 0x00d0 }
    L_0x00ce:
        monitor-exit(r4);	 Catch:{ all -> 0x00d0 }
        goto L_0x00c2;
    L_0x00d0:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00d0 }
        throw r0;	 Catch:{ Throwable -> 0x00d3 }
    L_0x00d3:
        r0 = move-exception;
        r1 = "SDKWaStat";
        r2 = "handlUpload";
        com.uc.webview.export.internal.utility.Log.i(r1, r2, r0);
        goto L_0x00c2;
    L_0x00dc:
        r0 = com.uc.webview.export.internal.SDKFactory.w;	 Catch:{ all -> 0x00d0 }
        if (r0 == 0) goto L_0x00ec;
    L_0x00e0:
        r0 = com.uc.webview.export.internal.SDKFactory.w;	 Catch:{ Exception -> 0x017f }
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x017f }
        r11 = "UTF-8";
        r1.<init>(r2, r11);	 Catch:{ Exception -> 0x017f }
        r0.onReceiveValue(r1);	 Catch:{ Exception -> 0x017f }
    L_0x00ec:
        r1 = 0;
        r2 = com.uc.webview.export.internal.uc.wa.f.a(r2);	 Catch:{ Exception -> 0x0189 }
        r1 = 1;
        r0 = com.uc.webview.export.utility.Utils.sWAPrintLog;	 Catch:{ Exception -> 0x0189 }
        if (r0 == 0) goto L_0x010b;
    L_0x00f6:
        r0 = "SDKWaStat";
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0189 }
        r12 = "getUploadData encrypt:";
        r11.<init>(r12);	 Catch:{ Exception -> 0x0189 }
        r12 = r2.length;	 Catch:{ Exception -> 0x0189 }
        r11 = r11.append(r12);	 Catch:{ Exception -> 0x0189 }
        r11 = r11.toString();	 Catch:{ Exception -> 0x0189 }
        com.uc.webview.export.internal.utility.Log.d(r0, r11);	 Catch:{ Exception -> 0x0189 }
    L_0x010b:
        r10 = com.uc.webview.export.internal.uc.wa.a.a(r10, r1);	 Catch:{ all -> 0x00d0 }
        r0 = com.uc.webview.export.utility.Utils.sWAPrintLog;	 Catch:{ all -> 0x00d0 }
        if (r0 == 0) goto L_0x0127;
    L_0x0113:
        r0 = "SDKWaStat";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r11 = "request url:";
        r1.<init>(r11);	 Catch:{ all -> 0x00d0 }
        r1 = r1.append(r10);	 Catch:{ all -> 0x00d0 }
        r1 = r1.toString();	 Catch:{ all -> 0x00d0 }
        com.uc.webview.export.internal.utility.Log.d(r0, r1);	 Catch:{ all -> 0x00d0 }
    L_0x0127:
        r0 = 3;
    L_0x0128:
        r1 = r0 + -1;
        if (r0 <= 0) goto L_0x019e;
    L_0x012c:
        r0 = com.uc.webview.export.internal.uc.wa.a.b(r10, r2);	 Catch:{ all -> 0x00d0 }
        if (r0 == 0) goto L_0x019c;
    L_0x0132:
        r3 = 1;
        r0 = r3;
    L_0x0134:
        r1 = com.uc.webview.export.internal.SDKFactory.v;	 Catch:{ all -> 0x00d0 }
        if (r1 == 0) goto L_0x014b;
    L_0x0138:
        r1 = r13.a;	 Catch:{ Exception -> 0x0193 }
        r1 = r1.a(r5);	 Catch:{ Exception -> 0x0193 }
        if (r1 == 0) goto L_0x014b;
    L_0x0140:
        r2 = "SDKWaStat";
        com.uc.webview.export.internal.utility.Log.i(r2, r1);	 Catch:{ Exception -> 0x0193 }
        r2 = com.uc.webview.export.internal.SDKFactory.v;	 Catch:{ Exception -> 0x0193 }
        r2.onReceiveValue(r1);	 Catch:{ Exception -> 0x0193 }
        r0 = 1;
    L_0x014b:
        if (r0 == 0) goto L_0x0167;
    L_0x014d:
        r0 = new java.io.File;	 Catch:{ all -> 0x00d0 }
        r1 = r13.a;	 Catch:{ all -> 0x00d0 }
        r1 = r1.f();	 Catch:{ all -> 0x00d0 }
        r2 = com.uc.webview.export.internal.uc.wa.a.g();	 Catch:{ all -> 0x00d0 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x00d0 }
        r0.delete();	 Catch:{ all -> 0x00d0 }
        r0 = r13.a;	 Catch:{ all -> 0x00d0 }
        r1 = 0;
        r1 = r5[r1];	 Catch:{ all -> 0x00d0 }
        com.uc.webview.export.internal.uc.wa.a.a(r0, r8, r1);	 Catch:{ all -> 0x00d0 }
    L_0x0167:
        r0 = 0;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x017c;
    L_0x016d:
        r0 = "SDKWaStat";
        r1 = "首次不上传数据";
        com.uc.webview.export.internal.utility.Log.d(r0, r1);	 Catch:{ all -> 0x00d0 }
        r0 = r13.a;	 Catch:{ all -> 0x00d0 }
        r1 = 0;
        r1 = r5[r1];	 Catch:{ all -> 0x00d0 }
        com.uc.webview.export.internal.uc.wa.a.a(r0, r8, r1);	 Catch:{ all -> 0x00d0 }
    L_0x017c:
        monitor-exit(r4);	 Catch:{ all -> 0x00d0 }
        goto L_0x00c2;
    L_0x017f:
        r0 = move-exception;
        r1 = "SDKWaStat";
        r11 = "byte 转 String异常!";
        com.uc.webview.export.internal.utility.Log.d(r1, r11, r0);	 Catch:{ all -> 0x00d0 }
        goto L_0x00ec;
    L_0x0189:
        r0 = move-exception;
        r11 = "SDKWaStat";
        r12 = "data encrypt error:";
        com.uc.webview.export.internal.utility.Log.e(r11, r12, r0);	 Catch:{ all -> 0x00d0 }
        goto L_0x010b;
    L_0x0193:
        r1 = move-exception;
        r2 = "SDKWaStat";
        r3 = "第三方上传数据出错!";
        com.uc.webview.export.internal.utility.Log.d(r2, r3, r1);	 Catch:{ all -> 0x00d0 }
        goto L_0x014b;
    L_0x019c:
        r0 = r1;
        goto L_0x0128;
    L_0x019e:
        r0 = r3;
        goto L_0x0134;
    L_0x01a0:
        r0 = r3;
        goto L_0x014b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.uc.wa.e.run():void");
    }
}
