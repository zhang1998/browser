package com.uc.quark.filedownloader.services;

import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.quark.ad;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.f;
import com.uc.quark.filedownloader.f.c;
import com.uc.quark.filedownloader.f.l;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.model.b;
import com.uc.quark.filedownloader.services.a.d;
import com.uc.quark.filedownloader.services.b.a;
import com.uc.quark.g;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* compiled from: ProGuard */
public final class t extends Thread {
    private static int i = 65536;
    private static int j = 2097152;
    private static int k = 4194304;
    private final f A;
    private final boolean B;
    private final boolean C;
    private final int D;
    private final long E;
    private final long F;
    private final int G;
    private long H;
    private final long I;
    private final a J;
    private final long K;
    private final long L;
    private final com.uc.quark.filedownloader.model.f M;
    private long N;
    private boolean O = true;
    private g P;
    private boolean Q = false;
    private final Queue<l> R = new ConcurrentLinkedQueue();
    private final ArrayList<l> S = new ArrayList();
    private d T = null;
    private com.uc.quark.filedownloader.services.a.a U = null;
    private c V = null;
    private l W = null;
    private RandomAccessFile X = null;
    private OutputStream Y = null;
    private boolean Z = false;
    volatile boolean a = false;
    private long aa = 0;
    private long ab = 0;
    private long ac = 0;
    private long ad = 0;
    private boolean ae = false;
    private long af;
    final int b;
    long c;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    volatile long g;
    private final Object h = new Object();
    private int l = 0;
    private final boolean m;
    private boolean n;
    private boolean o;
    private Throwable p;
    private int q;
    private b r;
    private volatile boolean s = false;
    private volatile boolean t = false;
    private final i u;
    private final ad v;
    private final int w;
    private final FileDownloadHeader x;
    private final int y;
    private long z;

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:463)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
*/
        /*
        r22 = this;
        r2 = 10;
        android.os.Process.setThreadPriority(r2);
        r2 = 0;
        r0 = r22;
        r0.t = r2;
        r2 = 1;
        r0 = r22;
        r0.s = r2;
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r2 = r0.r;	 Catch:{ all -> 0x04b2 }
        if (r2 != 0) goto L_0x005f;	 Catch:{ all -> 0x04b2 }
    L_0x0015:
        r2 = "start runnable but model == null?? %s";	 Catch:{ all -> 0x04b2 }
        r3 = 1;	 Catch:{ all -> 0x04b2 }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x04b2 }
        r4 = 0;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r5 = r0.D;	 Catch:{ all -> 0x04b2 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x04b2 }
        r3[r4] = r5;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        com.uc.quark.filedownloader.e.j.b(r0, r2, r3);	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r2 = r0.u;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r3 = r0.D;	 Catch:{ all -> 0x04b2 }
        r2 = r2.a(r3);	 Catch:{ all -> 0x04b2 }
        r2 = r2.d();	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r0.r = r2;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r2 = r0.r;	 Catch:{ all -> 0x04b2 }
        if (r2 != 0) goto L_0x005f;	 Catch:{ all -> 0x04b2 }
    L_0x0044:
        r2 = "start runnable but downloadMode == null?? %s";	 Catch:{ all -> 0x04b2 }
        r3 = 1;	 Catch:{ all -> 0x04b2 }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x04b2 }
        r4 = 0;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r5 = r0.D;	 Catch:{ all -> 0x04b2 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x04b2 }
        r3[r4] = r5;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        com.uc.quark.filedownloader.e.j.b(r0, r2, r3);	 Catch:{ all -> 0x04b2 }
        r2 = 0;
        r0 = r22;
        r0.s = r2;
    L_0x005e:
        return;
    L_0x005f:
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r2 = r0.B;	 Catch:{ all -> 0x04b2 }
        if (r2 == 0) goto L_0x0096;	 Catch:{ all -> 0x04b2 }
    L_0x0065:
        r2 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ all -> 0x04b2 }
        r2 = com.uc.quark.filedownloader.e.b.k(r2);	 Catch:{ all -> 0x04b2 }
        if (r2 != 0) goto L_0x0096;	 Catch:{ all -> 0x04b2 }
    L_0x006d:
        r2 = new com.uc.quark.filedownloader.a.c;	 Catch:{ all -> 0x04b2 }
        r3 = "Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.";	 Catch:{ all -> 0x04b2 }
        r4 = 2;	 Catch:{ all -> 0x04b2 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x04b2 }
        r5 = 0;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r6 = r0.D;	 Catch:{ all -> 0x04b2 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x04b2 }
        r4[r5] = r6;	 Catch:{ all -> 0x04b2 }
        r5 = 1;	 Catch:{ all -> 0x04b2 }
        r6 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ all -> 0x04b2 }
        r4[r5] = r6;	 Catch:{ all -> 0x04b2 }
        r3 = com.uc.quark.filedownloader.e.b.a(r3, r4);	 Catch:{ all -> 0x04b2 }
        r2.<init>(r3);	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r0.a(r2);	 Catch:{ all -> 0x04b2 }
        r2 = 0;
        r0 = r22;
        r0.s = r2;
        goto L_0x005e;
    L_0x0096:
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r2 = r0.r;	 Catch:{ all -> 0x04b2 }
        r3 = 6;	 Catch:{ all -> 0x04b2 }
        r2.f = r3;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r2 = r0.J;	 Catch:{ all -> 0x04b2 }
        r3 = 6;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r4 = r0.D;	 Catch:{ all -> 0x04b2 }
        r5 = 0;	 Catch:{ all -> 0x04b2 }
        r2.a(r3, r4, r5);	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r0 = r0.r;	 Catch:{ all -> 0x04b2 }
        r18 = r0;	 Catch:{ all -> 0x04b2 }
        r10 = 0;	 Catch:{ all -> 0x04b2 }
        r8 = 0;	 Catch:{ all -> 0x04b2 }
        r16 = 0;	 Catch:{ all -> 0x04b2 }
        r2 = 0;	 Catch:{ all -> 0x04b2 }
        r15 = 0;	 Catch:{ all -> 0x04b2 }
        r3 = r15;	 Catch:{ all -> 0x04b2 }
        r5 = r2;	 Catch:{ all -> 0x04b2 }
    L_0x00b8:
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r6 = r0.D;	 Catch:{ all -> 0x04b2 }
        r12 = r22.c();	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r14 = r0.I;	 Catch:{ all -> 0x04b2 }
        r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));	 Catch:{ all -> 0x04b2 }
        if (r2 < 0) goto L_0x00e2;	 Catch:{ all -> 0x04b2 }
    L_0x00c8:
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r12 = r0.I;	 Catch:{ all -> 0x04b2 }
        r14 = -1;	 Catch:{ all -> 0x04b2 }
        r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));	 Catch:{ all -> 0x04b2 }
        if (r2 == 0) goto L_0x00e2;	 Catch:{ all -> 0x04b2 }
    L_0x00d2:
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r2 = r0.c;	 Catch:{ all -> 0x04b2 }
        r0 = r22;	 Catch:{ all -> 0x04b2 }
        r0.a(r2);	 Catch:{ all -> 0x04b2 }
    L_0x00db:
        r2 = 0;
        r0 = r22;
        r0.s = r2;
        goto L_0x005e;
    L_0x00e2:
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r2 = r0.a;	 Catch:{ Throwable -> 0x015f }
        if (r2 == 0) goto L_0x0116;	 Catch:{ Throwable -> 0x015f }
    L_0x00e8:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x015f }
        if (r2 == 0) goto L_0x0108;	 Catch:{ Throwable -> 0x015f }
    L_0x00ec:
        r2 = "already canceled %d %d";	 Catch:{ Throwable -> 0x015f }
        r4 = 2;	 Catch:{ Throwable -> 0x015f }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x015f }
        r5 = 0;	 Catch:{ Throwable -> 0x015f }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x015f }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x015f }
        r5 = 1;	 Catch:{ Throwable -> 0x015f }
        r0 = r18;	 Catch:{ Throwable -> 0x015f }
        r6 = r0.f;	 Catch:{ Throwable -> 0x015f }
        r6 = java.lang.Byte.valueOf(r6);	 Catch:{ Throwable -> 0x015f }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x015f }
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        com.uc.quark.filedownloader.e.j.d(r0, r2, r4);	 Catch:{ Throwable -> 0x015f }
    L_0x0108:
        r22.d();	 Catch:{ Throwable -> 0x015f }
        if (r3 == 0) goto L_0x00db;
    L_0x010d:
        r3.e();	 Catch:{ Throwable -> 0x0114 }
        r3.g();	 Catch:{ Throwable -> 0x0114 }
        goto L_0x00db;
    L_0x0114:
        r2 = move-exception;
        goto L_0x00db;
    L_0x0116:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x015f }
        if (r2 == 0) goto L_0x0132;	 Catch:{ Throwable -> 0x015f }
    L_0x011a:
        r2 = com.uc.quark.filedownloader.services.ad.class;	 Catch:{ Throwable -> 0x015f }
        r4 = "start download %s %s";	 Catch:{ Throwable -> 0x015f }
        r7 = 2;	 Catch:{ Throwable -> 0x015f }
        r7 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x015f }
        r9 = 0;	 Catch:{ Throwable -> 0x015f }
        r11 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x015f }
        r7[r9] = r11;	 Catch:{ Throwable -> 0x015f }
        r9 = 1;	 Catch:{ Throwable -> 0x015f }
        r0 = r18;	 Catch:{ Throwable -> 0x015f }
        r11 = r0.b;	 Catch:{ Throwable -> 0x015f }
        r7[r9] = r11;	 Catch:{ Throwable -> 0x015f }
        com.uc.quark.filedownloader.e.j.d(r2, r4, r7);	 Catch:{ Throwable -> 0x015f }
    L_0x0132:
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r2 = r0.D;	 Catch:{ Throwable -> 0x015f }
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r4 = r0.r;	 Catch:{ Throwable -> 0x015f }
        r2 = com.uc.quark.filedownloader.e.b.a(r2, r4);	 Catch:{ Throwable -> 0x015f }
        if (r2 == 0) goto L_0x0159;	 Catch:{ Throwable -> 0x015f }
    L_0x0140:
        r2 = 1;	 Catch:{ Throwable -> 0x015f }
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r0.n = r2;	 Catch:{ Throwable -> 0x015f }
    L_0x0145:
        if (r10 <= 0) goto L_0x0183;	 Catch:{ Throwable -> 0x015f }
    L_0x0147:
        r2 = r5 instanceof javax.net.ssl.SSLException;	 Catch:{ Throwable -> 0x015f }
        if (r2 == 0) goto L_0x0183;	 Catch:{ Throwable -> 0x015f }
    L_0x014b:
        r22.e();	 Catch:{ Throwable -> 0x015f }
        if (r3 == 0) goto L_0x00db;
    L_0x0150:
        r3.e();	 Catch:{ Throwable -> 0x0157 }
        r3.g();	 Catch:{ Throwable -> 0x0157 }
        goto L_0x00db;
    L_0x0157:
        r2 = move-exception;
        goto L_0x00db;
    L_0x0159:
        r2 = 0;
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r0.n = r2;	 Catch:{ Throwable -> 0x015f }
        goto L_0x0145;
    L_0x015f:
        r2 = move-exception;
        r4 = r16;
        r5 = r8;
        r6 = r10;
    L_0x0164:
        r0 = r22;	 Catch:{ all -> 0x0527 }
        r7 = r0.w;	 Catch:{ all -> 0x0527 }
        r10 = r6 + 1;	 Catch:{ all -> 0x0527 }
        if (r7 <= r6) goto L_0x0509;	 Catch:{ all -> 0x0527 }
    L_0x016c:
        r6 = r2 instanceof com.uc.quark.filedownloader.a.c;	 Catch:{ all -> 0x0527 }
        if (r6 != 0) goto L_0x0509;	 Catch:{ all -> 0x0527 }
    L_0x0170:
        r0 = r22;	 Catch:{ all -> 0x0527 }
        r0.a(r2, r10);	 Catch:{ all -> 0x0527 }
        if (r3 == 0) goto L_0x017d;
    L_0x0177:
        r3.e();	 Catch:{ Throwable -> 0x051b }
        r3.g();	 Catch:{ Throwable -> 0x051b }
    L_0x017d:
        r16 = r4;
        r8 = r5;
        r5 = r2;
        goto L_0x00b8;
    L_0x0183:
        if (r3 == 0) goto L_0x018b;
    L_0x0185:
        r3.e();	 Catch:{ Throwable -> 0x0545 }
        r3.g();	 Catch:{ Throwable -> 0x0545 }
    L_0x018b:
        r0 = r18;	 Catch:{ Throwable -> 0x015f }
        r2 = r0.n;	 Catch:{ Throwable -> 0x015f }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x015f }
        if (r2 == 0) goto L_0x0325;	 Catch:{ Throwable -> 0x015f }
    L_0x0195:
        r0 = r18;	 Catch:{ Throwable -> 0x015f }
        r2 = r0.b;	 Catch:{ Throwable -> 0x015f }
    L_0x0199:
        r4 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x015f }
        if (r4 == 0) goto L_0x01b1;	 Catch:{ Throwable -> 0x015f }
    L_0x019d:
        r4 = "vanda";	 Catch:{ Throwable -> 0x015f }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x015f }
        r9 = "download url -> ";	 Catch:{ Throwable -> 0x015f }
        r7.<init>(r9);	 Catch:{ Throwable -> 0x015f }
        r7 = r7.append(r2);	 Catch:{ Throwable -> 0x015f }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x015f }
        android.util.Log.e(r4, r7);	 Catch:{ Throwable -> 0x015f }
    L_0x01b1:
        r4 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x015f }
        if (r4 == 0) goto L_0x01d1;	 Catch:{ Throwable -> 0x015f }
    L_0x01b5:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x015f }
        r7 = "start : threadid = ";	 Catch:{ Throwable -> 0x015f }
        r4.<init>(r7);	 Catch:{ Throwable -> 0x015f }
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r7 = r0.b;	 Catch:{ Throwable -> 0x015f }
        r4 = r4.append(r7);	 Catch:{ Throwable -> 0x015f }
        r7 = "\n";	 Catch:{ Throwable -> 0x015f }
        r4 = r4.append(r7);	 Catch:{ Throwable -> 0x015f }
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r7 = r0.M;	 Catch:{ Throwable -> 0x015f }
        r4.append(r7);	 Catch:{ Throwable -> 0x015f }
    L_0x01d1:
        r0 = r22;	 Catch:{ Throwable -> 0x015f }
        r4 = r0.v;	 Catch:{ Throwable -> 0x015f }
        r4 = com.uc.quark.filedownloader.e.b.a(r4);	 Catch:{ Throwable -> 0x015f }
        r15 = r4.a(r2);	 Catch:{ Throwable -> 0x015f }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0.P = r15;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0.a(r15);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r15.b();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r3 == 0) goto L_0x0202;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x01ee:
        r3 = "%s request header %s";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r4 = 2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r9 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r4[r7] = r9;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r4[r7] = r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        com.uc.quark.filedownloader.e.j.d(r0, r3, r4);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0202:
        r0 = r18;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = r0.k;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 != 0) goto L_0x032b;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x020c:
        r2 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x020d:
        if (r2 == 0) goto L_0x032e;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x020f:
        r2 = com.uc.quark.ah.a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0211:
        r15.a(r2, r3);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r4 = r15.d();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r4 == r2) goto L_0x0220;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x021c:
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r4 != r2) goto L_0x0332;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0220:
        r2 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0222:
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r4 != r2) goto L_0x0336;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0226:
        r2 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r11 = r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0228:
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r4 != r2) goto L_0x033a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x022c:
        r2 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x022d:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0.Q = r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r9 = r0.Q;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r9 != 0) goto L_0x0255;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0237:
        r2 = "tried to resume from the break point[%d], but the response code is %d, not 206(PARTIAL).";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r18;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r0.g;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r20 = r0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r13 = java.lang.Long.valueOf(r20);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7[r12] = r13;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r13 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7[r12] = r13;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        com.uc.quark.filedownloader.e.j.e(r0, r2, r7);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0255:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x02fb;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0259:
        r7 = "vanda";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = "code=";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2.<init>(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = "     append = ";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r2.append(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r4 != r2) goto L_0x033d;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0270:
        r2 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0271:
        r2 = r12.append(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = "  threadId = ";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.append(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r0.b;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.append(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        android.util.Log.e(r7, r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = "bytes=";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2.<init>(r7);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r22.c();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = r2.append(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r0.I;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r20 = -1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1));	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x02ad;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x02a3:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r0.b;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r0.G;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 != r12) goto L_0x0340;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x02ad:
        r2 = "-";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x02af:
        r2 = r7.append(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = "vanda";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r13 = "mStartPosition:";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12.<init>(r13);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r20 = r22.c();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r20;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r12.append(r0);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r13 = "    mEndPosition:";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r12.append(r13);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r0.I;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r20 = r0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r20;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r12.append(r0);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r13 = "    threadId:";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r12.append(r13);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r13 = r0.b;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r12.append(r13);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r13 = "   range = ";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r12.append(r13);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r12.append(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        android.util.Log.e(r7, r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x02fb:
        if (r9 != 0) goto L_0x036c;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x02fd:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r0.G;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 2;
        if (r2 < r7) goto L_0x036c;
    L_0x0304:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 != r2) goto L_0x036c;
    L_0x0308:
        r3 = r8 + 1;
        r0 = r22;	 Catch:{ Throwable -> 0x0533, all -> 0x04a8 }
        r2 = r0.w;	 Catch:{ Throwable -> 0x0533, all -> 0x04a8 }
        if (r8 >= r2) goto L_0x035a;
    L_0x0310:
        r15.e();	 Catch:{ Throwable -> 0x0542, all -> 0x04a8 }
        r15.g();	 Catch:{ Throwable -> 0x0542, all -> 0x04a8 }
    L_0x0316:
        r6 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x0522 }
    L_0x031b:
        r15.e();	 Catch:{ Throwable -> 0x0355 }
        r15.g();	 Catch:{ Throwable -> 0x0355 }
        r8 = r3;
        r3 = r15;
        goto L_0x00b8;
    L_0x0325:
        r0 = r18;	 Catch:{ Throwable -> 0x015f }
        r2 = r0.n;	 Catch:{ Throwable -> 0x015f }
        goto L_0x0199;
    L_0x032b:
        r2 = 0;
        goto L_0x020d;
    L_0x032e:
        r2 = com.uc.quark.ah.b;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        goto L_0x0211;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0332:
        r2 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        goto L_0x0222;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0336:
        r2 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r11 = r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        goto L_0x0228;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x033a:
        r2 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        goto L_0x022d;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x033d:
        r2 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        goto L_0x0271;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0340:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = "-";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2.<init>(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r0.I;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.append(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        goto L_0x02af;
    L_0x0355:
        r2 = move-exception;
        r8 = r3;
        r3 = r15;
        goto L_0x00b8;
    L_0x035a:
        r0 = r22;	 Catch:{ Throwable -> 0x0533, all -> 0x04a8 }
        r2 = r0.J;	 Catch:{ Throwable -> 0x0533, all -> 0x04a8 }
        r2.a();	 Catch:{ Throwable -> 0x0533, all -> 0x04a8 }
        r15.e();	 Catch:{ Throwable -> 0x0369 }
        r15.g();	 Catch:{ Throwable -> 0x0369 }
        goto L_0x00db;
    L_0x0369:
        r2 = move-exception;
        goto L_0x00db;
    L_0x036c:
        if (r3 != 0) goto L_0x0370;
    L_0x036e:
        if (r11 == 0) goto L_0x0498;
    L_0x0370:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r4 = r0.K;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = "Transfer-Encoding";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r15.a(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r3 != 0) goto L_0x0382;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x037c:
        r12 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r3 > 0) goto L_0x0388;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0382:
        if (r2 != 0) goto L_0x0463;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0384:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r4 = r0.K;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0388:
        r12 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r3 >= 0) goto L_0x03ba;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x038e:
        if (r2 == 0) goto L_0x0467;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0390:
        r3 = "chunked";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.equals(r3);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x0467;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0398:
        r2 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0399:
        if (r2 != 0) goto L_0x03ba;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x039b:
        r2 = com.uc.quark.filedownloader.e.h.a();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.c;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x046a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03a3:
        r4 = -1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x03ba;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03a9:
        r2 = "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3[r7] = r6;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        com.uc.quark.filedownloader.e.j.d(r0, r2, r3);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03ba:
        r2 = "Etag";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r6 = r15.a(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x03dc;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03c4:
        r2 = "etag find by header %d %s";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = 2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = r0.D;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3[r7] = r12;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 1;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3[r7] = r6;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        com.uc.quark.filedownloader.e.j.d(r0, r2, r3);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03dc:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r0.r;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.d;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x047a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03e4:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r0.r;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.e;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 != 0) goto L_0x047a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03ec:
        r2 = "Content-Disposition";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r15.a(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = com.uc.quark.filedownloader.e.b.h(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x0406;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x03fc:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r0.r;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r2.b;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = com.uc.quark.filedownloader.e.b.b(r2);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0406:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r2 == 0) goto L_0x041e;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x040a:
        r2 = "vanda";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r12 = "onConnected etag = ";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3.<init>(r12);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = r3.append(r6);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        android.util.Log.e(r2, r3);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x041e:
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r0.u;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = r0.r;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2.a(r3, r4, r6, r7);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0.o = r11;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2 = r0.J;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = 2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r6 = r0.D;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = 0;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2.a(r3, r6, r7);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r17 = 0;
        r3 = 0;
        r2 = r15.i();	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        if (r2 == 0) goto L_0x047c;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
    L_0x0443:
        r8 = r15.h();	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r0 = r22;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r10 = r0.c;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r2 = "Connection";	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r14 = r15.a(r2);	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r6 = r22;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r7 = r15;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r12 = r4;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r6.a(r7, r8, r9, r10, r12, r14);	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r15.e();	 Catch:{ Throwable -> 0x0460 }
        r15.g();	 Catch:{ Throwable -> 0x0460 }
        goto L_0x00db;
    L_0x0460:
        r2 = move-exception;
        goto L_0x00db;
    L_0x0463:
        r4 = -1;
        goto L_0x0388;
    L_0x0467:
        r2 = 0;
        goto L_0x0399;
    L_0x046a:
        r2 = new com.uc.quark.filedownloader.a.c;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = "can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties";	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        throw r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x0472:
        r2 = move-exception;
        r3 = r15;
        r4 = r16;
        r5 = r8;
        r6 = r10;
        goto L_0x0164;
    L_0x047a:
        r7 = 0;
        goto L_0x0406;
    L_0x047c:
        r0 = r22;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r10 = r0.c;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r2 = "Connection";	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r14 = r15.a(r2);	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r7 = r22;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r8 = r15;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r12 = r4;	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r7.a(r8, r9, r10, r12, r14);	 Catch:{ Throwable -> 0x052a, all -> 0x04a8 }
        r15.e();	 Catch:{ Throwable -> 0x0495 }
        r15.g();	 Catch:{ Throwable -> 0x0495 }
        goto L_0x00db;
    L_0x0495:
        r2 = move-exception;
        goto L_0x00db;
    L_0x0498:
        r2 = new com.uc.quark.filedownloader.a.d;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r3 = r15.b();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r7 = r15.c();	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        r2.<init>(r4, r3, r7);	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
        if (r16 == 0) goto L_0x04b9;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x04a7:
        throw r2;	 Catch:{ Throwable -> 0x0472, all -> 0x04a8 }
    L_0x04a8:
        r2 = move-exception;
    L_0x04a9:
        if (r15 == 0) goto L_0x04b1;
    L_0x04ab:
        r15.e();	 Catch:{ Throwable -> 0x0525 }
        r15.g();	 Catch:{ Throwable -> 0x0525 }
    L_0x04b1:
        throw r2;	 Catch:{ all -> 0x04b2 }
    L_0x04b2:
        r2 = move-exception;
        r3 = 0;
        r0 = r22;
        r0.s = r3;
        throw r2;
    L_0x04b9:
        r3 = 1;
        switch(r4) {
            case 416: goto L_0x04c5;
            default: goto L_0x04bd;
        };
    L_0x04bd:
        throw r2;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
    L_0x04be:
        r2 = move-exception;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r4 = r3;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r5 = r8;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r6 = r10;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r3 = r15;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        goto L_0x0164;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
    L_0x04c5:
        r7 = com.uc.quark.filedownloader.services.ad.class;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r9 = "%d response code %d, range[%d] isn't make sense, so delete the dirty file[%s], and try to redownload it from byte-0.";	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r11 = 4;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r11 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r12 = 0;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r11[r12] = r6;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r6 = 1;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r11[r6] = r4;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r4 = 2;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r0 = r18;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r12 = r0.g;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r6 = java.lang.Long.valueOf(r12);	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r11[r4] = r6;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r4 = 3;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r6 = r18.b();	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r11[r4] = r6;	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        com.uc.quark.filedownloader.e.j.e(r7, r9, r11);	 Catch:{ Throwable -> 0x04be, all -> 0x04a8 }
        r4 = r10 + 1;
        r0 = r22;	 Catch:{ Throwable -> 0x053b, all -> 0x04a8 }
        r0.a(r2, r10);	 Catch:{ Throwable -> 0x053b, all -> 0x04a8 }
        r15.e();	 Catch:{ Throwable -> 0x0502 }
        r15.g();	 Catch:{ Throwable -> 0x0502 }
        r16 = r3;
        r10 = r4;
        r3 = r15;
        goto L_0x00b8;
    L_0x0502:
        r2 = move-exception;
        r16 = r3;
        r10 = r4;
        r3 = r15;
        goto L_0x00b8;
    L_0x0509:
        r0 = r22;	 Catch:{ all -> 0x0527 }
        r0.a(r2);	 Catch:{ all -> 0x0527 }
        if (r3 == 0) goto L_0x00db;
    L_0x0510:
        r3.e();	 Catch:{ Throwable -> 0x0518 }
        r3.g();	 Catch:{ Throwable -> 0x0518 }
        goto L_0x00db;
    L_0x0518:
        r2 = move-exception;
        goto L_0x00db;
    L_0x051b:
        r6 = move-exception;
        r16 = r4;
        r8 = r5;
        r5 = r2;
        goto L_0x00b8;
    L_0x0522:
        r2 = move-exception;
        goto L_0x031b;
    L_0x0525:
        r3 = move-exception;
        goto L_0x04b1;
    L_0x0527:
        r2 = move-exception;
        r15 = r3;
        goto L_0x04a9;
    L_0x052a:
        r2 = move-exception;
        r4 = r16;
        r5 = r3;
        r6 = r17;
        r3 = r15;
        goto L_0x0164;
    L_0x0533:
        r2 = move-exception;
        r4 = r16;
        r5 = r3;
        r6 = r10;
        r3 = r15;
        goto L_0x0164;
    L_0x053b:
        r2 = move-exception;
        r5 = r8;
        r6 = r4;
        r4 = r3;
        r3 = r15;
        goto L_0x0164;
    L_0x0542:
        r2 = move-exception;
        goto L_0x0316;
    L_0x0545:
        r2 = move-exception;
        goto L_0x018b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.t.run():void");
    }

    public t(ad adVar, f fVar, b bVar, i iVar, int i, FileDownloadHeader fileDownloadHeader, int i2, int i3, boolean z, boolean z2, boolean z3, long j, long j2, int i4, int i5, a aVar, long j3, int i6, long j4) {
        if (i6 > j) {
            k = i6;
        }
        this.D = bVar.a;
        this.B = z2;
        this.C = z3;
        this.t = true;
        this.s = false;
        this.v = adVar;
        this.A = fVar;
        this.u = iVar;
        this.x = fileDownloadHeader;
        if (i2 < 5) {
            i2 = 5;
        }
        this.y = i2;
        this.N = j4;
        this.l = i3;
        this.m = z;
        this.n = false;
        this.r = bVar;
        this.O = bVar.m;
        this.w = i;
        this.E = j;
        this.F = j2;
        this.b = i4;
        this.G = i5;
        this.J = aVar;
        this.c = j3;
        this.af = j3;
        this.g = j3;
        this.K = (this.E * ((long) this.G)) + this.F;
        long j5 = j == -1 ? -1 : i4 == this.G ? this.E + this.F : this.E;
        this.L = j5;
        this.H = j == -1 ? 0 : (this.E * ((long) (i4 - 1))) + this.c;
        j5 = j == -1 ? -1 : i4 == this.G ? (this.E * ((long) this.G)) + this.F : (this.E * ((long) i4)) - 1;
        this.I = j5;
        this.M = new com.uc.quark.filedownloader.model.f(bVar.b, a(), this.c, this.b, (long) bVar.a, this.E, this.F);
    }

    private long c() {
        long j = 0;
        if (this.q > 0) {
            this.c = this.E == -1 ? 0 : this.af;
            if (this.E != -1) {
                j = this.c + (this.E * ((long) (this.b - 1)));
            }
            this.H = j;
        }
        return this.H;
    }

    public final long a() {
        return this.b != this.G ? this.E : this.E + this.F;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.uc.quark.g r14, boolean r15, long r16, long r18, java.lang.String r20) throws java.lang.Exception {
        /*
        r13 = this;
        r3 = 0;
        r2 = r13.l;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r4 = (long) r2;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r0 = r18;
        r4 = a(r0, r4);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r13.z = r4;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        if (r15 == 0) goto L_0x00d0;
    L_0x000e:
        r4 = r13.c();	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
    L_0x0012:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        if (r2 == 0) goto L_0x004e;
    L_0x0016:
        r2 = "vanda";
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r7 = "threadId = ";
        r6.<init>(r7);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r7 = r13.b;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r7 = "   position = ";
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r4 = r6.append(r4);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r5 = "  mNormalSize = ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r6 = r13.E;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r4 = r4.append(r6);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r5 = "  mExSize = ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r6 = r13.F;	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r4 = r4.append(r6);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        android.util.Log.e(r2, r4);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
    L_0x004e:
        r2 = "rw";
        r10 = r13.a(r15, r2);	 Catch:{ IOException -> 0x021e, all -> 0x0214 }
        r2 = r13.U;	 Catch:{ IOException -> 0x00d9 }
        if (r2 != 0) goto L_0x00d4;
    L_0x0058:
        r2 = new com.uc.quark.filedownloader.services.a.a;	 Catch:{ IOException -> 0x00d9 }
        r2.<init>(r10);	 Catch:{ IOException -> 0x00d9 }
        r13.U = r2;	 Catch:{ IOException -> 0x00d9 }
    L_0x005f:
        r2 = r14 instanceof com.uc.quark.u;	 Catch:{ IOException -> 0x00d9 }
        if (r2 == 0) goto L_0x0168;
    L_0x0063:
        r0 = r14;
        r0 = (com.uc.quark.u) r0;	 Catch:{ IOException -> 0x00d9 }
        r2 = r0;
        r2 = r2.j();	 Catch:{ IOException -> 0x00d9 }
    L_0x006b:
        r14.a(r2);	 Catch:{ IOException -> 0x00d9 }
    L_0x006e:
        r2 = i;	 Catch:{ IOException -> 0x00d9 }
        r2 = (long) r2;	 Catch:{ IOException -> 0x00d9 }
        r2 = r14.a(r2);	 Catch:{ IOException -> 0x00d9 }
        r4 = -1;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x01c4;
    L_0x007b:
        r4 = r16 + r2;
        r2 = r13.L;	 Catch:{ IOException -> 0x0224 }
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0194;
    L_0x0085:
        r2 = r13.L;	 Catch:{ IOException -> 0x0224 }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0194;
    L_0x008b:
        r2 = 1;
    L_0x008c:
        r3 = r13.a;	 Catch:{ IOException -> 0x0224 }
        if (r3 != 0) goto L_0x0092;
    L_0x0090:
        if (r2 == 0) goto L_0x0197;
    L_0x0092:
        r9 = 1;
    L_0x0093:
        r3 = r13;
        r6 = r18;
        r8 = r14;
        r3.a(r4, r6, r8, r9);	 Catch:{ IOException -> 0x0224 }
        if (r2 == 0) goto L_0x019a;
    L_0x009c:
        r13.a(r4);	 Catch:{ IOException -> 0x0224 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ IOException -> 0x0224 }
        if (r2 == 0) goto L_0x00c3;
    L_0x00a3:
        r2 = "vanda";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0224 }
        r6 = "onProgress mBlockSize = ";
        r3.<init>(r6);	 Catch:{ IOException -> 0x0224 }
        r6 = r13.L;	 Catch:{ IOException -> 0x0224 }
        r3 = r3.append(r6);	 Catch:{ IOException -> 0x0224 }
        r6 = "  end sofar = ";
        r3 = r3.append(r6);	 Catch:{ IOException -> 0x0224 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x0224 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0224 }
        android.util.Log.e(r2, r3);	 Catch:{ IOException -> 0x0224 }
    L_0x00c3:
        if (r14 == 0) goto L_0x00cb;
    L_0x00c5:
        r14.e();	 Catch:{ Throwable -> 0x0238 }
        r14.g();	 Catch:{ Throwable -> 0x0238 }
    L_0x00cb:
        r10.close();	 Catch:{ Exception -> 0x0235 }
    L_0x00ce:
        r2 = 1;
    L_0x00cf:
        return r2;
    L_0x00d0:
        r4 = 0;
        goto L_0x0012;
    L_0x00d4:
        r2 = r13.U;	 Catch:{ IOException -> 0x00d9 }
        r2.a = r10;	 Catch:{ IOException -> 0x00d9 }
        goto L_0x005f;
    L_0x00d9:
        r2 = move-exception;
        r4 = r16;
    L_0x00dc:
        r11 = r2.toString();	 Catch:{ all -> 0x0185 }
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x0185 }
        if (r3 == 0) goto L_0x010e;
    L_0x00e4:
        r3 = "vanda";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0185 }
        r7 = "fetch Exception = ";
        r6.<init>(r7);	 Catch:{ all -> 0x0185 }
        r6 = r6.append(r11);	 Catch:{ all -> 0x0185 }
        r7 = "  mBlockSize = ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0185 }
        r8 = r13.L;	 Catch:{ all -> 0x0185 }
        r6 = r6.append(r8);	 Catch:{ all -> 0x0185 }
        r7 = "  soFar = ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0185 }
        r6 = r6.append(r4);	 Catch:{ all -> 0x0185 }
        r6 = r6.toString();	 Catch:{ all -> 0x0185 }
        android.util.Log.e(r3, r6);	 Catch:{ all -> 0x0185 }
    L_0x010e:
        r9 = 1;
        r3 = r13;
        r6 = r18;
        r8 = r14;
        r3.a(r4, r6, r8, r9);	 Catch:{ all -> 0x0185 }
        r3 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0185 }
        if (r3 != 0) goto L_0x0120;
    L_0x011c:
        r3 = r2 instanceof java.io.EOFException;	 Catch:{ all -> 0x0185 }
        if (r3 != 0) goto L_0x013e;
    L_0x0120:
        r3 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0185 }
        if (r3 != 0) goto L_0x020b;
    L_0x0126:
        r3 = "java.io.IOException: unexpected end of stream on";
        r3 = r11.contains(r3);	 Catch:{ all -> 0x0185 }
        if (r3 == 0) goto L_0x020b;
    L_0x012e:
        r3 = android.text.TextUtils.isEmpty(r20);	 Catch:{ all -> 0x0185 }
        if (r3 != 0) goto L_0x020b;
    L_0x0134:
        r3 = "close";
        r0 = r20;
        r3 = r3.equals(r0);	 Catch:{ all -> 0x0185 }
        if (r3 == 0) goto L_0x020b;
    L_0x013e:
        r3 = 1;
    L_0x013f:
        if (r3 != 0) goto L_0x0147;
    L_0x0141:
        r6 = r13.L;	 Catch:{ all -> 0x0185 }
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x020e;
    L_0x0147:
        r2 = r13.L;	 Catch:{ all -> 0x0185 }
        r6 = -1;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0155;
    L_0x014f:
        r2 = r13.L;	 Catch:{ all -> 0x0185 }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0158;
    L_0x0155:
        r13.a(r4);	 Catch:{ all -> 0x0185 }
    L_0x0158:
        if (r14 == 0) goto L_0x0160;
    L_0x015a:
        r14.e();	 Catch:{ Throwable -> 0x021b }
        r14.g();	 Catch:{ Throwable -> 0x021b }
    L_0x0160:
        if (r10 == 0) goto L_0x0165;
    L_0x0162:
        r10.close();	 Catch:{ Exception -> 0x0218 }
    L_0x0165:
        r2 = 1;
        goto L_0x00cf;
    L_0x0168:
        r2 = r13.T;	 Catch:{ IOException -> 0x00d9 }
        if (r2 != 0) goto L_0x017b;
    L_0x016c:
        r2 = new com.uc.quark.filedownloader.services.a.d;	 Catch:{ IOException -> 0x00d9 }
        r3 = r10.getFD();	 Catch:{ IOException -> 0x00d9 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00d9 }
        r13.T = r2;	 Catch:{ IOException -> 0x00d9 }
    L_0x0177:
        r2 = r13.T;	 Catch:{ IOException -> 0x00d9 }
        goto L_0x006b;
    L_0x017b:
        r2 = r13.T;	 Catch:{ IOException -> 0x00d9 }
        r3 = r10.getFD();	 Catch:{ IOException -> 0x00d9 }
        r2.a(r3);	 Catch:{ IOException -> 0x00d9 }
        goto L_0x0177;
    L_0x0185:
        r2 = move-exception;
    L_0x0186:
        if (r14 == 0) goto L_0x018e;
    L_0x0188:
        r14.e();	 Catch:{ Throwable -> 0x0211 }
        r14.g();	 Catch:{ Throwable -> 0x0211 }
    L_0x018e:
        if (r10 == 0) goto L_0x0193;
    L_0x0190:
        r10.close();	 Catch:{ Exception -> 0x020f }
    L_0x0193:
        throw r2;
    L_0x0194:
        r2 = 0;
        goto L_0x008c;
    L_0x0197:
        r9 = 0;
        goto L_0x0093;
    L_0x019a:
        r2 = r13.a;	 Catch:{ IOException -> 0x0224 }
        if (r2 == 0) goto L_0x01b2;
    L_0x019e:
        r13.d();	 Catch:{ IOException -> 0x0224 }
        r2 = 1;
        r13.e = r2;	 Catch:{ IOException -> 0x0224 }
        if (r14 == 0) goto L_0x01ac;
    L_0x01a6:
        r14.e();	 Catch:{ Throwable -> 0x0232 }
        r14.g();	 Catch:{ Throwable -> 0x0232 }
    L_0x01ac:
        r10.close();	 Catch:{ Exception -> 0x022f }
    L_0x01af:
        r2 = 1;
        goto L_0x00cf;
    L_0x01b2:
        r2 = r13.d;	 Catch:{ IOException -> 0x0224 }
        if (r2 == 0) goto L_0x023b;
    L_0x01b6:
        if (r14 == 0) goto L_0x01be;
    L_0x01b8:
        r14.e();	 Catch:{ Throwable -> 0x022d }
        r14.g();	 Catch:{ Throwable -> 0x022d }
    L_0x01be:
        r10.close();	 Catch:{ Exception -> 0x022b }
    L_0x01c1:
        r2 = 1;
        goto L_0x00cf;
    L_0x01c4:
        r14.f();	 Catch:{ IOException -> 0x00d9 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ IOException -> 0x00d9 }
        if (r2 == 0) goto L_0x01ed;
    L_0x01cb:
        r2 = "vanda";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00d9 }
        r4 = "complete sofar = ";
        r3.<init>(r4);	 Catch:{ IOException -> 0x00d9 }
        r0 = r16;
        r3 = r3.append(r0);	 Catch:{ IOException -> 0x00d9 }
        r4 = "     threadId = ";
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x00d9 }
        r4 = r13.b;	 Catch:{ IOException -> 0x00d9 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x00d9 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x00d9 }
        android.util.Log.e(r2, r3);	 Catch:{ IOException -> 0x00d9 }
    L_0x01ed:
        r2 = r13.L;	 Catch:{ IOException -> 0x00d9 }
        r4 = -1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0208;
    L_0x01f5:
        r2 = r13.L;	 Catch:{ IOException -> 0x00d9 }
    L_0x01f7:
        r13.a(r2);	 Catch:{ IOException -> 0x00d9 }
        if (r14 == 0) goto L_0x0202;
    L_0x01fc:
        r14.e();	 Catch:{ Throwable -> 0x0229 }
        r14.g();	 Catch:{ Throwable -> 0x0229 }
    L_0x0202:
        r10.close();	 Catch:{ Exception -> 0x0227 }
    L_0x0205:
        r2 = 1;
        goto L_0x00cf;
    L_0x0208:
        r2 = r16;
        goto L_0x01f7;
    L_0x020b:
        r3 = 0;
        goto L_0x013f;
    L_0x020e:
        throw r2;	 Catch:{ all -> 0x0185 }
    L_0x020f:
        r3 = move-exception;
        goto L_0x0193;
    L_0x0211:
        r3 = move-exception;
        goto L_0x018e;
    L_0x0214:
        r2 = move-exception;
        r10 = r3;
        goto L_0x0186;
    L_0x0218:
        r2 = move-exception;
        goto L_0x0165;
    L_0x021b:
        r2 = move-exception;
        goto L_0x0160;
    L_0x021e:
        r2 = move-exception;
        r10 = r3;
        r4 = r16;
        goto L_0x00dc;
    L_0x0224:
        r2 = move-exception;
        goto L_0x00dc;
    L_0x0227:
        r2 = move-exception;
        goto L_0x0205;
    L_0x0229:
        r2 = move-exception;
        goto L_0x0202;
    L_0x022b:
        r2 = move-exception;
        goto L_0x01c1;
    L_0x022d:
        r2 = move-exception;
        goto L_0x01be;
    L_0x022f:
        r2 = move-exception;
        goto L_0x01af;
    L_0x0232:
        r2 = move-exception;
        goto L_0x01ac;
    L_0x0235:
        r2 = move-exception;
        goto L_0x00ce;
    L_0x0238:
        r2 = move-exception;
        goto L_0x00cb;
    L_0x023b:
        r16 = r4;
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.t.a(com.uc.quark.g, boolean, long, long, java.lang.String):boolean");
    }

    public final void b() {
        try {
            if (this.V != null) {
                this.V.close();
            }
            if (this.Z) {
                if (this.Y != null) {
                    this.Y.close();
                }
                if (this.X != null) {
                    this.X.close();
                }
                if (this.P != null) {
                    try {
                        this.P.e();
                        this.P.g();
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.uc.quark.g r13, java.io.InputStream r14, boolean r15, long r16, long r18, java.lang.String r20) throws java.lang.Exception {
        /*
        r12 = this;
        r2 = 0;
        r12.Z = r2;
        r12.b();
        r2 = 1;
        r12.Z = r2;
        r2 = r12.l;	 Catch:{ Exception -> 0x0087 }
        r2 = (long) r2;	 Catch:{ Exception -> 0x0087 }
        r0 = r18;
        r2 = a(r0, r2);	 Catch:{ Exception -> 0x0087 }
        r12.z = r2;	 Catch:{ Exception -> 0x0087 }
        if (r15 == 0) goto L_0x011c;
    L_0x0016:
        r2 = r12.c();	 Catch:{ Exception -> 0x0087 }
    L_0x001a:
        r4 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x0087 }
        if (r4 == 0) goto L_0x003e;
    L_0x001e:
        r4 = "vanda";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0087 }
        r6 = "threadId = ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0087 }
        r6 = r12.b;	 Catch:{ Exception -> 0x0087 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0087 }
        r6 = "   position = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0087 }
        r2 = r5.append(r2);	 Catch:{ Exception -> 0x0087 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0087 }
        android.util.Log.e(r4, r2);	 Catch:{ Exception -> 0x0087 }
    L_0x003e:
        r2 = "rw";
        r2 = r12.a(r15, r2);	 Catch:{ Exception -> 0x0087 }
        r12.X = r2;	 Catch:{ Exception -> 0x0087 }
        r2 = com.uc.quark.filedownloader.f.i.a(r14);	 Catch:{ Exception -> 0x0087 }
        r12.V = r2;	 Catch:{ Exception -> 0x0087 }
        r2 = r13 instanceof com.uc.quark.u;	 Catch:{ Exception -> 0x0087 }
        if (r2 == 0) goto L_0x0120;
    L_0x0050:
        r13 = (com.uc.quark.u) r13;	 Catch:{ Exception -> 0x0087 }
        r2 = r13.j();	 Catch:{ Exception -> 0x0087 }
        r12.Y = r2;	 Catch:{ Exception -> 0x0087 }
    L_0x0058:
        r2 = r12.S;	 Catch:{ Exception -> 0x0087 }
        r3 = r2.iterator();	 Catch:{ Exception -> 0x0087 }
    L_0x005e:
        r2 = r3.hasNext();	 Catch:{ Exception -> 0x0087 }
        if (r2 == 0) goto L_0x0143;
    L_0x0064:
        r2 = r3.next();	 Catch:{ Exception -> 0x0087 }
        r2 = (com.uc.quark.filedownloader.f.l) r2;	 Catch:{ Exception -> 0x0087 }
        if (r2 == 0) goto L_0x0083;
    L_0x006c:
        r4 = com.uc.quark.filedownloader.services.a.b.a;	 Catch:{ Exception -> 0x0087 }
        r4 = r4.a;	 Catch:{ Exception -> 0x0087 }
        r5 = 1;
        r4.removeMessages(r5, r2);	 Catch:{ Exception -> 0x0087 }
        r4 = r12.R;	 Catch:{ Exception -> 0x0087 }
        r4 = r4.contains(r2);	 Catch:{ Exception -> 0x0087 }
        if (r4 != 0) goto L_0x0083;
    L_0x007e:
        r4 = r12.R;	 Catch:{ Exception -> 0x0087 }
        r4.offer(r2);	 Catch:{ Exception -> 0x0087 }
    L_0x0083:
        r3.remove();	 Catch:{ Exception -> 0x0087 }
        goto L_0x005e;
    L_0x0087:
        r2 = move-exception;
        r4 = r16;
    L_0x008a:
        r10 = r2.toString();
        r3 = com.uc.quark.filedownloader.e.j.a;
        if (r3 == 0) goto L_0x00bc;
    L_0x0092:
        r3 = "vanda";
        r6 = new java.lang.StringBuilder;
        r7 = "fetch Exception = ";
        r6.<init>(r7);
        r6 = r6.append(r10);
        r7 = "  mBlockSize = ";
        r6 = r6.append(r7);
        r8 = r12.L;
        r6 = r6.append(r8);
        r7 = "  soFar = ";
        r6 = r6.append(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        android.util.Log.e(r3, r6);
    L_0x00bc:
        r8 = r12.W;
        r9 = 1;
        r3 = r12;
        r6 = r18;
        r3.a(r4, r6, r8, r9);
        r3 = r12.S;
        r6 = r12.W;
        r3 = r3.contains(r6);
        if (r3 != 0) goto L_0x00d6;
    L_0x00cf:
        r3 = r12.S;
        r6 = r12.W;
        r3.add(r6);
    L_0x00d6:
        r3 = android.text.TextUtils.isEmpty(r10);
        if (r3 != 0) goto L_0x00e0;
    L_0x00dc:
        r3 = r2 instanceof java.io.EOFException;
        if (r3 != 0) goto L_0x00fe;
    L_0x00e0:
        r3 = android.text.TextUtils.isEmpty(r10);
        if (r3 != 0) goto L_0x0297;
    L_0x00e6:
        r3 = "java.io.IOException: unexpected end of stream on";
        r3 = r10.contains(r3);
        if (r3 == 0) goto L_0x0297;
    L_0x00ee:
        r3 = android.text.TextUtils.isEmpty(r20);
        if (r3 != 0) goto L_0x0297;
    L_0x00f4:
        r3 = "close";
        r0 = r20;
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0297;
    L_0x00fe:
        r3 = 1;
    L_0x00ff:
        if (r3 != 0) goto L_0x0107;
    L_0x0101:
        r6 = r12.L;
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x029a;
    L_0x0107:
        r2 = r12.L;
        r6 = -1;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0115;
    L_0x010f:
        r2 = r12.L;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x011a;
    L_0x0115:
        r2 = r12.W;
        r12.a(r2, r4);
    L_0x011a:
        r2 = 1;
    L_0x011b:
        return r2;
    L_0x011c:
        r2 = 0;
        goto L_0x001a;
    L_0x0120:
        r2 = r12.T;	 Catch:{ Exception -> 0x0087 }
        if (r2 != 0) goto L_0x0137;
    L_0x0124:
        r2 = new com.uc.quark.filedownloader.services.a.d;	 Catch:{ Exception -> 0x0087 }
        r3 = r12.X;	 Catch:{ Exception -> 0x0087 }
        r3 = r3.getFD();	 Catch:{ Exception -> 0x0087 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0087 }
        r12.T = r2;	 Catch:{ Exception -> 0x0087 }
    L_0x0131:
        r2 = r12.T;	 Catch:{ Exception -> 0x0087 }
        r12.Y = r2;	 Catch:{ Exception -> 0x0087 }
        goto L_0x0058;
    L_0x0137:
        r2 = r12.T;	 Catch:{ Exception -> 0x0087 }
        r3 = r12.X;	 Catch:{ Exception -> 0x0087 }
        r3 = r3.getFD();	 Catch:{ Exception -> 0x0087 }
        r2.a(r3);	 Catch:{ Exception -> 0x0087 }
        goto L_0x0131;
    L_0x0143:
        r2 = r12.R;	 Catch:{ Exception -> 0x0087 }
        r2 = r2.size();	 Catch:{ Exception -> 0x0087 }
        if (r2 != 0) goto L_0x0161;
    L_0x014b:
        r2 = 0;
    L_0x014c:
        r3 = 5;
        if (r2 >= r3) goto L_0x0161;
    L_0x014f:
        r3 = r12.Y;	 Catch:{ Exception -> 0x0087 }
        r3 = com.uc.quark.filedownloader.f.i.a(r3);	 Catch:{ Exception -> 0x0087 }
        r3 = com.uc.quark.filedownloader.f.i.a(r3);	 Catch:{ Exception -> 0x0087 }
        r4 = r12.R;	 Catch:{ Exception -> 0x0087 }
        r4.offer(r3);	 Catch:{ Exception -> 0x0087 }
        r2 = r2 + 1;
        goto L_0x014c;
    L_0x0161:
        r2 = r12.R;	 Catch:{ Exception -> 0x0087 }
        r2 = r2.poll();	 Catch:{ Exception -> 0x0087 }
        r2 = (com.uc.quark.filedownloader.f.l) r2;	 Catch:{ Exception -> 0x0087 }
        r12.W = r2;	 Catch:{ Exception -> 0x0087 }
        r2 = r12.S;	 Catch:{ Exception -> 0x0087 }
        r3 = r12.W;	 Catch:{ Exception -> 0x0087 }
        r2.add(r3);	 Catch:{ Exception -> 0x0087 }
        r2 = r12.W;	 Catch:{ Exception -> 0x0087 }
        r2.b();	 Catch:{ Exception -> 0x0087 }
        r2 = r12.W;	 Catch:{ Exception -> 0x0087 }
        r2 = r2.a();	 Catch:{ Exception -> 0x0087 }
    L_0x017d:
        r3 = r12.V;	 Catch:{ Exception -> 0x0087 }
        r4 = i;	 Catch:{ Exception -> 0x0087 }
        r4 = (long) r4;	 Catch:{ Exception -> 0x0087 }
        r4 = r3.b(r2, r4);	 Catch:{ Exception -> 0x0087 }
        r6 = -1;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x025c;
    L_0x018c:
        r4 = r4 + r16;
        r3 = r12.a;	 Catch:{ Exception -> 0x02c4 }
        if (r3 == 0) goto L_0x01e3;
    L_0x0192:
        r8 = r12.W;	 Catch:{ Exception -> 0x02c4 }
        r9 = 1;
        r3 = r12;
        r6 = r18;
        r3.a(r4, r6, r8, r9);	 Catch:{ Exception -> 0x02c4 }
        r2 = 0;
        r12.s = r2;	 Catch:{ Exception -> 0x02c4 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x02c4 }
        if (r2 == 0) goto L_0x01c9;
    L_0x01a2:
        r2 = "On paused %d %d %d";
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x02c4 }
        r6 = 0;
        r7 = r12.D;	 Catch:{ Exception -> 0x02c4 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x02c4 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x02c4 }
        r6 = 1;
        r7 = r12.r;	 Catch:{ Exception -> 0x02c4 }
        r8 = r7.g;	 Catch:{ Exception -> 0x02c4 }
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x02c4 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x02c4 }
        r6 = 2;
        r7 = r12.r;	 Catch:{ Exception -> 0x02c4 }
        r8 = r7.h;	 Catch:{ Exception -> 0x02c4 }
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x02c4 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x02c4 }
        com.uc.quark.filedownloader.e.j.d(r12, r2, r3);	 Catch:{ Exception -> 0x02c4 }
    L_0x01c9:
        r2 = r12.u;	 Catch:{ Exception -> 0x02c4 }
        r3 = r12.r;	 Catch:{ Exception -> 0x02c4 }
        r6 = r12.r;	 Catch:{ Exception -> 0x02c4 }
        r6 = r6.g;	 Catch:{ Exception -> 0x02c4 }
        r2.c(r3, r6);	 Catch:{ Exception -> 0x02c4 }
        r2 = r12.J;	 Catch:{ Exception -> 0x02c4 }
        r3 = -2;
        r6 = r12.D;	 Catch:{ Exception -> 0x02c4 }
        r7 = 0;
        r2.a(r3, r6, r7);	 Catch:{ Exception -> 0x02c4 }
        r2 = 1;
        r12.e = r2;	 Catch:{ Exception -> 0x02c4 }
        r2 = 1;
        goto L_0x011b;
    L_0x01e3:
        r8 = r12.W;	 Catch:{ Exception -> 0x02c4 }
        r9 = 0;
        r3 = r12;
        r6 = r18;
        r3 = r3.a(r4, r6, r8, r9);	 Catch:{ Exception -> 0x02c4 }
        if (r3 == 0) goto L_0x021b;
    L_0x01ef:
        r2 = r12.R;	 Catch:{ Exception -> 0x02c4 }
        r2 = r2.poll();	 Catch:{ Exception -> 0x02c4 }
        r2 = (com.uc.quark.filedownloader.f.l) r2;	 Catch:{ Exception -> 0x02c4 }
        r12.W = r2;	 Catch:{ Exception -> 0x02c4 }
        r2 = r12.W;	 Catch:{ Exception -> 0x02c4 }
        if (r2 != 0) goto L_0x0209;
    L_0x01fd:
        r2 = r12.Y;	 Catch:{ Exception -> 0x02c4 }
        r2 = com.uc.quark.filedownloader.f.i.a(r2);	 Catch:{ Exception -> 0x02c4 }
        r2 = com.uc.quark.filedownloader.f.i.a(r2);	 Catch:{ Exception -> 0x02c4 }
        r12.W = r2;	 Catch:{ Exception -> 0x02c4 }
    L_0x0209:
        r2 = r12.W;	 Catch:{ Exception -> 0x02c4 }
        r2.b();	 Catch:{ Exception -> 0x02c4 }
        r2 = r12.S;	 Catch:{ Exception -> 0x02c4 }
        r3 = r12.W;	 Catch:{ Exception -> 0x02c4 }
        r2.add(r3);	 Catch:{ Exception -> 0x02c4 }
        r2 = r12.W;	 Catch:{ Exception -> 0x02c4 }
        r2 = r2.a();	 Catch:{ Exception -> 0x02c4 }
    L_0x021b:
        r6 = r12.L;	 Catch:{ Exception -> 0x02c4 }
        r8 = 0;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 <= 0) goto L_0x0255;
    L_0x0223:
        r6 = r12.L;	 Catch:{ Exception -> 0x02c4 }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 < 0) goto L_0x0255;
    L_0x0229:
        r2 = r12.W;	 Catch:{ Exception -> 0x02c4 }
        r12.a(r2, r4);	 Catch:{ Exception -> 0x02c4 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x02c4 }
        if (r2 == 0) goto L_0x0252;
    L_0x0232:
        r2 = "vanda";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c4 }
        r6 = "onProgress mBlockSize = ";
        r3.<init>(r6);	 Catch:{ Exception -> 0x02c4 }
        r6 = r12.L;	 Catch:{ Exception -> 0x02c4 }
        r3 = r3.append(r6);	 Catch:{ Exception -> 0x02c4 }
        r6 = "  end sofar = ";
        r3 = r3.append(r6);	 Catch:{ Exception -> 0x02c4 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x02c4 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x02c4 }
        android.util.Log.e(r2, r3);	 Catch:{ Exception -> 0x02c4 }
    L_0x0252:
        r2 = 1;
        goto L_0x011b;
    L_0x0255:
        r3 = r12.d;	 Catch:{ Exception -> 0x02c4 }
        if (r3 == 0) goto L_0x02c7;
    L_0x0259:
        r2 = 1;
        goto L_0x011b;
    L_0x025c:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x0087 }
        if (r2 == 0) goto L_0x0282;
    L_0x0260:
        r2 = "vanda";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0087 }
        r4 = "complete sofar = ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0087 }
        r0 = r16;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x0087 }
        r4 = "     threadId = ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0087 }
        r4 = r12.b;	 Catch:{ Exception -> 0x0087 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0087 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0087 }
        android.util.Log.e(r2, r3);	 Catch:{ Exception -> 0x0087 }
    L_0x0282:
        r4 = r12.W;	 Catch:{ Exception -> 0x0087 }
        r2 = r12.L;	 Catch:{ Exception -> 0x0087 }
        r6 = -1;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0294;
    L_0x028c:
        r2 = r12.L;	 Catch:{ Exception -> 0x0087 }
    L_0x028e:
        r12.a(r4, r2);	 Catch:{ Exception -> 0x0087 }
        r2 = 1;
        goto L_0x011b;
    L_0x0294:
        r2 = r16;
        goto L_0x028e;
    L_0x0297:
        r3 = 0;
        goto L_0x00ff;
    L_0x029a:
        r3 = com.uc.quark.filedownloader.e.j.a;
        if (r3 == 0) goto L_0x02be;
    L_0x029e:
        r3 = "vanda";
        r6 = new java.lang.StringBuilder;
        r7 = "removeMessages  mBlockSize = ";
        r6.<init>(r7);
        r8 = r12.L;
        r6 = r6.append(r8);
        r7 = "  soFar = ";
        r6 = r6.append(r7);
        r4 = r6.append(r4);
        r4 = r4.toString();
        android.util.Log.e(r3, r4);
    L_0x02be:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        java.lang.Thread.sleep(r4);
        throw r2;
    L_0x02c4:
        r2 = move-exception;
        goto L_0x008a;
    L_0x02c7:
        r16 = r4;
        goto L_0x017d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.t.a(com.uc.quark.g, java.io.InputStream, boolean, long, long, java.lang.String):boolean");
    }

    private static long a(long j, long j2) {
        if (j2 <= 0) {
            return -1;
        }
        if (j == -1) {
            return 1;
        }
        long j3 = j / (j2 + 1);
        return j3 <= 0 ? 1 : j3;
    }

    private void a(g gVar) {
        String str;
        if (this.x != null) {
            HashMap hashMap = this.x.a;
            if (hashMap != null) {
                if (j.a) {
                    j.f(this, "%d add outside header: %s", Integer.valueOf(this.D), hashMap);
                }
                for (Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<String> list = (List) entry.getValue();
                    if (list != null) {
                        for (String str3 : list) {
                            if (this.O || !TextUtils.equals(str2, "Referer")) {
                                gVar.a(str2, str3);
                            }
                        }
                    }
                }
            }
        }
        if (this.E != -1) {
            if (!TextUtils.isEmpty(this.r.j)) {
                if (j.a) {
                    Log.e("vanda", "If-Range = " + this.r.j);
                }
                gVar.a("If-Range", this.r.j);
            }
            StringBuilder append = new StringBuilder("bytes=").append(c());
            str3 = (this.I == -1 || this.b == this.G) ? "-" : "-" + this.I;
            str3 = append.append(str3).toString();
            gVar.a("Range", str3);
            if (j.a) {
                Log.e("vanda", "mStartPosition:" + c() + "    mEndPosition:" + this.I + "    threadId:" + this.b + "   range = " + str3);
            }
        }
    }

    private void a(long j, long j2, g gVar, boolean z) throws IOException {
        if (j != j2) {
            boolean z2;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = j - this.ac;
            long j4 = elapsedRealtime - this.ad;
            this.g = j;
            if (z || j3 >= ((long) k) || (j3 >= ((long) j) && j4 >= this.N)) {
                gVar.f();
                z2 = true;
                this.M.d = j;
                this.M.g = (byte) 3;
                this.af = j;
                this.u.b(this.M);
                this.ac = j;
                this.ad = elapsedRealtime;
            } else {
                if (this.r.f != (byte) 3) {
                    this.r.f = (byte) 3;
                }
                this.r.g = j;
                z2 = false;
            }
            if (elapsedRealtime - this.ab >= ((long) this.y)) {
                this.ab = elapsedRealtime;
                this.aa = j;
                if (j.a) {
                    j.d(this, "On progress %d %d %d %d", Integer.valueOf(this.D), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.b));
                    Log.e("vanda", "sofar = " + j + "     threadId = " + this.b);
                }
                this.J.a((byte) 3, this.D, Boolean.valueOf(z2));
            }
        }
    }

    public final synchronized void a(long j, l lVar) {
        synchronized (this.R) {
            if (this.S.contains(lVar)) {
                this.R.offer(lVar);
                this.S.remove(lVar);
                this.M.d = j;
                this.M.g = (byte) 3;
                this.af = j;
                this.u.b(this.M);
                if (j.a) {
                    new StringBuilder("threadid = ").append(this.b).append("\n").append(this.M);
                }
            }
        }
    }

    private void a(l lVar, long j) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        lVar.a((Object) this);
        lVar.a(j);
        obtain.obj = lVar;
        com.uc.quark.filedownloader.services.a.b.a.a.sendMessage(obtain);
    }

    private boolean a(long j, long j2, l lVar, boolean z) throws IOException {
        if (j == j2) {
            return false;
        }
        boolean z2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = j - this.ac;
        long j4 = elapsedRealtime - this.ad;
        this.g = j;
        if (z || j3 >= ((long) k) || (j3 >= ((long) j) && j4 >= this.N)) {
            z2 = true;
            Message obtain = Message.obtain();
            obtain.what = 1;
            lVar.a((Object) this);
            lVar.a(j);
            obtain.obj = lVar;
            com.uc.quark.filedownloader.services.a.b.a.a.sendMessage(obtain);
            this.ac = j;
            this.ad = elapsedRealtime;
        } else {
            if (this.r.f != (byte) 3) {
                this.r.f = (byte) 3;
            }
            this.r.g = j;
            z2 = false;
        }
        if (elapsedRealtime - this.ab < ((long) this.y)) {
            return z2;
        }
        this.ab = elapsedRealtime;
        this.aa = j;
        if (j.a) {
            j.d(this, "On progress %d %d %d %d", Integer.valueOf(this.D), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.b));
            Log.e("vanda", "sofar = " + j + "     threadId = " + this.b);
        }
        this.J.a((byte) 3, this.D, Boolean.valueOf(z2));
        return z2;
    }

    private void a(Throwable th, int i) {
        if (j.a) {
            j.d(this, "On retry %d %s %d %d", Integer.valueOf(this.D), th, Integer.valueOf(i), Integer.valueOf(this.w));
        }
        Throwable b = b(th);
        this.u.a(this.r, b);
        this.p = b;
        this.q = i;
        this.J.a((byte) 5, this.D, null);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }
    }

    private void a(Throwable th) {
        if (j.a) {
            j.d(this, "On error %d %s", Integer.valueOf(this.D), th);
        }
        Throwable b = b(th);
        this.ae = true;
        if (b instanceof SQLiteFullException) {
            a((SQLiteFullException) b);
        } else {
            try {
                this.M.g = (byte) -1;
                this.u.c(this.M);
                if (j.a) {
                    new StringBuilder("onError : threadid = ").append(this.b).append("\n").append(this.M);
                }
                b = th;
            } catch (SQLiteFullException e) {
                b = e;
                a((SQLiteFullException) b);
            }
        }
        this.p = b;
        this.J.a((byte) -1, this.D, this.p);
    }

    private void a(SQLiteFullException sQLiteFullException) {
        if (j.a) {
            j.d(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(this.D), sQLiteFullException.toString());
        }
        this.r.i = sQLiteFullException.toString();
        this.r.f = (byte) -1;
        this.u.b(this.D);
    }

    public final void a(long j) {
        this.e = true;
        if (j.a) {
            Log.e("vanda", "onComplete:" + j + "    threadId:" + this.b);
        }
        if (this.J.a(this.b, this.D) && !this.J.a(this.b)) {
            this.f = true;
            com.uc.quark.filedownloader.e.b.b(this.r.a(), this.r.b());
        }
        if (j.a) {
            j.d(this, "On completed %d %d %B", Integer.valueOf(this.D), Long.valueOf(j), Boolean.valueOf(this.a));
        }
        this.M.d = j;
        this.M.g = (byte) -3;
        this.u.b(this.M);
        if (j.a) {
            new StringBuilder("onComplete : threadid = ").append(this.b).append("\n").append(this.M);
        }
        this.J.a((byte) -3, this.D, null);
    }

    private void d() {
        this.s = false;
        if (j.a) {
            j.d(this, "On paused %d %d %d", Integer.valueOf(this.D), Long.valueOf(this.r.g), Long.valueOf(this.r.h));
        }
        this.M.d = this.af;
        this.u.d(this.M);
        if (j.a) {
            new StringBuilder("onPause : threadid = ").append(this.b).append("\n").append(this.M);
        }
        this.u.c(this.r, this.r.g);
        this.J.a((byte) -2, this.D, null);
    }

    private RandomAccessFile a(boolean z, String str) throws IOException {
        Object b = this.r.b();
        if (TextUtils.isEmpty(b)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        com.uc.quark.filedownloader.e.b.c();
        File file = new File(b);
        if (file.exists() && file.isDirectory()) {
            throw new RuntimeException(com.uc.quark.filedownloader.e.b.a("found invalid internal destination path[%s], & path is directory[%B]", b, Boolean.valueOf(file.isDirectory())));
        }
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new IOException(com.uc.quark.filedownloader.e.b.a("create new file error  %s", file.getAbsolutePath()));
                }
            } catch (IOException e) {
                throw new com.uc.quark.filedownloader.a.b(e.toString());
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, str);
        if (j.a) {
            Log.e("vanda", "seek:" + c() + "    threadId:" + this.b + "  append=" + z);
        }
        if (z && TextUtils.equals(str, "rw")) {
            randomAccessFile.seek(c());
        }
        return randomAccessFile;
    }

    private Throwable b(Throwable th) {
        String b = this.r.b();
        if (this.r.h != -1 || !(th instanceof IOException) || !new File(b).exists()) {
            return th;
        }
        long g = com.uc.quark.filedownloader.e.b.g(b);
        if (g > ((long) i)) {
            return th;
        }
        long j = 0;
        File file = new File(b);
        if (file.exists()) {
            j = file.length();
        } else {
            j.a(ad.class, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
        }
        if (VERSION.SDK_INT >= 9) {
            return new com.uc.quark.filedownloader.a.a(g, (long) i, j, th);
        }
        return new com.uc.quark.filedownloader.a.a(g, (long) i, j);
    }

    private boolean e() throws Exception {
        boolean z = false;
        HttpsURLConnection httpsURLConnection = null;
        try {
            String str;
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, new TrustManager[]{com.uc.quark.filedownloader.e.b.f()}, new SecureRandom());
            if (TextUtils.isEmpty(this.r.n)) {
                str = this.r.b;
            } else {
                str = this.r.n;
            }
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(com.uc.quark.filedownloader.e.b.g());
            a(httpsURLConnection);
            httpsURLConnection.connect();
            g gVar = this.P;
            InputStream inputStream = httpsURLConnection.getInputStream();
            if (httpsURLConnection.getResponseCode() == SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED) {
                z = true;
            }
            a(gVar, inputStream, z, this.c, this.K, null);
            return true;
        } finally {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
        }
    }

    private void a(HttpsURLConnection httpsURLConnection) {
        String str;
        String str2;
        if (this.x != null) {
            HashMap hashMap = this.x.a;
            if (hashMap != null) {
                if (j.a) {
                    j.f(this, "%d add outside header: %s", Integer.valueOf(this.D), hashMap);
                }
                for (Entry entry : hashMap.entrySet()) {
                    str = (String) entry.getKey();
                    List<String> list = (List) entry.getValue();
                    if (list != null) {
                        for (String str22 : list) {
                            httpsURLConnection.addRequestProperty(str, str22);
                        }
                    }
                }
            }
        }
        if (this.E != -1) {
            if (!TextUtils.isEmpty(this.r.j)) {
                httpsURLConnection.addRequestProperty("If-Match", this.r.j);
            }
            str = "Range";
            StringBuilder append = new StringBuilder("bytes=").append(c());
            str22 = (this.I == -1 || this.b == this.G) ? "-" : "-" + this.I;
            httpsURLConnection.addRequestProperty(str, append.append(str22).toString());
            if (j.a) {
                Log.e("vanda", "mStartPosition:" + c() + "    mEndPosition:" + this.I + "    threadId:" + this.b);
            }
        }
    }
}
