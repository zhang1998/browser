package com.uc.quark.filedownloader.services;

import android.text.TextUtils;
import android.util.Log;
import com.uc.quark.ad;
import com.uc.quark.ah;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.f;
import com.uc.quark.filedownloader.message.g;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.networkstate.c;
import com.uc.quark.filedownloader.services.b.a;
import com.uc.quark.filedownloader.services.b.b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class ae implements f, g, c, a {
    private int A;
    private int B;
    private boolean C = true;
    private boolean D = false;
    private boolean E = false;
    private final ArrayList<t> F;
    private com.uc.quark.g G;
    private x H;
    private long I;
    private long J;
    private long K;
    String a;
    String b;
    boolean c;
    int d;
    int e;
    int f;
    boolean g;
    FileDownloadHeader h;
    boolean i;
    boolean j;
    String k;
    int l;
    int m = 0;
    int n;
    long o;
    String p = "";
    private final Object q = new Object();
    private long r = -1;
    private final i s;
    private ad t = null;
    private final b u;
    private volatile boolean v = true;
    private volatile boolean w = false;
    private volatile boolean x = false;
    private com.uc.quark.filedownloader.model.b y;
    private Throwable z;

    public ae(ad adVar, i iVar, b bVar) {
        this.s = iVar;
        this.t = adVar;
        this.u = bVar;
        this.F = new ArrayList();
        com.uc.quark.filedownloader.networkstate.a.a.a(this);
    }

    public final void g() {
        this.v = false;
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            ((t) it.next()).a = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(boolean r43, boolean r44) {
        /*
        r42 = this;
        r0 = r42;
        r0 = r0.q;
        r41 = r0;
        monitor-enter(r41);
        r0 = r42;
        r2 = r0.v;	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
    L_0x000e:
        return;
    L_0x000f:
        r0 = r42;
        r2 = r0.G;	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x0027;
    L_0x0015:
        r0 = r42;
        r2 = r0.t;	 Catch:{ IOException -> 0x05fd }
        r2 = com.uc.quark.filedownloader.e.b.a(r2);	 Catch:{ IOException -> 0x05fd }
        r3 = "http://";
        r2 = r2.a(r3);	 Catch:{ IOException -> 0x05fd }
        r0 = r42;
        r0.G = r2;	 Catch:{ IOException -> 0x05fd }
    L_0x0027:
        r0 = r42;
        r2 = r0.g;	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x002f;
    L_0x002d:
        if (r44 == 0) goto L_0x003a;
    L_0x002f:
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.l;	 Catch:{ all -> 0x00c8 }
        r2.d(r3);	 Catch:{ all -> 0x00c8 }
    L_0x003a:
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.l;	 Catch:{ all -> 0x00c8 }
        r8 = r2.a(r3);	 Catch:{ all -> 0x00c8 }
        if (r8 != 0) goto L_0x00cb;
    L_0x0048:
        r2 = 1;
        r9 = r2;
    L_0x004a:
        r0 = r42;
        r2 = r0.c;	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x009b;
    L_0x0050:
        if (r8 != 0) goto L_0x009b;
    L_0x0052:
        r0 = r42;
        r2 = r0.a;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.b;	 Catch:{ all -> 0x00c8 }
        r3 = com.uc.quark.filedownloader.e.b.i(r3);	 Catch:{ all -> 0x00c8 }
        r4 = 1;
        r2 = com.uc.quark.filedownloader.e.b.a(r2, r3, r4);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.s;	 Catch:{ all -> 0x00c8 }
        r8 = r3.a(r2);	 Catch:{ all -> 0x00c8 }
        if (r8 == 0) goto L_0x009b;
    L_0x006d:
        r0 = r42;
        r3 = r0.b;	 Catch:{ all -> 0x00c8 }
        r4 = r8.a();	 Catch:{ all -> 0x00c8 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x00c8 }
        if (r3 == 0) goto L_0x009b;
    L_0x007b:
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x00c8 }
        if (r3 == 0) goto L_0x009b;
    L_0x007f:
        r3 = "task[%d] find model by dirCaseId[%d]";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00c8 }
        r5 = 0;
        r0 = r42;
        r6 = r0.l;	 Catch:{ all -> 0x00c8 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x00c8 }
        r4[r5] = r6;	 Catch:{ all -> 0x00c8 }
        r5 = 1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00c8 }
        r4[r5] = r2;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        com.uc.quark.filedownloader.e.j.d(r0, r3, r4);	 Catch:{ all -> 0x00c8 }
    L_0x009b:
        r0 = r42;
        r2 = r0.l;	 Catch:{ all -> 0x00c8 }
        r3 = 1;
        r0 = r42;
        r4 = r0.j;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = com.uc.quark.filedownloader.e.e.a(r2, r8, r0, r3, r4);	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x00cf;
    L_0x00ac:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x00c5;
    L_0x00b0:
        r2 = "has already started download %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r0 = r42;
        r5 = r0.l;	 Catch:{ all -> 0x00c8 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x00c8 }
        r3[r4] = r5;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        com.uc.quark.filedownloader.e.j.d(r0, r2, r3);	 Catch:{ all -> 0x00c8 }
    L_0x00c5:
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x00c8:
        r2 = move-exception;
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        throw r2;
    L_0x00cb:
        r2 = 0;
        r9 = r2;
        goto L_0x004a;
    L_0x00cf:
        if (r8 == 0) goto L_0x0105;
    L_0x00d1:
        r3 = r8.a();	 Catch:{ all -> 0x00c8 }
    L_0x00d5:
        r0 = r42;
        r2 = r0.l;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r4 = r0.g;	 Catch:{ all -> 0x00c8 }
        r5 = 1;
        r0 = r42;
        r6 = r0.j;	 Catch:{ all -> 0x00c8 }
        r7 = 1;
        r2 = com.uc.quark.filedownloader.e.e.a(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x0113;
    L_0x00e9:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x0102;
    L_0x00ed:
        r2 = "has already completed downloading %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r0 = r42;
        r5 = r0.l;	 Catch:{ all -> 0x00c8 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x00c8 }
        r3[r4] = r5;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        com.uc.quark.filedownloader.e.j.d(r0, r2, r3);	 Catch:{ all -> 0x00c8 }
    L_0x0102:
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x0105:
        r0 = r42;
        r2 = r0.b;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.c;	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r3 = com.uc.quark.filedownloader.e.b.a(r2, r3, r4);	 Catch:{ all -> 0x00c8 }
        goto L_0x00d5;
    L_0x0113:
        if (r8 == 0) goto L_0x0199;
    L_0x0115:
        r2 = r8.f;	 Catch:{ all -> 0x00c8 }
        r3 = -2;
        if (r2 == r3) goto L_0x011f;
    L_0x011a:
        r2 = r8.f;	 Catch:{ all -> 0x00c8 }
        r3 = -1;
        if (r2 != r3) goto L_0x0199;
    L_0x011f:
        r2 = r8.a;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.l;	 Catch:{ all -> 0x00c8 }
        if (r2 == r3) goto L_0x0197;
    L_0x0127:
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r3 = r8.a;	 Catch:{ all -> 0x00c8 }
        r2.b(r3);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.l;	 Catch:{ all -> 0x00c8 }
        r8.a = r2;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.b;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.c;	 Catch:{ all -> 0x00c8 }
        r8.a(r2, r3);	 Catch:{ all -> 0x00c8 }
        r2 = 1;
    L_0x0142:
        r0 = r42;
        r3 = r0.p;	 Catch:{ all -> 0x00c8 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x00c8 }
        if (r3 != 0) goto L_0x0603;
    L_0x014c:
        r3 = r8.n;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r4 = r0.p;	 Catch:{ all -> 0x00c8 }
        r3 = android.text.TextUtils.equals(r3, r4);	 Catch:{ all -> 0x00c8 }
        if (r3 != 0) goto L_0x0603;
    L_0x0158:
        r0 = r42;
        r2 = r0.p;	 Catch:{ all -> 0x00c8 }
        r8.n = r2;	 Catch:{ all -> 0x00c8 }
        r2 = 1;
        r40 = r8;
    L_0x0161:
        if (r2 == 0) goto L_0x016c;
    L_0x0163:
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r2.a(r0);	 Catch:{ all -> 0x00c8 }
    L_0x016c:
        if (r9 == 0) goto L_0x017f;
    L_0x016e:
        r0 = r42;
        r2 = r0.G;	 Catch:{ all -> 0x00c8 }
        r2 = r2 instanceof com.uc.quark.ac;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x017f;
    L_0x0176:
        r0 = r42;
        r2 = r0.G;	 Catch:{ all -> 0x00c8 }
        r2 = (com.uc.quark.ac) r2;	 Catch:{ all -> 0x00c8 }
        r2.k();	 Catch:{ all -> 0x00c8 }
    L_0x017f:
        r2 = r40.d();	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r0.y = r2;	 Catch:{ all -> 0x00c8 }
        if (r43 == 0) goto L_0x01d3;
    L_0x0189:
        r2 = 1;
        r0 = r42;
        r3 = r0.l;	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r0 = r42;
        r0.a(r2, r3, r4);	 Catch:{ all -> 0x00c8 }
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x0197:
        r2 = 0;
        goto L_0x0142;
    L_0x0199:
        if (r8 != 0) goto L_0x0600;
    L_0x019b:
        r3 = new com.uc.quark.filedownloader.model.b;	 Catch:{ all -> 0x00c8 }
        r3.<init>();	 Catch:{ all -> 0x00c8 }
    L_0x01a0:
        r0 = r42;
        r2 = r0.a;	 Catch:{ all -> 0x00c8 }
        r3.b = r2;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.b;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r4 = r0.c;	 Catch:{ all -> 0x00c8 }
        r3.a(r2, r4);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.k;	 Catch:{ all -> 0x00c8 }
        r3.k = r2;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.p;	 Catch:{ all -> 0x00c8 }
        r3.n = r2;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.l;	 Catch:{ all -> 0x00c8 }
        r3.a = r2;	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r3.g = r4;	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r3.a(r4);	 Catch:{ all -> 0x00c8 }
        r2 = 1;
        r3.f = r2;	 Catch:{ all -> 0x00c8 }
        r2 = 1;
        r40 = r3;
        goto L_0x0161;
    L_0x01d3:
        r0 = r42;
        r2 = r0.G;	 Catch:{ all -> 0x00c8 }
        r2 = r2 instanceof com.uc.quark.ac;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x01e4;
    L_0x01db:
        r0 = r42;
        r2 = r0.G;	 Catch:{ all -> 0x00c8 }
        r2 = (com.uc.quark.ac) r2;	 Catch:{ all -> 0x00c8 }
        r2.l();	 Catch:{ all -> 0x00c8 }
    L_0x01e4:
        r2 = com.uc.quark.filedownloader.e.b.h();	 Catch:{ all -> 0x00c8 }
        r2 = r2 * 1024;
        r0 = r42;
        r0.A = r2;	 Catch:{ all -> 0x00c8 }
        r2 = com.uc.quark.filedownloader.e.b.i();	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r0.B = r2;	 Catch:{ all -> 0x00c8 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x0212;
    L_0x01fa:
        r2 = "vanda";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r4 = "thread block size = ";
        r3.<init>(r4);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r4 = r0.A;	 Catch:{ all -> 0x00c8 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3);	 Catch:{ all -> 0x00c8 }
    L_0x0212:
        r2 = 1;
        r0 = r42;
        r0.v = r2;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.F;	 Catch:{ all -> 0x00c8 }
        r2.clear();	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.i;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x0238;
    L_0x0224:
        r2 = com.uc.quark.filedownloader.e.b.e();	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x0238;
    L_0x022a:
        r2 = -2;
        r0 = r42;
        r3 = r0.l;	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r0 = r42;
        r0.a(r2, r3, r4);	 Catch:{ all -> 0x00c8 }
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x0238:
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r3 = r0.a;	 Catch:{ all -> 0x00c8 }
        r26 = r2.c(r3);	 Catch:{ all -> 0x00c8 }
        r4 = r40.b();	 Catch:{ all -> 0x00c8 }
        r2 = r26.size();	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x04a7;
    L_0x024e:
        if (r4 == 0) goto L_0x04a7;
    L_0x0250:
        if (r44 != 0) goto L_0x0291;
    L_0x0252:
        r0 = r42;
        r2 = r0.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r1 = r40;
        r2 = r0.b(r2, r1);	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x0291;
    L_0x0260:
        r2 = 1;
        r8 = r2;
    L_0x0262:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r6 = -1;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0294;
    L_0x026c:
        r2 = 0;
    L_0x026e:
        r0 = r40;
        r0.a(r2);	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r0.l = r8;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.C;	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r0.m = r2;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r2.a(r0);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.v;	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x0299;
    L_0x028e:
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x0291:
        r2 = 0;
        r8 = r2;
        goto L_0x0262;
    L_0x0294:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        goto L_0x026e;
    L_0x0299:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r6 = -1;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x02eb;
    L_0x02a3:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x03ee }
        r2.<init>(r4);	 Catch:{ Exception -> 0x03ee }
        r3 = r2.exists();	 Catch:{ Exception -> 0x03ee }
        if (r3 == 0) goto L_0x02ba;
    L_0x02ae:
        r6 = r2.length();	 Catch:{ Exception -> 0x03ee }
        r0 = r42;
        r10 = r0.r;	 Catch:{ Exception -> 0x03ee }
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 == 0) goto L_0x02eb;
    L_0x02ba:
        r2.createNewFile();	 Catch:{ Exception -> 0x03ee }
        r0 = r42;
        r6 = r0.r;	 Catch:{ Exception -> 0x03ee }
        r4 = com.uc.quark.filedownloader.e.b.g(r4);	 Catch:{ Exception -> 0x03ee }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 >= 0) goto L_0x02dd;
    L_0x02c9:
        r2 = -1;
        r0 = r42;
        r10 = r0.l;	 Catch:{ Exception -> 0x03ee }
        r3 = new com.uc.quark.filedownloader.a.a;	 Catch:{ Exception -> 0x03ee }
        r8 = 0;
        r3.<init>(r4, r6, r8);	 Catch:{ Exception -> 0x03ee }
        r0 = r42;
        r0.a(r2, r10, r3);	 Catch:{ Exception -> 0x03ee }
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x02dd:
        r0 = r42;
        r4 = r0.r;	 Catch:{ Exception -> 0x03ee }
        r3 = new com.uc.quark.filedownloader.services.o;	 Catch:{ Exception -> 0x03ee }
        r0 = r42;
        r3.<init>(r0);	 Catch:{ Exception -> 0x03ee }
        com.uc.quark.filedownloader.e.b.a(r2, r4);	 Catch:{ Exception -> 0x03ee }
    L_0x02eb:
        if (r8 == 0) goto L_0x0430;
    L_0x02ed:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r4 = -1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0430;
    L_0x02f7:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0430;
    L_0x0301:
        r0 = r42;
        r2 = r0.n;	 Catch:{ all -> 0x00c8 }
        if (r2 <= 0) goto L_0x030f;
    L_0x0307:
        r0 = r42;
        r2 = r0.n;	 Catch:{ all -> 0x00c8 }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r2 <= r3) goto L_0x03fc;
    L_0x030f:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r33 = com.uc.quark.filedownloader.e.b.b(r2);	 Catch:{ all -> 0x00c8 }
    L_0x0317:
        r0 = r42;
        r2 = r0.D;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x031f;
    L_0x031d:
        r33 = 1;
    L_0x031f:
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x0339;
    L_0x0323:
        r2 = "vanda";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r4 = "numThread == ";
        r3.<init>(r4);	 Catch:{ all -> 0x00c8 }
        r0 = r33;
        r3 = r3.append(r0);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3);	 Catch:{ all -> 0x00c8 }
    L_0x0339:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r0 = r33;
        r4 = (long) r0;	 Catch:{ all -> 0x00c8 }
        r14 = r2 % r4;
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r2 = r2 - r14;
        r0 = r33;
        r4 = (long) r0;	 Catch:{ all -> 0x00c8 }
        r12 = r2 / r4;
        r0 = r42;
        r2 = r0.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r1 = r40;
        r0.a(r2, r1);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r2.a(r0);	 Catch:{ all -> 0x00c8 }
        r2 = 0;
    L_0x0361:
        r0 = r33;
        if (r2 >= r0) goto L_0x0408;
    L_0x0365:
        r0 = r42;
        r0 = r0.s;	 Catch:{ all -> 0x00c8 }
        r16 = r0;
        r3 = new com.uc.quark.filedownloader.model.f;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r4 = r0.a;	 Catch:{ all -> 0x00c8 }
        r5 = r2 + 1;
        r0 = r33;
        if (r5 == r0) goto L_0x0404;
    L_0x0377:
        r5 = r12;
    L_0x0378:
        r7 = 0;
        r9 = r2 + 1;
        r0 = r40;
        r10 = r0.a;	 Catch:{ all -> 0x00c8 }
        r10 = (long) r10;	 Catch:{ all -> 0x00c8 }
        r3.<init>(r4, r5, r7, r9, r10, r12, r14);	 Catch:{ all -> 0x00c8 }
        r0 = r16;
        r0.a(r3);	 Catch:{ all -> 0x00c8 }
        r16 = new com.uc.quark.filedownloader.services.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r0 = r0.t;	 Catch:{ all -> 0x00c8 }
        r17 = r0;
        r19 = r40.d();	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r0 = r0.s;	 Catch:{ all -> 0x00c8 }
        r20 = r0;
        r0 = r42;
        r0 = r0.f;	 Catch:{ all -> 0x00c8 }
        r21 = r0;
        r0 = r42;
        r0 = r0.h;	 Catch:{ all -> 0x00c8 }
        r22 = r0;
        r0 = r42;
        r0 = r0.e;	 Catch:{ all -> 0x00c8 }
        r23 = r0;
        r0 = r42;
        r0 = r0.d;	 Catch:{ all -> 0x00c8 }
        r24 = r0;
        r0 = r42;
        r0 = r0.g;	 Catch:{ all -> 0x00c8 }
        r25 = r0;
        r0 = r42;
        r0 = r0.i;	 Catch:{ all -> 0x00c8 }
        r26 = r0;
        r0 = r42;
        r0 = r0.j;	 Catch:{ all -> 0x00c8 }
        r27 = r0;
        r32 = r2 + 1;
        r35 = 0;
        r0 = r42;
        r0 = r0.A;	 Catch:{ all -> 0x00c8 }
        r37 = r0;
        r0 = r42;
        r3 = r0.B;	 Catch:{ all -> 0x00c8 }
        r0 = (long) r3;	 Catch:{ all -> 0x00c8 }
        r38 = r0;
        r18 = r42;
        r28 = r12;
        r30 = r14;
        r34 = r42;
        r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r30, r32, r33, r34, r35, r37, r38);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.F;	 Catch:{ all -> 0x00c8 }
        r0 = r16;
        r3.add(r0);	 Catch:{ all -> 0x00c8 }
        r2 = r2 + 1;
        goto L_0x0361;
    L_0x03ee:
        r2 = move-exception;
        r3 = -1;
        r0 = r42;
        r4 = r0.l;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r0.a(r3, r4, r2);	 Catch:{ all -> 0x00c8 }
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x03fc:
        r0 = r42;
        r0 = r0.n;	 Catch:{ all -> 0x00c8 }
        r33 = r0;
        goto L_0x0317;
    L_0x0404:
        r5 = r12 + r14;
        goto L_0x0378;
    L_0x0408:
        r0 = r42;
        r2 = r0.F;	 Catch:{ all -> 0x00c8 }
        r3 = r2.iterator();	 Catch:{ all -> 0x00c8 }
    L_0x0410:
        r2 = r3.hasNext();	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x0424;
    L_0x0416:
        r2 = r3.next();	 Catch:{ all -> 0x00c8 }
        r2 = (com.uc.quark.filedownloader.services.t) r2;	 Catch:{ all -> 0x00c8 }
        r4 = 1;
        r2.setPriority(r4);	 Catch:{ all -> 0x00c8 }
        r2.start();	 Catch:{ all -> 0x00c8 }
        goto L_0x0410;
    L_0x0424:
        r0 = r42;
        r2 = r0.v;	 Catch:{ all -> 0x00c8 }
        if (r2 != 0) goto L_0x042d;
    L_0x042a:
        r42.g();	 Catch:{ all -> 0x00c8 }
    L_0x042d:
        monitor-exit(r41);	 Catch:{ all -> 0x00c8 }
        goto L_0x000e;
    L_0x0430:
        if (r8 == 0) goto L_0x043c;
    L_0x0432:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r4 = -1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x042d;
    L_0x043c:
        r0 = r42;
        r2 = r0.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r1 = r40;
        r0.a(r2, r1);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r2.a(r0);	 Catch:{ all -> 0x00c8 }
        r2 = new com.uc.quark.filedownloader.services.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.t;	 Catch:{ all -> 0x00c8 }
        r5 = r40.d();	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r6 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r7 = r0.f;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r8 = r0.h;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r9 = r0.e;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r10 = r0.d;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r11 = r0.g;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r12 = r0.i;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r13 = r0.j;	 Catch:{ all -> 0x00c8 }
        r14 = -1;
        r16 = -1;
        r18 = 1;
        r19 = 1;
        r21 = 0;
        r0 = r42;
        r0 = r0.A;	 Catch:{ all -> 0x00c8 }
        r23 = r0;
        r0 = r42;
        r4 = r0.B;	 Catch:{ all -> 0x00c8 }
        r0 = (long) r4;	 Catch:{ all -> 0x00c8 }
        r24 = r0;
        r4 = r42;
        r20 = r42;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r18, r19, r20, r21, r23, r24);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.F;	 Catch:{ all -> 0x00c8 }
        r3.add(r2);	 Catch:{ all -> 0x00c8 }
        r3 = 1;
        r2.setPriority(r3);	 Catch:{ all -> 0x00c8 }
        r2.start();	 Catch:{ all -> 0x00c8 }
        goto L_0x042d;
    L_0x04a7:
        r2 = r26.size();	 Catch:{ all -> 0x00c8 }
        if (r2 <= 0) goto L_0x042d;
    L_0x04ad:
        if (r4 == 0) goto L_0x042d;
    L_0x04af:
        r0 = r42;
        r2 = r0.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r1 = r40;
        r0.a(r2, r1);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r2 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r2.a(r0);	 Catch:{ all -> 0x00c8 }
        r2 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x04d5;
    L_0x04c7:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3 = "isFileContinue = ";
        r2.<init>(r3);	 Catch:{ all -> 0x00c8 }
        r0 = r40;
        r3 = r0.l;	 Catch:{ all -> 0x00c8 }
        r2.append(r3);	 Catch:{ all -> 0x00c8 }
    L_0x04d5:
        r0 = r40;
        r2 = r0.l;	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x059a;
    L_0x04db:
        r27 = r26.iterator();	 Catch:{ all -> 0x00c8 }
    L_0x04df:
        r2 = r27.hasNext();	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x055e;
    L_0x04e5:
        r2 = r27.next();	 Catch:{ all -> 0x00c8 }
        r0 = r2;
        r0 = (com.uc.quark.filedownloader.model.f) r0;	 Catch:{ all -> 0x00c8 }
        r4 = r0;
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0506;
    L_0x04f7:
        r2 = r4.h;	 Catch:{ all -> 0x00c8 }
        r5 = r26.size();	 Catch:{ all -> 0x00c8 }
        r6 = (long) r5;	 Catch:{ all -> 0x00c8 }
        r2 = r2 * r6;
        r6 = r4.i;	 Catch:{ all -> 0x00c8 }
        r2 = r2 + r6;
        r0 = r42;
        r0.r = r2;	 Catch:{ all -> 0x00c8 }
    L_0x0506:
        r2 = new com.uc.quark.filedownloader.services.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.t;	 Catch:{ all -> 0x00c8 }
        r5 = r40.d();	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r6 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r7 = r0.f;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r8 = r0.h;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r9 = r0.e;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r10 = r0.d;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r11 = r0.g;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r12 = r0.i;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r13 = r0.j;	 Catch:{ all -> 0x00c8 }
        r14 = r4.h;	 Catch:{ all -> 0x00c8 }
        r0 = r4.i;	 Catch:{ all -> 0x00c8 }
        r16 = r0;
        r0 = r4.e;	 Catch:{ all -> 0x00c8 }
        r18 = r0;
        r19 = r26.size();	 Catch:{ all -> 0x00c8 }
        r0 = r4.d;	 Catch:{ all -> 0x00c8 }
        r21 = r0;
        r0 = r42;
        r0 = r0.A;	 Catch:{ all -> 0x00c8 }
        r23 = r0;
        r0 = r42;
        r4 = r0.B;	 Catch:{ all -> 0x00c8 }
        r0 = (long) r4;	 Catch:{ all -> 0x00c8 }
        r24 = r0;
        r4 = r42;
        r20 = r42;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r18, r19, r20, r21, r23, r24);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.F;	 Catch:{ all -> 0x00c8 }
        r3.add(r2);	 Catch:{ all -> 0x00c8 }
        goto L_0x04df;
    L_0x055e:
        r0 = r42;
        r2 = r0.r;	 Catch:{ all -> 0x00c8 }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0570;
    L_0x0568:
        r0 = r40;
        r2 = r0.h;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r0.r = r2;	 Catch:{ all -> 0x00c8 }
    L_0x0570:
        r0 = r42;
        r2 = r0.F;	 Catch:{ all -> 0x00c8 }
        r3 = r2.iterator();	 Catch:{ all -> 0x00c8 }
    L_0x0578:
        r2 = r3.hasNext();	 Catch:{ all -> 0x00c8 }
        if (r2 == 0) goto L_0x042d;
    L_0x057e:
        r2 = r3.next();	 Catch:{ all -> 0x00c8 }
        r2 = (com.uc.quark.filedownloader.services.t) r2;	 Catch:{ all -> 0x00c8 }
        r4 = r2.c;	 Catch:{ all -> 0x00c8 }
        r6 = r2.a();	 Catch:{ all -> 0x00c8 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0596;
    L_0x058e:
        r4 = 1;
        r2.setPriority(r4);	 Catch:{ all -> 0x00c8 }
        r2.start();	 Catch:{ all -> 0x00c8 }
        goto L_0x0578;
    L_0x0596:
        r4 = 1;
        r2.e = r4;	 Catch:{ all -> 0x00c8 }
        goto L_0x0578;
    L_0x059a:
        r2 = new com.uc.quark.filedownloader.services.t;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.t;	 Catch:{ all -> 0x00c8 }
        r5 = r40.d();	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r6 = r0.s;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r7 = r0.f;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r8 = r0.h;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r9 = r0.e;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r10 = r0.d;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r11 = r0.g;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r12 = r0.i;	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r13 = r0.j;	 Catch:{ all -> 0x00c8 }
        r14 = -1;
        r16 = -1;
        r18 = 1;
        r19 = 1;
        r4 = 0;
        r0 = r26;
        r4 = r0.get(r4);	 Catch:{ all -> 0x00c8 }
        r4 = (com.uc.quark.filedownloader.model.f) r4;	 Catch:{ all -> 0x00c8 }
        r0 = r4.d;	 Catch:{ all -> 0x00c8 }
        r21 = r0;
        r0 = r42;
        r0 = r0.A;	 Catch:{ all -> 0x00c8 }
        r23 = r0;
        r0 = r42;
        r4 = r0.B;	 Catch:{ all -> 0x00c8 }
        r0 = (long) r4;	 Catch:{ all -> 0x00c8 }
        r24 = r0;
        r4 = r42;
        r20 = r42;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r18, r19, r20, r21, r23, r24);	 Catch:{ all -> 0x00c8 }
        r0 = r42;
        r3 = r0.F;	 Catch:{ all -> 0x00c8 }
        r3.add(r2);	 Catch:{ all -> 0x00c8 }
        r3 = 1;
        r2.setPriority(r3);	 Catch:{ all -> 0x00c8 }
        r2.start();	 Catch:{ all -> 0x00c8 }
        goto L_0x042d;
    L_0x05fd:
        r2 = move-exception;
        goto L_0x0027;
    L_0x0600:
        r3 = r8;
        goto L_0x01a0;
    L_0x0603:
        r40 = r8;
        goto L_0x0161;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.ae.a(boolean, boolean):void");
    }

    public final boolean a(int i, int i2) {
        boolean z;
        synchronized (this.q) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                if (tVar.b != i && !tVar.e) {
                    z = false;
                    break;
                }
            }
            this.u.a(i2);
            z = true;
        }
        return z;
    }

    public final boolean a(int i) {
        synchronized (this.q) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                if (tVar.b != i && tVar.f) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void a() {
        if (j.a) {
            Log.e("vanda", "resetTask");
        }
        synchronized (this.q) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                tVar.d = true;
                tVar.interrupt();
            }
            this.F.clear();
            a(false, true);
        }
    }

    public final void h() {
        if (!com.uc.quark.filedownloader.e.b.e() && com.uc.quark.filedownloader.contentprovider.a.e() && this.i) {
            this.E = true;
            g();
            com.uc.quark.filedownloader.networkstate.b bVar = com.uc.quark.filedownloader.networkstate.a.a;
            if (this != null) {
                int size = bVar.a.size() - 1;
                while (size >= 0) {
                    if (((c) ((WeakReference) bVar.a.get(size)).get()) == this && size <= bVar.a.size()) {
                        bVar.a.remove(size);
                    }
                    size--;
                }
            }
            try {
                com.uc.quark.g a = com.uc.quark.filedownloader.e.b.a(this.t).a("http://");
                if (a instanceof com.uc.quark.f) {
                    ((com.uc.quark.f) a).a();
                }
            } catch (IOException e) {
            }
        }
    }

    public final void a(byte b, int i, Object obj) {
        synchronized (this.q) {
            if (this.v || b == (byte) -2) {
                byte b2;
                if (this.E && (byte) -2 == b) {
                    this.u.a(i);
                    b2 = (byte) -5;
                } else {
                    b2 = b;
                }
                if (b2 == (byte) 2) {
                    if (this.w) {
                        return;
                    }
                    this.w = true;
                }
                if (this.x) {
                    return;
                }
                if (b2 == (byte) -1) {
                    if (obj instanceof Throwable) {
                        this.z = (Throwable) obj;
                    }
                    this.x = true;
                    g();
                    this.u.a(i);
                }
                Iterator it = this.F.iterator();
                long j = 0;
                byte b3 = b2;
                int i2 = 0;
                while (it.hasNext()) {
                    t tVar = (t) it.next();
                    j += tVar.g;
                    if (tVar.e) {
                        i2++;
                    } else {
                        byte b4;
                        if (b3 == (byte) -3) {
                            b4 = (byte) 3;
                        } else {
                            b4 = b3;
                        }
                        b3 = b4;
                    }
                }
                if (i2 == this.F.size() && b3 == (byte) -3) {
                    b3 = (byte) -3;
                }
                if (b3 != (byte) 1) {
                    this.y.f = b3;
                }
                if (b2 == (byte) 6) {
                    this.I = System.currentTimeMillis();
                    this.K = j;
                }
                if (b3 == (byte) 3) {
                    this.J = System.currentTimeMillis();
                    long j2 = this.J - this.I;
                    if (j2 >= 1000 && j > this.K) {
                        this.y.o = (j - this.K) / (j2 - 20);
                        this.I = this.J;
                        this.K = j;
                    }
                }
                if (!(b2 == (byte) 6 || b2 == (byte) 1)) {
                    this.y.g = j;
                }
                if (this.y.h <= 0) {
                    this.y.a(this.r);
                }
                if (this.H == null) {
                    this.H = new x(this.s);
                }
                this.H.a = b3;
                this.H.b = this.y;
                this.H.c = this;
                this.H.e = obj;
                this.H.f = this.G;
                b.a.a(this.H);
                return;
            }
        }
    }

    public final boolean a(com.uc.quark.filedownloader.model.b bVar) {
        return false;
    }

    private void a(ad adVar, com.uc.quark.filedownloader.model.b bVar) {
        String str;
        com.uc.quark.g a;
        com.uc.quark.g gVar;
        Throwable th;
        Object obj = null;
        String str2 = bVar.k;
        if (!TextUtils.isEmpty(str2)) {
            obj = 1;
        }
        if (TextUtils.isEmpty(bVar.n)) {
            str = bVar.b;
        } else {
            str = bVar.n;
        }
        try {
            a = com.uc.quark.filedownloader.e.b.a(adVar).a(str);
            try {
                String str3;
                a(a, false, 0);
                a.a(obj != null ? ah.a : ah.b, str2);
                String a2 = a.a("ETag");
                str2 = a.a("Last-Modified");
                if (TextUtils.isEmpty(a2)) {
                    str3 = str2;
                } else {
                    str3 = a2;
                }
                bVar.a(str3);
                if (j.a) {
                    Log.e("vanda", "updateEtag tag = " + a2 + "  lastModified = " + str2);
                }
                try {
                    a.e();
                    a.g();
                } catch (Throwable th2) {
                }
            } catch (Exception e) {
                gVar = a;
                if (gVar != null) {
                    try {
                        gVar.e();
                        gVar.g();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (a != null) {
                    try {
                        a.e();
                        a.g();
                    } catch (Throwable th5) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            gVar = null;
            if (gVar != null) {
                gVar.e();
                gVar.g();
            }
        } catch (Throwable th6) {
            th = th6;
            a = null;
            if (a != null) {
                a.e();
                a.g();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.uc.quark.ad r13, com.uc.quark.filedownloader.model.b r14) {
        /*
        r12 = this;
        r4 = 0;
        r7 = r14.k;
        r0 = android.text.TextUtils.isEmpty(r7);
        if (r0 != 0) goto L_0x013c;
    L_0x0009:
        r0 = 1;
    L_0x000a:
        r1 = r14.n;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x013f;
    L_0x0012:
        r1 = r14.b;
    L_0x0014:
        r2 = 0;
        r3 = com.uc.quark.filedownloader.e.b.a(r13);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r2 = r3.a(r1);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = 0;
        r8 = 0;
        r12.a(r2, r3, r8);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        if (r0 == 0) goto L_0x0143;
    L_0x0025:
        r3 = com.uc.quark.ah.a;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
    L_0x0027:
        r2.a(r3, r7);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = "ETag";
        r5 = r2.a(r3);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = "Last-Modified";
        r6 = r2.a(r3);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        if (r3 != 0) goto L_0x0147;
    L_0x003c:
        r3 = r5;
    L_0x003d:
        r14.a(r3);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        if (r3 == 0) goto L_0x0062;
    L_0x0044:
        r3 = "vanda";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r9 = "getFileName tag = ";
        r8.<init>(r9);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r8.append(r5);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r8 = "  lastModified = ";
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.toString();	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        android.util.Log.e(r3, r5);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
    L_0x0062:
        r3 = "Content-Length";
        r3 = r2.a(r3);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r8 = com.uc.quark.filedownloader.e.b.l(r3);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r12.r = r8;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        if (r3 == 0) goto L_0x0092;
    L_0x0072:
        r3 = "vanda";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r6 = "Content-Length = ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r8 = r12.r;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r6 = "  isPost = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.toString();	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        android.util.Log.e(r3, r5);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
    L_0x0092:
        r8 = r12.o;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r10 = -1;
        r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r3 == 0) goto L_0x00fc;
    L_0x009a:
        r8 = r12.r;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r10 = r12.o;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r3 == 0) goto L_0x00fc;
    L_0x00a2:
        r3 = 0;
        r12.C = r3;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = com.uc.quark.filedownloader.e.b.a(r13);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r2 = r3.a(r1);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = 0;
        r8 = 0;
        r12.a(r2, r3, r8);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        if (r0 == 0) goto L_0x014a;
    L_0x00b5:
        r3 = com.uc.quark.ah.a;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
    L_0x00b7:
        r2.a(r3, r7);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = "Content-Length";
        r3 = r2.a(r3);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r8 = com.uc.quark.filedownloader.e.b.l(r3);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r12.r = r8;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        if (r3 == 0) goto L_0x00fc;
    L_0x00ca:
        r3 = "vanda";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r6 = "fileSize=";
        r5.<init>(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r8 = r12.r;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r6 = "    ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r8 = r12.r;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r6 = (float) r8;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r8 = 1233125376; // 0x49800000 float:1048576.0 double:6.092448853E-315;
        r6 = r6 / r8;
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r6 = "MB  mIsHasRefer = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r6 = r12.C;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        r5 = r5.toString();	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        android.util.Log.e(r3, r5);	 Catch:{ Exception -> 0x014e, all -> 0x015a }
    L_0x00fc:
        r2.e();	 Catch:{ Throwable -> 0x03a2 }
        r2.g();	 Catch:{ Throwable -> 0x03a2 }
    L_0x0102:
        r2 = com.uc.quark.filedownloader.e.j.a;
        if (r2 == 0) goto L_0x0132;
    L_0x0106:
        r2 = "vanda";
        r3 = new java.lang.StringBuilder;
        r5 = "fileSize  = ";
        r3.<init>(r5);
        r8 = r12.r;
        r3 = r3.append(r8);
        r5 = "    ";
        r3 = r3.append(r5);
        r8 = r12.r;
        r5 = (float) r8;
        r6 = 1233125376; // 0x49800000 float:1048576.0 double:6.092448853E-315;
        r5 = r5 / r6;
        r3 = r3.append(r5);
        r5 = "MB";
        r3 = r3.append(r5);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x0132:
        r2 = r12.r;
        r8 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 > 0) goto L_0x0164;
    L_0x013a:
        r0 = 0;
    L_0x013b:
        return r0;
    L_0x013c:
        r0 = 0;
        goto L_0x000a;
    L_0x013f:
        r1 = r14.n;
        goto L_0x0014;
    L_0x0143:
        r3 = com.uc.quark.ah.b;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        goto L_0x0027;
    L_0x0147:
        r3 = r6;
        goto L_0x003d;
    L_0x014a:
        r3 = com.uc.quark.ah.b;	 Catch:{ Exception -> 0x014e, all -> 0x015a }
        goto L_0x00b7;
    L_0x014e:
        r3 = move-exception;
        if (r2 == 0) goto L_0x0102;
    L_0x0151:
        r2.e();	 Catch:{ Throwable -> 0x0158 }
        r2.g();	 Catch:{ Throwable -> 0x0158 }
        goto L_0x0102;
    L_0x0158:
        r2 = move-exception;
        goto L_0x0102;
    L_0x015a:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0163;
    L_0x015d:
        r2.e();	 Catch:{ Throwable -> 0x039f }
        r2.g();	 Catch:{ Throwable -> 0x039f }
    L_0x0163:
        throw r0;
    L_0x0164:
        r2 = 0;
        r3 = com.uc.quark.filedownloader.e.b.a(r13);	 Catch:{ Exception -> 0x0393, all -> 0x02fd }
        r3 = r3.a(r1);	 Catch:{ Exception -> 0x0393, all -> 0x02fd }
        r2 = 1;
        r8 = -1;
        r12.a(r3, r2, r8);	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        if (r0 == 0) goto L_0x0293;
    L_0x0175:
        r2 = com.uc.quark.ah.a;	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
    L_0x0177:
        r3.a(r2, r7);	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        r2 = r3.d();	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        r5 = "Transfer-Encoding";
        r5 = r3.a(r5);	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        r6 = "chunked";
        r6 = android.text.TextUtils.equals(r5, r6);	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        if (r6 == 0) goto L_0x0297;
    L_0x018c:
        r8 = -1;
        r12.r = r8;	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        r2 = 0;
    L_0x0191:
        r4 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        if (r4 == 0) goto L_0x01cf;
    L_0x0195:
        r4 = "vanda";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = "fileSize=";
        r5.<init>(r6);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r8 = r12.r;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r5 = r5.append(r8);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = "    ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r8 = r12.r;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = (float) r8;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r8 = 1233125376; // 0x49800000 float:1048576.0 double:6.092448853E-315;
        r6 = r6 / r8;
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = "MB  isPost = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = " isSupportSeek = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r5 = r5.append(r2);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        android.util.Log.e(r4, r5);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
    L_0x01cf:
        r3.e();	 Catch:{ Throwable -> 0x039c }
        r3.g();	 Catch:{ Throwable -> 0x039c }
    L_0x01d5:
        r3 = 0;
        r4 = 0;
        r5 = com.uc.quark.filedownloader.e.b.a(r13);	 Catch:{ Exception -> 0x0382, all -> 0x0373 }
        r4 = r5.a(r1);	 Catch:{ Exception -> 0x0382, all -> 0x0373 }
        r1 = 1;
        r8 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r12.a(r4, r1, r8);	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        if (r0 == 0) goto L_0x0308;
    L_0x01e7:
        r1 = com.uc.quark.ah.a;	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
    L_0x01e9:
        r4.a(r1, r7);	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        r1 = r4.d();	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        r5 = "Transfer-Encoding";
        r5 = r4.a(r5);	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        r6 = "chunked";
        r6 = android.text.TextUtils.equals(r5, r6);	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        if (r6 == 0) goto L_0x030c;
    L_0x01fe:
        r6 = -1;
        r12.r = r6;	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        r1 = 0;
    L_0x0203:
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        if (r3 == 0) goto L_0x0241;
    L_0x0207:
        r3 = "vanda";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = "fileSize=";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = r12.r;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = "    ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = r12.r;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = (float) r6;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r7 = 1233125376; // 0x49800000 float:1048576.0 double:6.092448853E-315;
        r6 = r6 / r7;
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = "MB  isPost = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r5 = r5.append(r0);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = " isSeek0_1024 = ";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r5 = r5.append(r1);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        android.util.Log.e(r3, r5);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
    L_0x0241:
        r4.e();	 Catch:{ Throwable -> 0x038a }
        r4.g();	 Catch:{ Throwable -> 0x038a }
    L_0x0247:
        if (r1 == 0) goto L_0x024b;
    L_0x0249:
        if (r2 != 0) goto L_0x024e;
    L_0x024b:
        r3 = 1;
        r12.D = r3;
    L_0x024e:
        r3 = com.uc.quark.filedownloader.e.j.a;
        if (r3 == 0) goto L_0x028c;
    L_0x0252:
        r3 = "vanda";
        r4 = new java.lang.StringBuilder;
        r5 = "fileSize=";
        r4.<init>(r5);
        r6 = r12.r;
        r4 = r4.append(r6);
        r5 = "    ";
        r4 = r4.append(r5);
        r6 = r12.r;
        r5 = (float) r6;
        r6 = 1233125376; // 0x49800000 float:1048576.0 double:6.092448853E-315;
        r5 = r5 / r6;
        r4 = r4.append(r5);
        r5 = "MB  isPost = ";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r4 = "   seek = ";
        r0 = r0.append(r4);
        r0 = r0.append(r2);
        r0 = r0.toString();
        android.util.Log.e(r3, r0);
    L_0x028c:
        if (r2 != 0) goto L_0x0290;
    L_0x028e:
        if (r1 == 0) goto L_0x037d;
    L_0x0290:
        r0 = 1;
        goto L_0x013b;
    L_0x0293:
        r2 = com.uc.quark.ah.b;	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        goto L_0x0177;
    L_0x0297:
        r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r2 != r6) goto L_0x02fb;
    L_0x029b:
        r2 = "Content-Range";
        r2 = r3.a(r2);	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0398, all -> 0x0390 }
        if (r2 != 0) goto L_0x02fb;
    L_0x02a7:
        r2 = 1;
    L_0x02a8:
        r4 = "Content-Length";
        r4 = r3.a(r4);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r8 = com.uc.quark.filedownloader.e.b.l(r4);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r4 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        if (r4 == 0) goto L_0x02de;
    L_0x02b6:
        r4 = "vanda";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r10 = "transferEncoding=";
        r6.<init>(r10);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = r6.append(r5);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r10 = "    content-length=";
        r6 = r6.append(r10);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = r6.append(r8);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r10 = "   isSupportSeek = ";
        r6 = r6.append(r10);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = r6.append(r2);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        android.util.Log.e(r4, r6);	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
    L_0x02de:
        r10 = 0;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 > 0) goto L_0x02e5;
    L_0x02e4:
        r2 = 0;
    L_0x02e5:
        if (r5 == 0) goto L_0x0191;
    L_0x02e7:
        r4 = -1;
        r12.r = r4;	 Catch:{ Exception -> 0x02ed, all -> 0x0390 }
        goto L_0x0191;
    L_0x02ed:
        r4 = move-exception;
    L_0x02ee:
        if (r3 == 0) goto L_0x01d5;
    L_0x02f0:
        r3.e();	 Catch:{ Throwable -> 0x02f8 }
        r3.g();	 Catch:{ Throwable -> 0x02f8 }
        goto L_0x01d5;
    L_0x02f8:
        r3 = move-exception;
        goto L_0x01d5;
    L_0x02fb:
        r2 = 0;
        goto L_0x02a8;
    L_0x02fd:
        r0 = move-exception;
        r3 = r2;
    L_0x02ff:
        if (r3 == 0) goto L_0x0307;
    L_0x0301:
        r3.e();	 Catch:{ Throwable -> 0x038d }
        r3.g();	 Catch:{ Throwable -> 0x038d }
    L_0x0307:
        throw r0;
    L_0x0308:
        r1 = com.uc.quark.ah.b;	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        goto L_0x01e9;
    L_0x030c:
        r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r1 != r6) goto L_0x0371;
    L_0x0310:
        r1 = "Content-Range";
        r1 = r4.a(r1);	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0386, all -> 0x0373 }
        if (r1 != 0) goto L_0x0371;
    L_0x031c:
        r1 = 1;
    L_0x031d:
        r3 = "Content-Length";
        r3 = r4.a(r3);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r6 = com.uc.quark.filedownloader.e.b.l(r3);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r3 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        if (r3 == 0) goto L_0x0353;
    L_0x032b:
        r3 = "vanda";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r9 = "transferEncoding=";
        r8.<init>(r9);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r8 = r8.append(r5);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r9 = "    content-length=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r8 = r8.append(r6);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r9 = "   isSeek0_1024 = ";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r8 = r8.append(r1);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        android.util.Log.e(r3, r8);	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
    L_0x0353:
        r8 = 0;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 > 0) goto L_0x035a;
    L_0x0359:
        r1 = 0;
    L_0x035a:
        if (r5 == 0) goto L_0x0203;
    L_0x035c:
        r6 = -1;
        r12.r = r6;	 Catch:{ Exception -> 0x0362, all -> 0x0373 }
        goto L_0x0203;
    L_0x0362:
        r3 = move-exception;
        r3 = r4;
    L_0x0364:
        if (r3 == 0) goto L_0x0247;
    L_0x0366:
        r3.e();	 Catch:{ Throwable -> 0x036e }
        r3.g();	 Catch:{ Throwable -> 0x036e }
        goto L_0x0247;
    L_0x036e:
        r3 = move-exception;
        goto L_0x0247;
    L_0x0371:
        r1 = 0;
        goto L_0x031d;
    L_0x0373:
        r0 = move-exception;
        if (r4 == 0) goto L_0x037c;
    L_0x0376:
        r4.e();	 Catch:{ Throwable -> 0x0380 }
        r4.g();	 Catch:{ Throwable -> 0x0380 }
    L_0x037c:
        throw r0;
    L_0x037d:
        r0 = 0;
        goto L_0x013b;
    L_0x0380:
        r1 = move-exception;
        goto L_0x037c;
    L_0x0382:
        r1 = move-exception;
        r1 = r3;
        r3 = r4;
        goto L_0x0364;
    L_0x0386:
        r1 = move-exception;
        r1 = r3;
        r3 = r4;
        goto L_0x0364;
    L_0x038a:
        r3 = move-exception;
        goto L_0x0247;
    L_0x038d:
        r1 = move-exception;
        goto L_0x0307;
    L_0x0390:
        r0 = move-exception;
        goto L_0x02ff;
    L_0x0393:
        r3 = move-exception;
        r3 = r2;
        r2 = r4;
        goto L_0x02ee;
    L_0x0398:
        r2 = move-exception;
        r2 = r4;
        goto L_0x02ee;
    L_0x039c:
        r3 = move-exception;
        goto L_0x01d5;
    L_0x039f:
        r1 = move-exception;
        goto L_0x0163;
    L_0x03a2:
        r2 = move-exception;
        goto L_0x0102;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.ae.b(com.uc.quark.ad, com.uc.quark.filedownloader.model.b):boolean");
    }

    private void a(com.uc.quark.g gVar, boolean z, long j) {
        if (this.h != null) {
            HashMap hashMap = this.h.a;
            if (hashMap != null) {
                for (Entry entry : hashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    List<String> list = (List) entry.getValue();
                    if (list != null) {
                        for (String str2 : list) {
                            if (this.C || !TextUtils.equals(str, "Referer")) {
                                gVar.a(str, str2);
                            }
                        }
                    }
                }
            }
            if (z) {
                gVar.a("Range", "bytes=0-" + (j == -1 ? "" : Long.valueOf(j)));
            }
        }
    }

    public final boolean e() {
        return this.j;
    }

    public final Throwable c() {
        return this.z;
    }

    public final int d() {
        return this.f;
    }

    public final boolean b() {
        return this.v;
    }

    public final int f() {
        return this.m;
    }

    public final void i() {
        b.a.a(new aa(this));
    }

    public final void j() {
        b.a.a(new ab(this));
    }
}
