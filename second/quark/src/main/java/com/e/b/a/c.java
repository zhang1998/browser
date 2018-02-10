package com.e.b.a;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: ProGuard */
public final class c implements UncaughtExceptionHandler {
    private static c e = new c();
    private static volatile boolean f = false;
    public UncaughtExceptionHandler a = null;
    public boolean b = true;
    private d c = null;
    private Context d = null;

    public final void uncaughtException(java.lang.Thread r9, java.lang.Throwable r10) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r7 = 10;
        r0 = f;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        if (r0 == 0) goto L_0x001b;
    L_0x0006:
        r0 = r8.a;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = r8.a;
        r0.uncaughtException(r9, r10);
    L_0x000f:
        return;
    L_0x0010:
        r0 = android.os.Process.myPid();
        android.os.Process.killProcess(r0);
        java.lang.System.exit(r7);
        goto L_0x000f;
    L_0x001b:
        r0 = 1;
        f = r0;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        if (r10 == 0) goto L_0x0028;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x0020:
        r0 = "Caught Exception By UTCrashHandler.Please see log as follows!";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = 0;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        com.alibaba.analytics.a.af.d(r0, r1);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x0028:
        r4 = com.e.b.a.b.a(r10);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        if (r4 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x002e:
        r0 = r4.c;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        if (r0 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x0032:
        r0 = r4.a;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        if (r0 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x0036:
        r0 = r4.b;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        if (r0 == 0) goto L_0x0072;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x003a:
        r6 = new java.util.HashMap;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r6.<init>();	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r0 = "StackTrace";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = r4.c;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r6.put(r0, r1);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r0 = new com.e.b.c.d;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = "UT";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r2 = 1;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r3 = r4.b;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r4 = r4.a;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r5 = 0;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = "_priority";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r2 = "5";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r0.a(r1, r2);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = "_sls";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r2 = "yes";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r0.a(r1, r2);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = com.e.b.b.a();	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = r1.d();	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        if (r1 == 0) goto L_0x007c;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x006b:
        r0 = r0.a();	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1.a(r0);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
    L_0x0072:
        r0 = r8.a;
        if (r0 == 0) goto L_0x0096;
    L_0x0076:
        r0 = r8.a;
        r0.uncaughtException(r9, r10);
        goto L_0x000f;
    L_0x007c:
        r0 = "Record crash stacktrace error";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = 1;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r2 = 0;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r3 = "Fatal Error,must call setRequestAuthentication method first.";	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        r1[r2] = r3;	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        com.alibaba.analytics.a.af.d(r0, r1);	 Catch:{ Throwable -> 0x008a, all -> 0x00ae }
        goto L_0x0072;
    L_0x008a:
        r0 = move-exception;
        r0 = r8.a;
        if (r0 == 0) goto L_0x00a2;
    L_0x008f:
        r0 = r8.a;
        r0.uncaughtException(r9, r10);
        goto L_0x000f;
    L_0x0096:
        r0 = android.os.Process.myPid();
        android.os.Process.killProcess(r0);
        java.lang.System.exit(r7);
        goto L_0x000f;
    L_0x00a2:
        r0 = android.os.Process.myPid();
        android.os.Process.killProcess(r0);
        java.lang.System.exit(r7);
        goto L_0x000f;
    L_0x00ae:
        r0 = move-exception;
        r1 = r8.a;
        if (r1 == 0) goto L_0x00b9;
    L_0x00b3:
        r1 = r8.a;
        r1.uncaughtException(r9, r10);
    L_0x00b8:
        throw r0;
    L_0x00b9:
        r1 = android.os.Process.myPid();
        android.os.Process.killProcess(r1);
        java.lang.System.exit(r7);
        goto L_0x00b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.b.a.c.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    private c() {
    }

    public static c a() {
        return e;
    }
}
