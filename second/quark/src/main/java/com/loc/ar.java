package com.loc;

/* compiled from: ProGuard */
final class ar extends Thread {
    final /* synthetic */ au a;

    ar(au auVar) {
        this.a = auVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0126 in list [B:45:0x0121]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
    L_0x0000:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.k;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x01fd;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x0006:
        r1 = 0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r3 = new com.loc.dh;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r3.<init>();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.l;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x01b1;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x0012:
        r4 = com.loc.dm.b();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r3.a = r4;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ Throwable -> 0x00f9, RemoteException -> 0x0111, InterruptedException -> 0x013f }
        r0.d();	 Catch:{ Throwable -> 0x00f9, RemoteException -> 0x0111, InterruptedException -> 0x013f }
    L_0x001d:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.K;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x0155;
    L_0x0025:
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r2.J.a();	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0.n = r2;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r0.n;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        if (r0 == 0) goto L_0x003f;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
    L_0x0035:
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r2.n;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r2.i;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0.q = r2;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
    L_0x003f:
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r0.n;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r3.c = r0;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0.C = false;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r0.J;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        if (r0 == 0) goto L_0x007c;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
    L_0x0052:
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r0.n;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r4 = r0.e;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r2.J;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r6 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r6 = r6.n;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r7 = com.loc.ci.a();	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r2.g;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r7.a = r2;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = com.loc.ci.a();	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = r2.a(r6);	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0.n = r2;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r0.n;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0.e = r4;	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
    L_0x007c:
        r4 = com.loc.dm.b();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r3.b = r4;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = r0.m;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        monitor-enter(r4);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.n;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x009d;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x008d:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.n;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.g;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 != 0) goto L_0x009d;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x0095:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r6 = com.loc.dm.b();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.o = r6;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x009d:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = 0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.l = r2;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.h;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x020c;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x00a8:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.h;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.size();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 <= 0) goto L_0x020c;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x00b2:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.h;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.size();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = r0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x00bb:
        if (r2 <= 0) goto L_0x017d;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x00bd:
        r1 = android.os.Message.obtain();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = new android.os.Bundle;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.<init>();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r5 = "location";	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r6 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r6 = r6.n;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.putParcelable(r5, r6);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r5 = "originalLocType";	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r6 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r6 = r6.q;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.putInt(r5, r6);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1.setData(r0);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = 1;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1.what = r0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.h;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r5 = 0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.get(r5);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = (android.os.Messenger) r0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.send(r1);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r1.h;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r5 = 0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1.remove(r5);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r2 + -1;
        r2 = r1;
        r1 = r0;
        goto L_0x00bb;
    L_0x00f9:
        r0 = move-exception;
        r2 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = r0.getMessage();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2.L = r4;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2.K = false;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = "APSServiceCore";	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = "run part1";	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.cq.a(r0, r2, r4);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        goto L_0x001d;
    L_0x0111:
        r0 = move-exception;
        r1 = "APSServiceCore";	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = "run part3";	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        com.loc.cq.a(r0, r1, r2);	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;
        r0 = r0.c();
        if (r0 != 0) goto L_0x0126;
    L_0x0121:
        r0 = r8.a;
        com.loc.au.p(r0);
    L_0x0126:
        return;
    L_0x0127:
        r0 = move-exception;
        r2 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = 8;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r5 = r0.getMessage();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = com.loc.au.b(r4, r5);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2.n = r4;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = "APSServiceCore";	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = "run part2";	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.cq.a(r0, r2, r4);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        goto L_0x007c;
    L_0x013f:
        r0 = move-exception;
        r0 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0.interrupt();	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;
        r0 = r0.c();
        if (r0 != 0) goto L_0x0126;
    L_0x014f:
        r0 = r8.a;
        com.loc.au.p(r0);
        goto L_0x0126;
    L_0x0155:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = 9;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r4 = r4.L;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = com.loc.au.b(r2, r4);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.n = r2;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        goto L_0x007c;
    L_0x0167:
        r0 = move-exception;
        r1 = "APSServiceCore";	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r2 = "run part5";	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        com.loc.cq.a(r0, r1, r2);	 Catch:{ Throwable -> 0x0127, RemoteException -> 0x0111, InterruptedException -> 0x013f, all -> 0x01a2 }
        r0 = r8.a;
        r0 = r0.c();
        if (r0 != 0) goto L_0x0126;
    L_0x0177:
        r0 = r8.a;
        com.loc.au.p(r0);
        goto L_0x0126;
    L_0x017d:
        r0 = r1;
    L_0x017e:
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r1.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.di.a(r1, r3);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        monitor-exit(r4);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x0186:
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.au.m(r1);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r1.k;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r1 != 0) goto L_0x01cb;
    L_0x0191:
        r0 = r8.a;
        r0 = r0.c();
        if (r0 != 0) goto L_0x0126;
    L_0x0199:
        r0 = r8.a;
        com.loc.au.p(r0);
        goto L_0x0126;
    L_0x019f:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        throw r0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x01a2:
        r0 = move-exception;
        r1 = r8.a;
        r1 = r1.c();
        if (r1 != 0) goto L_0x01b0;
    L_0x01ab:
        r1 = r8.a;
        com.loc.au.p(r1);
    L_0x01b0:
        throw r0;
    L_0x01b1:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = r0.m;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        monitor-enter(r2);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.c();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r0 == 0) goto L_0x01c5;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x01be:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r0.m;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.wait();	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x01c5:
        monitor-exit(r2);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r1;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        goto L_0x0186;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x01c8:
        r0 = move-exception;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        monitor-exit(r2);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        throw r0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x01cb:
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r1.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.de.c(r1);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r2 = r2.j;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r3 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r3 = r3.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.au.a(r1, r2, r3);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = r1.j;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        if (r1 == 0) goto L_0x01ec;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x01e5:
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r1 = 0;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0.j = r1;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        goto L_0x0000;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
    L_0x01ec:
        r1 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.au.a(r1, r0);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.au.n(r0);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        r0 = r8.a;	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        com.loc.au.o(r0);	 Catch:{ RemoteException -> 0x0111, InterruptedException -> 0x013f, Throwable -> 0x0167 }
        goto L_0x0000;
    L_0x01fd:
        r0 = r8.a;
        r0 = r0.c();
        if (r0 != 0) goto L_0x0126;
    L_0x0205:
        r0 = r8.a;
        com.loc.au.p(r0);
        goto L_0x0126;
    L_0x020c:
        r0 = r1;
        goto L_0x017e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ar.run():void");
    }
}
