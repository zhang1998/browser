package com.alibaba.analytics.core.c;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public final class h implements UncaughtExceptionHandler {
    private static h c = new h();
    public UncaughtExceptionHandler a;
    public List<j> b = Collections.synchronizedList(new ArrayList());

    public final void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r0 = r2.b;	 Catch:{ Throwable -> 0x0023, all -> 0x002e }
        r0 = r0.size();	 Catch:{ Throwable -> 0x0023, all -> 0x002e }
        if (r1 >= r0) goto L_0x0019;	 Catch:{ Throwable -> 0x0023, all -> 0x002e }
    L_0x000a:
        r0 = r2.b;	 Catch:{ Throwable -> 0x0023, all -> 0x002e }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x0023, all -> 0x002e }
        r0 = (com.alibaba.analytics.core.c.j) r0;	 Catch:{ Throwable -> 0x0023, all -> 0x002e }
        r0.e();	 Catch:{ Throwable -> 0x0023, all -> 0x002e }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0002;
    L_0x0019:
        r0 = r2.a;
        if (r0 == 0) goto L_0x0022;
    L_0x001d:
        r0 = r2.a;
        r0.uncaughtException(r3, r4);
    L_0x0022:
        return;
    L_0x0023:
        r0 = move-exception;
        r0 = r2.a;
        if (r0 == 0) goto L_0x0022;
    L_0x0028:
        r0 = r2.a;
        r0.uncaughtException(r3, r4);
        goto L_0x0022;
    L_0x002e:
        r0 = move-exception;
        r1 = r2.a;
        if (r1 == 0) goto L_0x0038;
    L_0x0033:
        r1 = r2.a;
        r1.uncaughtException(r3, r4);
    L_0x0038:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.core.c.h.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    public static h a() {
        return c;
    }
}
