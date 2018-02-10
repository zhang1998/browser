package com.uc.quark.filedownloader.services;

import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.f;
import com.uc.quark.filedownloader.message.d;
import com.uc.quark.filedownloader.message.g;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.model.b;
import com.uc.quark.filedownloader.networkstate.a;
import com.uc.quark.filedownloader.networkstate.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: ProGuard */
public class ad implements g, c, Runnable {
    b a;
    volatile boolean b = false;
    final i c;
    volatile boolean d = false;
    final int e;
    private int f = 0;
    private final boolean g;
    private boolean h;
    private boolean i;
    private Throwable j;
    private int k;
    private volatile boolean l = false;
    private final com.uc.quark.ad m;
    private final int n;
    private final FileDownloadHeader o;
    private final int p;
    private long q;
    private final f r;
    private final boolean s;
    private final boolean t;
    private long u = 0;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private final Object y = new Object();

    public ad(com.uc.quark.ad adVar, f fVar, b bVar, i iVar, int i, FileDownloadHeader fileDownloadHeader, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.e = bVar.a;
        this.s = z2;
        this.t = z3;
        this.b = true;
        this.l = false;
        this.m = adVar;
        this.r = fVar;
        this.c = iVar;
        this.o = fileDownloadHeader;
        if (i2 < 5) {
            i2 = 5;
        }
        this.p = i2;
        this.f = i3;
        this.g = z;
        this.h = false;
        this.a = bVar;
        this.n = i;
        a.a.a(this);
    }

    public final boolean a() {
        return this.b || this.l;
    }

    public final boolean b() {
        return this.i;
    }

    public final Throwable c() {
        return this.j;
    }

    public final int d() {
        return this.k;
    }

    public final boolean e() {
        return this.t;
    }

    public final int f() {
        return 1;
    }

    public void run() {
        Process.setThreadPriority(10);
        this.b = false;
        this.l = true;
        if (this.a == null) {
            j.b(this, "start runnable but model == null?? %s", Integer.valueOf(this.e));
            this.a = this.c.a(this.e);
            if (this.a == null) {
                j.b(this, "start runnable but downloadMode == null?? %s", Integer.valueOf(this.e));
                return;
            }
        }
        try {
            if (this.a.f != (byte) 1) {
                if (this.a.f != (byte) -2) {
                    a(new RuntimeException(com.uc.quark.filedownloader.e.b.a("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.e), Byte.valueOf(this.a.f), Byte.valueOf((byte) 1))));
                } else if (j.a) {
                    j.d(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.e));
                }
                this.l = false;
            } else if (!this.s || com.uc.quark.filedownloader.e.b.k("android.permission.ACCESS_NETWORK_STATE")) {
                this.a.f = (byte) 6;
                a(this.a.f);
                a(this.a);
                this.l = false;
            } else {
                a(new com.uc.quark.filedownloader.a.c(com.uc.quark.filedownloader.e.b.a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.e), "android.permission.ACCESS_NETWORK_STATE")));
                this.l = false;
            }
        } finally {
            this.l = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.uc.quark.filedownloader.model.b r21) {
        /*
        r20 = this;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r16 = r3;
        r12 = r4;
    L_0x0006:
        r6 = 0;
        r0 = r20;
        r14 = r0.e;
        r0 = r20;
        r3 = r0.d;	 Catch:{ Throwable -> 0x0109 }
        if (r3 == 0) goto L_0x003b;
    L_0x0012:
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x0109 }
        if (r3 == 0) goto L_0x0032;
    L_0x0016:
        r3 = "already canceled %d %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0109 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0109 }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0109 }
        r5 = 1;
        r0 = r21;
        r6 = r0.f;	 Catch:{ Throwable -> 0x0109 }
        r6 = java.lang.Byte.valueOf(r6);	 Catch:{ Throwable -> 0x0109 }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0109 }
        r0 = r20;
        com.uc.quark.filedownloader.e.j.d(r0, r3, r4);	 Catch:{ Throwable -> 0x0109 }
    L_0x0032:
        r20.g();	 Catch:{ Throwable -> 0x0109 }
        if (r2 == 0) goto L_0x003a;
    L_0x0037:
        r2.e();	 Catch:{ Throwable -> 0x03a7 }
    L_0x003a:
        return;
    L_0x003b:
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x0109 }
        if (r3 == 0) goto L_0x0057;
    L_0x003f:
        r3 = com.uc.quark.filedownloader.services.ad.class;
        r4 = "start download %s %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0109 }
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0109 }
        r5[r8] = r9;	 Catch:{ Throwable -> 0x0109 }
        r8 = 1;
        r0 = r21;
        r9 = r0.b;	 Catch:{ Throwable -> 0x0109 }
        r5[r8] = r9;	 Catch:{ Throwable -> 0x0109 }
        com.uc.quark.filedownloader.e.j.d(r3, r4, r5);	 Catch:{ Throwable -> 0x0109 }
    L_0x0057:
        r0 = r20;
        r3 = r0.e;	 Catch:{ Throwable -> 0x0109 }
        r0 = r20;
        r4 = r0.a;	 Catch:{ Throwable -> 0x0109 }
        r3 = com.uc.quark.filedownloader.e.b.a(r3, r4);	 Catch:{ Throwable -> 0x0109 }
        if (r3 == 0) goto L_0x00ff;
    L_0x0065:
        r3 = 1;
        r0 = r20;
        r0.h = r3;	 Catch:{ Throwable -> 0x0109 }
    L_0x006a:
        if (r2 == 0) goto L_0x006f;
    L_0x006c:
        r2.e();	 Catch:{ Throwable -> 0x03aa }
    L_0x006f:
        r0 = r20;
        r3 = r0.m;	 Catch:{ Throwable -> 0x0109 }
        r3 = com.uc.quark.filedownloader.e.b.a(r3);	 Catch:{ Throwable -> 0x0109 }
        r0 = r21;
        r4 = r0.b;	 Catch:{ Throwable -> 0x0109 }
        r15 = r3.a(r4);	 Catch:{ Throwable -> 0x0109 }
        r0 = r20;
        r2 = r0.o;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x010e;
    L_0x0085:
        r0 = r20;
        r2 = r0.o;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x010e;
    L_0x008d:
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r3 == 0) goto L_0x00a9;
    L_0x0091:
        r3 = "%d add outside header: %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r5 = 0;
        r0 = r20;
        r8 = r0.e;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r4[r5] = r8;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r5 = 1;
        r4[r5] = r2;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        com.uc.quark.filedownloader.e.j.f(r0, r3, r4);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x00a9:
        r2 = r2.entrySet();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r4 = r2.iterator();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x00b1:
        r2 = r4.hasNext();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x010e;
    L_0x00b7:
        r2 = r4.next();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = r2.getKey();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.getValue();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x00b1;
    L_0x00cb:
        r5 = r2.iterator();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x00cf:
        r2 = r5.hasNext();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x00b1;
    L_0x00d5:
        r2 = r5.next();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r15.a(r3, r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        goto L_0x00cf;
    L_0x00df:
        r2 = move-exception;
        r5 = r2;
        r3 = r16;
        r2 = r15;
    L_0x00e4:
        r0 = r20;
        r6 = r0.n;	 Catch:{ all -> 0x03b0 }
        r4 = r12 + 1;
        if (r6 <= r12) goto L_0x038d;
    L_0x00ec:
        r6 = r5 instanceof com.uc.quark.filedownloader.a.c;	 Catch:{ all -> 0x03b0 }
        if (r6 != 0) goto L_0x038d;
    L_0x00f0:
        r0 = r20;
        r0.a(r5, r4);	 Catch:{ all -> 0x03b0 }
        if (r2 == 0) goto L_0x03a2;
    L_0x00f7:
        r2.e();	 Catch:{ Throwable -> 0x039c }
        r16 = r3;
        r12 = r4;
        goto L_0x0006;
    L_0x00ff:
        r3 = 0;
        r0 = r20;
        r0.h = r3;	 Catch:{ Throwable -> 0x0109 }
        r20.i();	 Catch:{ Throwable -> 0x0109 }
        goto L_0x006a;
    L_0x0109:
        r3 = move-exception;
        r5 = r3;
        r3 = r16;
        goto L_0x00e4;
    L_0x010e:
        r0 = r20;
        r2 = r0.h;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x0146;
    L_0x0114:
        r0 = r20;
        r2 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.j;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 != 0) goto L_0x012b;
    L_0x0120:
        r2 = "If-Match";
        r0 = r20;
        r3 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = r3.j;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r15.a(r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x012b:
        r2 = "Range";
        r3 = "bytes=%d-";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r5 = 0;
        r0 = r20;
        r8 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r8 = r8.g;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r4[r5] = r8;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = com.uc.quark.filedownloader.e.b.a(r3, r4);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r15.a(r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x0146:
        r4 = r15.b();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x0162;
    L_0x014e:
        r2 = "%s request header %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r5 = 0;
        r8 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3[r5] = r8;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r5 = 1;
        r3[r5] = r4;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        com.uc.quark.filedownloader.e.j.d(r0, r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x0162:
        r2 = com.uc.quark.ah.b;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = 0;
        r15.a(r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r5 = r15.d();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 != r2) goto L_0x029a;
    L_0x0170:
        r2 = 1;
        r3 = r2;
    L_0x0172:
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r5 != r2) goto L_0x029e;
    L_0x0176:
        r0 = r20;
        r2 = r0.h;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x029e;
    L_0x017c:
        r2 = 1;
        r13 = r2;
    L_0x017e:
        r0 = r20;
        r2 = r0.h;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x01a2;
    L_0x0184:
        if (r13 != 0) goto L_0x01a2;
    L_0x0186:
        r2 = "tried to resume from the break point[%d], but the response code is %d, not 206(PARTIAL).";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r9 = 0;
        r0 = r21;
        r10 = r0.g;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r8[r9] = r10;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r9 = 1;
        r10 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r8[r9] = r10;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        com.uc.quark.filedownloader.e.j.e(r0, r2, r8);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x01a2:
        if (r3 != 0) goto L_0x01a6;
    L_0x01a4:
        if (r13 == 0) goto L_0x0332;
    L_0x01a6:
        r0 = r21;
        r4 = r0.h;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = "Transfer-Encoding";
        r2 = r15.a(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r3 != 0) goto L_0x01b8;
    L_0x01b2:
        r8 = 0;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 > 0) goto L_0x01c4;
    L_0x01b8:
        if (r2 != 0) goto L_0x02a2;
    L_0x01ba:
        r3 = "Content-Length";
        r3 = r15.a(r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r4 = com.uc.quark.filedownloader.e.b.l(r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x01c4:
        r8 = 0;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x01f6;
    L_0x01ca:
        if (r2 == 0) goto L_0x02a6;
    L_0x01cc:
        r3 = "chunked";
        r2 = r2.equals(r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x02a6;
    L_0x01d4:
        r2 = 1;
    L_0x01d5:
        if (r2 != 0) goto L_0x01f6;
    L_0x01d7:
        r2 = com.uc.quark.filedownloader.e.h.a();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x02a9;
    L_0x01df:
        r4 = -1;
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x01f6;
    L_0x01e5:
        r2 = "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3[r8] = r9;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        com.uc.quark.filedownloader.e.j.d(r0, r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x01f6:
        if (r13 == 0) goto L_0x03c4;
    L_0x01f8:
        r0 = r21;
        r2 = r0.g;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r18 = r2;
    L_0x01fe:
        r2 = "Etag";
        r6 = r15.a(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x0220;
    L_0x0208:
        r2 = "etag find by header %d %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r7 = 0;
        r0 = r20;
        r8 = r0.e;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3[r7] = r8;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r7 = 1;
        r3[r7] = r6;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        com.uc.quark.filedownloader.e.j.d(r0, r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x0220:
        r0 = r20;
        r2 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.d;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x02b8;
    L_0x0228:
        r0 = r20;
        r2 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.e;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 != 0) goto L_0x02b8;
    L_0x0230:
        r2 = "Content-Disposition";
        r2 = r15.a(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r7 = com.uc.quark.filedownloader.e.b.h(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x024a;
    L_0x0240:
        r0 = r20;
        r2 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.b;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r7 = com.uc.quark.filedownloader.e.b.b(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x024a:
        r0 = r20;
        r2 = r0.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        r3 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2.a(r3, r4, r6, r7);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        r0.i = r13;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        r2 = r0.a;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r2.f;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        r0.a(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r21;
        r2 = r0.d;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x0319;
    L_0x026a:
        r0 = r21;
        r2 = r0.b;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = r21.a();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = com.uc.quark.filedownloader.e.b.a(r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r7 = r21.a();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        r8 = r0.g;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r9 = 0;
        r0 = r20;
        r10 = r0.t;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r11 = 1;
        r6 = r14;
        r3 = com.uc.quark.filedownloader.e.e.a(r6, r7, r8, r9, r10, r11);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r3 == 0) goto L_0x02ba;
    L_0x028b:
        r0 = r20;
        r2 = r0.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2.b(r14);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r15.e();	 Catch:{ Throwable -> 0x0297 }
        goto L_0x003a;
    L_0x0297:
        r2 = move-exception;
        goto L_0x003a;
    L_0x029a:
        r2 = 0;
        r3 = r2;
        goto L_0x0172;
    L_0x029e:
        r2 = 0;
        r13 = r2;
        goto L_0x017e;
    L_0x02a2:
        r4 = -1;
        goto L_0x01c4;
    L_0x02a6:
        r2 = 0;
        goto L_0x01d5;
    L_0x02a9:
        r2 = new com.uc.quark.filedownloader.a.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = "can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        throw r2;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x02b1:
        r2 = move-exception;
    L_0x02b2:
        if (r15 == 0) goto L_0x02b7;
    L_0x02b4:
        r15.e();	 Catch:{ Throwable -> 0x03ad }
    L_0x02b7:
        throw r2;
    L_0x02b8:
        r7 = 0;
        goto L_0x024a;
    L_0x02ba:
        r0 = r20;
        r3 = r0.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r3 = r3.a(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r3 == 0) goto L_0x0319;
    L_0x02c4:
        r0 = r20;
        r6 = r0.r;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r7 = 0;
        r0 = r20;
        r8 = r0.t;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r6 = com.uc.quark.filedownloader.e.e.a(r14, r3, r6, r7, r8);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r6 == 0) goto L_0x02e2;
    L_0x02d3:
        r0 = r20;
        r2 = r0.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2.b(r14);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r15.e();	 Catch:{ Throwable -> 0x02df }
        goto L_0x003a;
    L_0x02df:
        r2 = move-exception;
        goto L_0x003a;
    L_0x02e2:
        r0 = r20;
        r6 = r0.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r6.b(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r20.j();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = com.uc.quark.filedownloader.e.b.a(r2, r3);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r2 == 0) goto L_0x0319;
    L_0x02f2:
        r4 = r3.g;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r21;
        r0.g = r4;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r4 = r3.h;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r21;
        r0.a(r4);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r3.j;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r21;
        r0.a(r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r20;
        r2 = r0.c;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r0 = r21;
        r2.a(r0);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r15.e();	 Catch:{ Throwable -> 0x0315 }
        r2 = r15;
        goto L_0x0006;
    L_0x0315:
        r2 = move-exception;
        r2 = r15;
        goto L_0x0006;
    L_0x0319:
        r3 = 0;
        r2 = "Connection";
        r14 = r15.a(r2);	 Catch:{ Throwable -> 0x03b5, all -> 0x02b1 }
        r7 = r20;
        r8 = r15;
        r9 = r13;
        r10 = r18;
        r12 = r4;
        r7.a(r8, r9, r10, r12, r14);	 Catch:{ Throwable -> 0x03b5, all -> 0x02b1 }
        r15.e();	 Catch:{ Throwable -> 0x032f }
        goto L_0x003a;
    L_0x032f:
        r2 = move-exception;
        goto L_0x003a;
    L_0x0332:
        r6 = new com.uc.quark.filedownloader.a.d;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r2 = r15.c();	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        r6.<init>(r5, r4, r2);	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
        if (r16 == 0) goto L_0x033e;
    L_0x033d:
        throw r6;	 Catch:{ Throwable -> 0x00df, all -> 0x02b1 }
    L_0x033e:
        r2 = 1;
        switch(r5) {
            case 416: goto L_0x0349;
            default: goto L_0x0342;
        };
    L_0x0342:
        throw r6;	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
    L_0x0343:
        r3 = move-exception;
        r5 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x00e4;
    L_0x0349:
        r20.i();	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r3 = com.uc.quark.filedownloader.services.ad.class;
        r4 = "%d response code %d, range[%d] isn't make sense, so delete the dirty file[%s], and try to redownload it from byte-0.";
        r7 = 4;
        r7 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r7[r8] = r9;	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r8 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r7[r8] = r5;	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r5 = 2;
        r0 = r21;
        r8 = r0.g;	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r7[r5] = r8;	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r5 = 3;
        r8 = r21.b();	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r7[r5] = r8;	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        com.uc.quark.filedownloader.e.j.e(r3, r4, r7);	 Catch:{ Throwable -> 0x0343, all -> 0x02b1 }
        r3 = r12 + 1;
        r0 = r20;
        r0.a(r6, r12);	 Catch:{ Throwable -> 0x03bd, all -> 0x02b1 }
        r15.e();	 Catch:{ Throwable -> 0x0386 }
        r16 = r2;
        r12 = r3;
        r2 = r15;
        goto L_0x0006;
    L_0x0386:
        r4 = move-exception;
        r16 = r2;
        r12 = r3;
        r2 = r15;
        goto L_0x0006;
    L_0x038d:
        r0 = r20;
        r0.a(r5);	 Catch:{ all -> 0x03b0 }
        if (r2 == 0) goto L_0x003a;
    L_0x0394:
        r2.e();	 Catch:{ Throwable -> 0x0399 }
        goto L_0x003a;
    L_0x0399:
        r2 = move-exception;
        goto L_0x003a;
    L_0x039c:
        r5 = move-exception;
        r16 = r3;
        r12 = r4;
        goto L_0x0006;
    L_0x03a2:
        r16 = r3;
        r12 = r4;
        goto L_0x0006;
    L_0x03a7:
        r2 = move-exception;
        goto L_0x003a;
    L_0x03aa:
        r3 = move-exception;
        goto L_0x006f;
    L_0x03ad:
        r3 = move-exception;
        goto L_0x02b7;
    L_0x03b0:
        r3 = move-exception;
        r15 = r2;
        r2 = r3;
        goto L_0x02b2;
    L_0x03b5:
        r2 = move-exception;
        r5 = r2;
        r12 = r3;
        r3 = r16;
        r2 = r15;
        goto L_0x00e4;
    L_0x03bd:
        r4 = move-exception;
        r5 = r4;
        r12 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x00e4;
    L_0x03c4:
        r18 = r6;
        goto L_0x01fe;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.ad.a(com.uc.quark.filedownloader.model.b):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.uc.quark.g r14, boolean r15, long r16, long r18, java.lang.String r20) throws java.lang.Exception {
        /*
        r13 = this;
        r4 = 0;
        r3 = 0;
        r2 = r13.f;	 Catch:{ IOException -> 0x0076, all -> 0x00f5 }
        r6 = (long) r2;	 Catch:{ IOException -> 0x0076, all -> 0x00f5 }
        r8 = 0;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 > 0) goto L_0x004a;
    L_0x000b:
        r6 = -1;
    L_0x000d:
        r13.q = r6;	 Catch:{ IOException -> 0x0076, all -> 0x00f5 }
        r2 = "rw";
        r0 = r18;
        r11 = r13.a(r15, r0, r2);	 Catch:{ IOException -> 0x0076, all -> 0x00f5 }
        r10 = new com.uc.quark.filedownloader.services.a.a;	 Catch:{ IOException -> 0x00fe, all -> 0x00f9 }
        r10.<init>(r11);	 Catch:{ IOException -> 0x00fe, all -> 0x00f9 }
        r14.a(r10);	 Catch:{ IOException -> 0x0104 }
    L_0x001f:
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2 = r14.a(r2);	 Catch:{ IOException -> 0x0104 }
        r4 = -1;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0061;
    L_0x002b:
        r4 = r16 + r2;
        r9 = r13.d;	 Catch:{ IOException -> 0x0109 }
        r3 = r13;
        r6 = r18;
        r8 = r14;
        r3.a(r4, r6, r8, r9);	 Catch:{ IOException -> 0x0109 }
        r2 = r13.d;	 Catch:{ IOException -> 0x0109 }
        if (r2 == 0) goto L_0x0112;
    L_0x003a:
        r13.g();	 Catch:{ IOException -> 0x0109 }
        if (r14 == 0) goto L_0x0042;
    L_0x003f:
        r14.g();	 Catch:{ Exception -> 0x010f }
    L_0x0042:
        r10.close();	 Catch:{ Exception -> 0x010f }
        r11.close();	 Catch:{ Exception -> 0x010f }
    L_0x0048:
        r2 = 1;
    L_0x0049:
        return r2;
    L_0x004a:
        r8 = -1;
        r2 = (r18 > r8 ? 1 : (r18 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x0053;
    L_0x0050:
        r6 = 1;
        goto L_0x000d;
    L_0x0053:
        r8 = 1;
        r6 = r6 + r8;
        r6 = r18 / r6;
        r8 = 0;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 > 0) goto L_0x000d;
    L_0x005e:
        r6 = 1;
        goto L_0x000d;
    L_0x0061:
        r14.f();	 Catch:{ IOException -> 0x0104 }
        r0 = r16;
        r13.a(r0);	 Catch:{ IOException -> 0x0104 }
        if (r14 == 0) goto L_0x006e;
    L_0x006b:
        r14.g();	 Catch:{ Exception -> 0x010c }
    L_0x006e:
        r10.close();	 Catch:{ Exception -> 0x010c }
        r11.close();	 Catch:{ Exception -> 0x010c }
    L_0x0074:
        r2 = 1;
        goto L_0x0049;
    L_0x0076:
        r2 = move-exception;
        r10 = r3;
        r11 = r4;
        r4 = r16;
    L_0x007b:
        r12 = r2.toString();	 Catch:{ all -> 0x00e2 }
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x00e2 }
        if (r3 == 0) goto L_0x0097;
    L_0x0083:
        r3 = "vanda";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e2 }
        r7 = "fetch Exception = ";
        r6.<init>(r7);	 Catch:{ all -> 0x00e2 }
        r6 = r6.append(r12);	 Catch:{ all -> 0x00e2 }
        r6 = r6.toString();	 Catch:{ all -> 0x00e2 }
        android.util.Log.e(r3, r6);	 Catch:{ all -> 0x00e2 }
    L_0x0097:
        r9 = 1;
        r3 = r13;
        r6 = r18;
        r8 = r14;
        r3.a(r4, r6, r8, r9);	 Catch:{ all -> 0x00e2 }
        r3 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x00e2 }
        if (r3 != 0) goto L_0x00a9;
    L_0x00a5:
        r3 = r2 instanceof java.io.EOFException;	 Catch:{ all -> 0x00e2 }
        if (r3 != 0) goto L_0x00c7;
    L_0x00a9:
        r3 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x00e2 }
        if (r3 != 0) goto L_0x00df;
    L_0x00af:
        r3 = "java.io.IOException: unexpected end of stream on";
        r3 = r12.contains(r3);	 Catch:{ all -> 0x00e2 }
        if (r3 == 0) goto L_0x00df;
    L_0x00b7:
        r3 = android.text.TextUtils.isEmpty(r20);	 Catch:{ all -> 0x00e2 }
        if (r3 != 0) goto L_0x00df;
    L_0x00bd:
        r3 = "close";
        r0 = r20;
        r3 = r3.equals(r0);	 Catch:{ all -> 0x00e2 }
        if (r3 == 0) goto L_0x00df;
    L_0x00c7:
        r3 = 1;
    L_0x00c8:
        if (r3 == 0) goto L_0x00e1;
    L_0x00ca:
        r13.a(r4);	 Catch:{ all -> 0x00e2 }
        if (r14 == 0) goto L_0x00d2;
    L_0x00cf:
        r14.g();	 Catch:{ Exception -> 0x00fc }
    L_0x00d2:
        if (r10 == 0) goto L_0x00d7;
    L_0x00d4:
        r10.close();	 Catch:{ Exception -> 0x00fc }
    L_0x00d7:
        if (r11 == 0) goto L_0x00dc;
    L_0x00d9:
        r11.close();	 Catch:{ Exception -> 0x00fc }
    L_0x00dc:
        r2 = 1;
        goto L_0x0049;
    L_0x00df:
        r3 = 0;
        goto L_0x00c8;
    L_0x00e1:
        throw r2;	 Catch:{ all -> 0x00e2 }
    L_0x00e2:
        r2 = move-exception;
    L_0x00e3:
        if (r14 == 0) goto L_0x00e8;
    L_0x00e5:
        r14.g();	 Catch:{ Exception -> 0x00f3 }
    L_0x00e8:
        if (r10 == 0) goto L_0x00ed;
    L_0x00ea:
        r10.close();	 Catch:{ Exception -> 0x00f3 }
    L_0x00ed:
        if (r11 == 0) goto L_0x00f2;
    L_0x00ef:
        r11.close();	 Catch:{ Exception -> 0x00f3 }
    L_0x00f2:
        throw r2;
    L_0x00f3:
        r3 = move-exception;
        goto L_0x00f2;
    L_0x00f5:
        r2 = move-exception;
        r10 = r3;
        r11 = r4;
        goto L_0x00e3;
    L_0x00f9:
        r2 = move-exception;
        r10 = r3;
        goto L_0x00e3;
    L_0x00fc:
        r2 = move-exception;
        goto L_0x00dc;
    L_0x00fe:
        r2 = move-exception;
        r10 = r3;
        r4 = r16;
        goto L_0x007b;
    L_0x0104:
        r2 = move-exception;
        r4 = r16;
        goto L_0x007b;
    L_0x0109:
        r2 = move-exception;
        goto L_0x007b;
    L_0x010c:
        r2 = move-exception;
        goto L_0x0074;
    L_0x010f:
        r2 = move-exception;
        goto L_0x0048;
    L_0x0112:
        r16 = r4;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.ad.a(com.uc.quark.g, boolean, long, long, java.lang.String):boolean");
    }

    private void a(long j, long j2, com.uc.quark.g gVar, boolean z) throws IOException {
        if (j != j2) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = j - this.w;
            long j4 = elapsedRealtime - this.x;
            if (z || (j3 > ((long) com.uc.quark.filedownloader.e.b.a()) && j4 > com.uc.quark.filedownloader.e.b.b())) {
                gVar.f();
                this.c.a(this.a, j);
                this.w = j;
                this.x = elapsedRealtime;
            } else {
                if (this.a.f != (byte) 3) {
                    this.a.f = (byte) 3;
                }
                this.a.g = j;
            }
            if (elapsedRealtime - this.v >= ((long) this.p)) {
                this.v = elapsedRealtime;
                this.u = j;
                if (j.a) {
                    j.d(this, "On progress %d %d %d", Integer.valueOf(this.e), Long.valueOf(j), Long.valueOf(j2));
                }
                a(this.a.f);
            }
        }
    }

    private void a(Throwable th, int i) {
        if (j.a) {
            j.d(this, "On retry %d %s %d %d", Integer.valueOf(this.e), th, Integer.valueOf(i), Integer.valueOf(this.n));
        }
        Throwable b = b(th);
        this.c.a(this.a, b);
        this.j = b;
        this.k = i;
        a(this.a.f);
    }

    private void a(Throwable th) {
        if (j.a) {
            j.d(this, "On error %d %s", Integer.valueOf(this.e), th);
        }
        Throwable b = b(th);
        if (b instanceof SQLiteFullException) {
            a((SQLiteFullException) b);
        } else {
            try {
                this.c.a(this.a, b, this.a.g);
                b = th;
            } catch (SQLiteFullException e) {
                b = e;
                a((SQLiteFullException) b);
            }
        }
        this.j = b;
        a(this.a.f);
    }

    private void a(SQLiteFullException sQLiteFullException) {
        if (j.a) {
            j.d(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(this.e), sQLiteFullException.toString());
        }
        this.a.i = sQLiteFullException.toString();
        this.a.f = (byte) -1;
        this.c.b(this.e);
    }

    private void a(long j) {
        if (j.a) {
            j.d(this, "On completed %d %d %B", Integer.valueOf(this.e), Long.valueOf(j), Boolean.valueOf(this.d));
        }
        this.c.b(this.a, j);
        String b = this.a.b();
        String a = this.a.a();
        File file = new File(b);
        try {
            File file2 = new File(a);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    j.e(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", a, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IllegalStateException(com.uc.quark.filedownloader.e.b.a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", a, Long.valueOf(length)));
                }
            }
            if (file.renameTo(file2)) {
                if (file.exists() && !file.delete()) {
                    j.e(this, "delete the temp file(%s) failed, on completed downloading.", b);
                }
                a(this.a.f);
                return;
            }
            throw new IllegalStateException(com.uc.quark.filedownloader.e.b.a("Can't rename the  temp downloaded file(%s) to the target file(%s)", b, a));
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                j.e(this, "delete the temp file(%s) failed, on completed downloading.", b);
            }
        }
    }

    final void g() {
        this.l = false;
        if (j.a) {
            j.d(this, "On paused %d %d %d", Integer.valueOf(this.e), Long.valueOf(this.a.g), Long.valueOf(this.a.h));
        }
        this.c.c(this.a, this.a.g);
        a(this.a.f);
    }

    final void a(byte b) {
        synchronized (this.y) {
            com.uc.quark.filedownloader.message.b.a.a(d.a(b, this.a, this), true);
        }
    }

    private RandomAccessFile a(boolean z, long j, String str) throws IOException {
        String b = this.a.b();
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
        if (j > 0) {
            long length = randomAccessFile.length();
            long j2 = j - length;
            long g = com.uc.quark.filedownloader.e.b.g(b);
            if (g < j2) {
                randomAccessFile.close();
                throw new com.uc.quark.filedownloader.a.a(g, j2, length);
            }
            randomAccessFile.setLength(j);
        }
        if (z) {
            randomAccessFile.seek(this.a.g);
        }
        return randomAccessFile;
    }

    private void j() {
        String a = this.a.a();
        if (a != null) {
            File file = new File(a);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private Throwable b(Throwable th) {
        String b = this.a.b();
        if (this.a.h != -1 || !(th instanceof IOException) || !new File(b).exists()) {
            return th;
        }
        long g = com.uc.quark.filedownloader.e.b.g(b);
        if (g > 8192) {
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
            return new com.uc.quark.filedownloader.a.a(g, 8192, j, th);
        }
        return new com.uc.quark.filedownloader.a.a(g, 8192, j);
    }

    public final void h() {
        if (!com.uc.quark.filedownloader.e.b.e() && this.s) {
            this.d = true;
        }
    }

    private void i() {
        String b = this.a.b();
        if (b != null) {
            File file = new File(b);
            if (file.exists()) {
                file.delete();
            }
        }
        j();
    }
}
