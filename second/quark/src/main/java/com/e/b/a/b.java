package com.e.b.a;

/* compiled from: ProGuard */
public final class b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.e.b.a.a a(java.lang.Throwable r7) {
        /*
        r6 = 0;
        if (r7 == 0) goto L_0x00a6;
    L_0x0003:
        r2 = new com.e.b.a.a;
        r2.<init>();
        r0 = r7.getCause();
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        r0 = r7;
    L_0x000f:
        if (r0 == 0) goto L_0x0082;
    L_0x0011:
        r1 = r0.getStackTrace();
        r3 = r1.length;
        if (r3 <= 0) goto L_0x0082;
    L_0x0018:
        r1 = r1[r6];
        if (r1 == 0) goto L_0x0082;
    L_0x001c:
        r1 = r0.toString();
        r0 = "";
        r3 = new java.io.StringWriter;
        r3.<init>();
        r4 = new java.io.PrintWriter;
        r4.<init>(r3);
        r7.printStackTrace(r4);	 Catch:{ Exception -> 0x0084, all -> 0x008e }
        r0 = r3.toString();	 Catch:{ Exception -> 0x0084, all -> 0x008e }
        r4.close();	 Catch:{ Exception -> 0x00aa }
        r3.close();	 Catch:{ Exception -> 0x00aa }
    L_0x0039:
        r3 = "}:";
        r3 = r1.indexOf(r3);
        if (r3 <= 0) goto L_0x0096;
    L_0x0041:
        r3 = r3 + 2;
        r1 = r1.substring(r3);
        r1 = r1.trim();
    L_0x004b:
        r2.a = r1;
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x005b;
    L_0x0053:
        r1 = "\n";
        r3 = "++";
        r0 = r0.replaceAll(r1, r3);
    L_0x005b:
        r2.c = r0;
        r1 = r0.getBytes();
        r1 = com.alibaba.analytics.a.ab.b(r1);
        r2.b = r1;
        r1 = "com.taobao.statistic";
        r1 = r0.contains(r1);
        if (r1 != 0) goto L_0x007f;
    L_0x006f:
        r1 = "com.ut";
        r1 = r0.contains(r1);
        if (r1 != 0) goto L_0x007f;
    L_0x0077:
        r1 = "org.usertrack";
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x00a3;
    L_0x007f:
        r0 = 1;
        r2.d = r0;
    L_0x0082:
        r0 = r2;
    L_0x0083:
        return r0;
    L_0x0084:
        r5 = move-exception;
        r4.close();	 Catch:{ Exception -> 0x008c }
        r3.close();	 Catch:{ Exception -> 0x008c }
        goto L_0x0039;
    L_0x008c:
        r3 = move-exception;
        goto L_0x0039;
    L_0x008e:
        r0 = move-exception;
        r4.close();	 Catch:{ Exception -> 0x00a8 }
        r3.close();	 Catch:{ Exception -> 0x00a8 }
    L_0x0095:
        throw r0;
    L_0x0096:
        r3 = ":";
        r3 = r1.indexOf(r3);
        if (r3 <= 0) goto L_0x004b;
    L_0x009e:
        r1 = r1.substring(r6, r3);
        goto L_0x004b;
    L_0x00a3:
        r2.d = r6;
        goto L_0x0082;
    L_0x00a6:
        r0 = 0;
        goto L_0x0083;
    L_0x00a8:
        r1 = move-exception;
        goto L_0x0095;
    L_0x00aa:
        r3 = move-exception;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.b.a.b.a(java.lang.Throwable):com.e.b.a.a");
    }
}
