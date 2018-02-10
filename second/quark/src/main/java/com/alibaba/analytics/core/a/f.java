package com.alibaba.analytics.core.a;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.a.r;
import com.alibaba.analytics.core.f.g;
import com.alibaba.appmonitor.d.b;
import com.alibaba.appmonitor.d.e;
import java.util.concurrent.ScheduledFuture;

/* compiled from: ProGuard */
public final class f implements e {
    static f a = new f();
    public long b = 30000;
    public d c = null;
    private d d = d.INTERVAL;
    private ScheduledFuture e;
    private g f;
    private h g = new e(this, c.ALL);
    private long h = 50;
    private c i = c.ALL;
    private long j;
    private long k = 0;
    private long l = 0;

    private f() {
        b.a((e) this);
    }

    public static f a() {
        return a;
    }

    public final synchronized void b() {
        af.b();
        String a = r.a(com.alibaba.analytics.core.b.a().b, "UTANALYTICS_UPLOAD_ALLOWED_NETWORK_STATUS");
        if (!TextUtils.isEmpty(a)) {
            if ("ALL".equalsIgnoreCase(a)) {
                this.i = c.ALL;
            } else if ("2G".equalsIgnoreCase(a)) {
                this.i = c.TWO_GENERATION;
            } else if ("3G".equalsIgnoreCase(a)) {
                this.i = c.THRID_GENERATION;
            } else if ("4G".equalsIgnoreCase(a)) {
                this.i = c.FOUR_GENERATION;
            } else if ("WIFI".equalsIgnoreCase(a)) {
                this.i = c.WIFI;
            }
        }
        if (this.c == null) {
            this.c = this.d;
        }
        if (this.e != null) {
            this.e.cancel(true);
        }
        b(this.c);
    }

    public final void a(d dVar) {
        if (dVar != null && this.c != dVar) {
            this.c = dVar;
            b();
        }
    }

    private synchronized void b(d dVar) {
        af.a("startMode", "mode", dVar);
        switch (a.a[dVar.ordinal()]) {
            case 1:
                if (this.f != null) {
                    com.alibaba.analytics.core.f.f.a().b(this.f);
                }
                this.f = new k(this);
                com.alibaba.analytics.core.f.f.a().a(this.f);
                break;
            case 2:
                if (this.f != null) {
                    com.alibaba.analytics.core.f.f.a().b(this.f);
                }
                this.f = new j(this, new e(this, this.i));
                com.alibaba.analytics.core.f.f.a().a(this.f);
                break;
            case 3:
                com.alibaba.analytics.core.f.f a = com.alibaba.analytics.core.f.f.a();
                af.a("LogStoreMgr", "[count] memory count:", Integer.valueOf(a.b.size()), " db count:", Integer.valueOf(a.a.a()));
                this.l = (long) (a.b.size() + a.a.a());
                if (this.l > 0) {
                    this.k = 0;
                    i.a();
                    this.e = i.b(this.e, new l(this, this.i), 5000);
                    break;
                }
                break;
            case 4:
                i.a();
                this.e = i.a(this.e, this.g, 0);
                break;
            default:
                this.b = f();
                af.a(null, "mCurrentUploadInterval", Long.valueOf(this.b));
                i.a();
                this.e = i.a(this.e, new i(this, this.i), 8000);
                break;
        }
    }

    public static void e() {
    }

    private long f() {
        if ((!r.a(com.alibaba.analytics.core.b.a().b) ? 1 : null) != null) {
            long b = (long) (com.alibaba.analytics.core.h.e.a().b("bu") * 1000);
            if (b == 0) {
                return 300000;
            }
            return b;
        }
        long b2 = (long) (com.alibaba.analytics.core.h.e.a().b("fu") * 1000);
        if (b2 != 0) {
            return b2;
        }
        if (this.j >= 30000) {
            return this.j;
        }
        return 30000;
    }

    public final void c() {
        af.b();
        if (d.INTERVAL == this.c) {
            if (this.b != f()) {
                b();
            }
        }
    }

    public final void d() {
        af.b();
        if (d.INTERVAL == this.c) {
            if (this.b != f()) {
                b();
            }
        }
    }
}
