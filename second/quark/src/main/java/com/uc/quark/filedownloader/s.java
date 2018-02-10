package com.uc.quark.filedownloader;

import android.text.TextUtils;
import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.model.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class s implements aa, at, x {
    private volatile boolean A = false;
    int a;
    boolean b = false;
    volatile int c = 0;
    private final ae d;
    private final u e;
    private ArrayList<Object> f;
    private final String g;
    private String h;
    private String i;
    private boolean j;
    private FileDownloadHeader k;
    private m l;
    private Object m;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private String q;
    private int r;
    private int s = 100;
    private int t = 10;
    private boolean u = false;
    private boolean v = false;
    private int w = 0;
    private long x = -1;
    private String y;
    private volatile Object z = new Object();

    s(String str) {
        this.g = str;
        Object oVar = new o(this);
        this.d = oVar;
        this.e = oVar;
    }

    public final aa a(String str) {
        this.h = str;
        if (j.a) {
            j.d(this, "setPath %s", str);
        }
        this.j = false;
        this.i = new File(str).getName();
        return this;
    }

    public final aa a(m mVar) {
        this.l = mVar;
        if (j.a) {
            j.d(this, "setListener %s", mVar);
        }
        return this;
    }

    public final aa a() {
        this.t = 950;
        return this;
    }

    public final aa a(Object obj) {
        this.m = obj;
        if (j.a) {
            j.d(this, "setTag %s", obj);
        }
        return this;
    }

    public final aa a(boolean z) {
        this.u = z;
        return this;
    }

    public final aa a(int i) {
        this.n = i;
        return this;
    }

    public final aa a(String str, String str2) {
        R();
        if (!TextUtils.isEmpty(str2)) {
            this.k.a(str, str2);
        }
        return this;
    }

    public final aa a(Map<String, String> map) {
        R();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                this.k.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return this;
    }

    public final aa b(boolean z) {
        this.p = z;
        return this;
    }

    public final aa b(String str) {
        this.q = str;
        return this;
    }

    public final aa b(int i) {
        this.r = i;
        return this;
    }

    public final aa c(int i) {
        this.w = i;
        return this;
    }

    public final aa c(String str) {
        this.y = str;
        return this;
    }

    private boolean Q() {
        return this.d.m() || as.a().i().a(this);
    }

    public final boolean b() {
        return this.c != 0;
    }

    public final int c() {
        if (this.v) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually; 2. the queue start this task automatically.");
        } else if (Q()) {
            int i = as.a().i().a(this) ? 1 : (Q() && (d.a(s()) || ak.a.a((at) this))) ? 1 : 0;
            if (i != 0) {
                throw new IllegalStateException(b.a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(e())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.d.toString());
        } else {
            if (!b()) {
                P();
            }
            this.d.e();
            return e();
        }
    }

    public final boolean d() {
        return this.d.f();
    }

    public final int e() {
        if (this.a != 0) {
            return this.a;
        }
        if (TextUtils.isEmpty(this.h) || TextUtils.isEmpty(this.g)) {
            return 0;
        }
        int a = b.a(this.g, this.h, this.j);
        this.a = a;
        return a;
    }

    public final String f() {
        return this.g;
    }

    public final int g() {
        return this.s;
    }

    public final int h() {
        return this.t;
    }

    public final String i() {
        return this.h;
    }

    public final boolean j() {
        return this.j;
    }

    public final String k() {
        return this.i;
    }

    public final m m() {
        return this.l == null ? new ap(this) : this.l;
    }

    public final int n() {
        if (this.d.h() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.d.h();
    }

    public final long o() {
        return this.d.h();
    }

    public final int p() {
        if (this.d.i() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.d.i();
    }

    public final long q() {
        return this.d.i();
    }

    public final long r() {
        return this.d.a();
    }

    public final byte s() {
        return this.d.g();
    }

    public final boolean t() {
        return this.u;
    }

    public final Throwable u() {
        return this.d.j();
    }

    public final Object w() {
        return this.m;
    }

    public final int x() {
        return this.n;
    }

    public final int y() {
        return this.d.k();
    }

    public final boolean z() {
        return this.o;
    }

    public final boolean A() {
        return this.d.l();
    }

    public final boolean B() {
        return this.p;
    }

    public final String C() {
        return this.q;
    }

    public final int D() {
        return this.r;
    }

    public final boolean v() {
        return this.b;
    }

    public final int E() {
        return this.w;
    }

    public final aa a(long j) {
        this.x = j;
        return this;
    }

    public final long F() {
        return this.x;
    }

    public final String G() {
        return this.y;
    }

    private void R() {
        if (this.k == null) {
            synchronized (this.z) {
                if (this.k == null) {
                    this.k = new FileDownloadHeader();
                }
            }
        }
    }

    public final FileDownloadHeader H() {
        return this.k;
    }

    public final void I() {
        this.A = true;
    }

    public final boolean J() {
        return this.A;
    }

    public final at K() {
        return this;
    }

    public final void d(String str) {
        this.i = str;
    }

    public final ArrayList<Object> L() {
        return this.f;
    }

    public final aa M() {
        return this;
    }

    public final u N() {
        return this.e;
    }

    public final boolean d(int i) {
        return e() == i;
    }

    public final boolean O() {
        return s() < (byte) 0;
    }

    public final void P() {
        int hashCode;
        if (m() != null) {
            hashCode = m().hashCode();
        } else {
            hashCode = hashCode();
        }
        this.c = hashCode;
    }

    public final String toString() {
        return b.a("%d@%s", Integer.valueOf(e()), super.toString());
    }

    public final String l() {
        return b.a(this.h, this.j, this.i);
    }
}
