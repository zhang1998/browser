package com.bumptech.glide.b.b;

import android.support.v4.d.q;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.b.i;
import com.bumptech.glide.b.m;
import com.bumptech.glide.e;
import com.bumptech.glide.g;
import com.bumptech.glide.util.a.f;
import com.bumptech.glide.util.a.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class o<R> implements d, f, Comparable<o<?>>, Runnable {
    private Object A;
    private a B;
    private c<?> C;
    private volatile boolean D;
    public final f<R> a = new f();
    public final k b;
    final j<?> c = new j();
    final l d = new l();
    public e e;
    public i f;
    public g g;
    public ak h;
    public int i;
    public int j;
    public w k;
    public m l;
    public h<R> m;
    public int n;
    public m o;
    public boolean p;
    i q;
    public volatile e r;
    public volatile boolean s;
    private final List<Exception> t = new ArrayList();
    private final j u = new com.bumptech.glide.util.a.i();
    private final q<o<?>> v;
    private n w;
    private long x;
    private Thread y;
    private i z;

    public final void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00a1 in list [B:20:0x006c, B:39:0x000c]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = "DecodeJob#run";
        android.support.v4.os.e.a(r0);
        r0 = r3.s;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        if (r0 == 0) goto L_0x0019;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x0009:
        r3.g();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r0 = r3.C;
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        r0 = r3.C;
        r0.a();
    L_0x0015:
        android.support.v4.os.e.a();
    L_0x0018:
        return;
    L_0x0019:
        r0 = com.bumptech.glide.b.b.g.a;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = r3.o;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = r1.ordinal();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r0 = r0[r1];	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        switch(r0) {
            case 1: goto L_0x007b;
            case 2: goto L_0x0099;
            case 3: goto L_0x009d;
            default: goto L_0x0026;
        };	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x0026:
        r0 = new java.lang.IllegalStateException;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = "Unrecognized run reason: ";	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1.<init>(r2);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = r3.o;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = r1.append(r2);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = r1.toString();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        throw r0;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x003d:
        r0 = move-exception;
        r1 = "DecodeJob";	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = 3;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        if (r1 == 0) goto L_0x005f;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x0047:
        r1 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = "DecodeJob threw unexpectedly, isCancelled: ";	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1.<init>(r2);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = r3.s;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = r1.append(r2);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = ", stage: ";	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1 = r1.append(r2);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = r3.w;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r1.append(r2);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x005f:
        r1 = r3.w;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r2 = com.bumptech.glide.b.b.n.ENCODE;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        if (r1 == r2) goto L_0x0068;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x0065:
        r3.g();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x0068:
        r1 = r3.s;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        if (r1 != 0) goto L_0x00a1;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x006c:
        throw r0;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x006d:
        r0 = move-exception;
        r1 = r3.C;
        if (r1 == 0) goto L_0x0077;
    L_0x0072:
        r1 = r3.C;
        r1.a();
    L_0x0077:
        android.support.v4.os.e.a();
        throw r0;
    L_0x007b:
        r0 = com.bumptech.glide.b.b.n.INITIALIZE;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r0 = r3.a(r0);	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r3.w = r0;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r0 = r3.e();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r3.r = r0;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        r3.f();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x008c:
        r0 = r3.C;
        if (r0 == 0) goto L_0x0095;
    L_0x0090:
        r0 = r3.C;
        r0.a();
    L_0x0095:
        android.support.v4.os.e.a();
        goto L_0x0018;
    L_0x0099:
        r3.f();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        goto L_0x008c;	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
    L_0x009d:
        r3.i();	 Catch:{ RuntimeException -> 0x003d, all -> 0x006d }
        goto L_0x008c;
    L_0x00a1:
        r0 = r3.C;
        if (r0 == 0) goto L_0x00aa;
    L_0x00a5:
        r0 = r3.C;
        r0.a();
    L_0x00aa:
        android.support.v4.os.e.a();
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.b.o.run():void");
    }

    public final /* synthetic */ int compareTo(Object obj) {
        o oVar = (o) obj;
        int ordinal = this.g.ordinal() - oVar.g.ordinal();
        return ordinal == 0 ? this.n - oVar.n : ordinal;
    }

    o(k kVar, q<o<?>> qVar) {
        this.b = kVar;
        this.v = qVar;
    }

    private void d() {
        if (this.d.b()) {
            b();
        }
    }

    final void b() {
        this.d.d();
        j jVar = this.c;
        jVar.a = null;
        jVar.b = null;
        jVar.c = null;
        f fVar = this.a;
        fVar.c = null;
        fVar.d = null;
        fVar.n = null;
        fVar.g = null;
        fVar.k = null;
        fVar.i = null;
        fVar.o = null;
        fVar.j = null;
        fVar.p = null;
        fVar.a.clear();
        fVar.l = false;
        fVar.b.clear();
        fVar.m = false;
        this.D = false;
        this.e = null;
        this.f = null;
        this.l = null;
        this.g = null;
        this.h = null;
        this.m = null;
        this.w = null;
        this.r = null;
        this.y = null;
        this.q = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.x = 0;
        this.s = false;
        this.t.clear();
        this.v.a(this);
    }

    private e e() {
        switch (g.b[this.w.ordinal()]) {
            case 1:
                return new av(this.a, this);
            case 2:
                return new a(this.a, this);
            case 3:
                return new az(this.a, this);
            case 4:
                return null;
            default:
                throw new IllegalStateException("Unrecognized stage: " + this.w);
        }
    }

    private void f() {
        this.y = Thread.currentThread();
        this.x = com.bumptech.glide.util.f.a();
        boolean z = false;
        while (!this.s && this.r != null) {
            z = this.r.a();
            if (z) {
                break;
            }
            this.w = a(this.w);
            this.r = e();
            if (this.w == n.SOURCE) {
                c();
                return;
            }
        }
        if ((this.w == n.FINISHED || this.s) && !r0) {
            g();
        }
    }

    private void g() {
        h();
        this.m.a(new ap("Failed to load resource", new ArrayList(this.t)));
        if (this.d.c()) {
            b();
        }
    }

    private void h() {
        this.u.a();
        if (this.D) {
            throw new IllegalStateException("Already notified");
        }
        this.D = true;
    }

    public final n a(n nVar) {
        while (true) {
            switch (g.b[nVar.ordinal()]) {
                case 1:
                    if (!this.k.b()) {
                        nVar = n.DATA_CACHE;
                        break;
                    }
                    return n.DATA_CACHE;
                case 2:
                    return this.p ? n.FINISHED : n.SOURCE;
                case 3:
                case 4:
                    return n.FINISHED;
                case 5:
                    if (!this.k.a()) {
                        nVar = n.RESOURCE_CACHE;
                        break;
                    }
                    return n.RESOURCE_CACHE;
                default:
                    throw new IllegalArgumentException("Unrecognized stage: " + nVar);
            }
        }
    }

    public final void c() {
        this.o = m.SWITCH_TO_SOURCE_SERVICE;
        this.m.a(this);
    }

    public final void a(i iVar, Object obj, c<?> cVar, a aVar, i iVar2) {
        this.q = iVar;
        this.A = obj;
        this.C = cVar;
        this.B = aVar;
        this.z = iVar2;
        if (Thread.currentThread() != this.y) {
            this.o = m.DECODE_DATA;
            this.m.a(this);
            return;
        }
        android.support.v4.os.e.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            android.support.v4.os.e.a();
        }
    }

    public final void a(i iVar, Exception exception, c<?> cVar, a aVar) {
        cVar.a();
        ap apVar = new ap("Fetching data failed", exception);
        apVar.a(iVar, aVar, cVar.d());
        this.t.add(apVar);
        if (Thread.currentThread() != this.y) {
            this.o = m.SWITCH_TO_SOURCE_SERVICE;
            this.m.a(this);
            return;
        }
        f();
    }

    private void i() {
        au a;
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.x, "data: " + this.A + ", cache key: " + this.q + ", fetcher: " + this.C);
        }
        try {
            a = a(this.C, this.A, this.B);
        } catch (ap e) {
            e.a(this.z, this.B, null);
            this.t.add(e);
            a = null;
        }
        if (a != null) {
            at a2;
            a aVar = this.B;
            if (a instanceof aq) {
                ((aq) a).e();
            }
            if (this.c.a()) {
                a2 = at.a(a);
                a = a2;
            } else {
                a2 = null;
            }
            h();
            this.m.a(a, aVar);
            this.w = n.ENCODE;
            j jVar;
            try {
                if (this.c.a()) {
                    jVar = this.c;
                    k kVar = this.b;
                    m mVar = this.l;
                    android.support.v4.os.e.a("DecodeJob.encode");
                    kVar.a().a(jVar.a, new c(jVar.b, jVar.c, mVar));
                    jVar.c.e();
                    android.support.v4.os.e.a();
                }
                if (a2 != null) {
                    a2.e();
                }
                d();
            } catch (Throwable th) {
                if (a2 != null) {
                    a2.e();
                }
                d();
            }
        } else {
            f();
        }
    }

    private <Data> au<R> a(c<?> cVar, Data data, a aVar) throws ap {
        au<R> auVar = null;
        if (data == null) {
            cVar.a();
        } else {
            try {
                long a = com.bumptech.glide.util.f.a();
                auVar = a((Object) data, aVar, this.a.b(data.getClass()));
                if (Log.isLoggable("DecodeJob", 2)) {
                    a("Decoded result " + auVar, a, null);
                }
                cVar.a();
            } catch (Throwable th) {
                cVar.a();
            }
        }
        return auVar;
    }

    private <Data, ResourceType> au<R> a(Data data, a aVar, ar<Data, ResourceType, R> arVar) throws ap {
        com.bumptech.glide.b.a.e a = this.e.b.e.a((Object) data);
        try {
            au<R> a2 = arVar.a(a, this.l, this.i, this.j, new i(this, aVar));
            return a2;
        } finally {
            a.b();
        }
    }

    private void a(String str, long j, String str2) {
        new StringBuilder().append(str).append(" in ").append(com.bumptech.glide.util.f.a(j)).append(", load key: ").append(this.h).append(str2 != null ? ", " + str2 : "").append(", thread: ").append(Thread.currentThread().getName());
    }

    public final j m_() {
        return this.u;
    }
}
