package com.uc.base.wa;

import com.uc.base.wa.a.c;
import com.uc.base.wa.config.b;
import com.uc.base.wa.config.m;

/* compiled from: ProGuard */
class r implements n<Object> {
    private long a;
    private long b;
    private boolean c;

    public r(long j, long j2, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = z;
    }

    public void a(int i, int i2, float f, Object obj) {
        if (i != -1) {
            int f2;
            if (i == 0) {
                if (this.c) {
                    long j;
                    if (((long) i2) > this.a) {
                        j = ((long) i2) - this.a;
                        m.a(0);
                        m.b(b.c(j) + this.b);
                    } else {
                        j = this.a - ((long) i2);
                        if (j > m.l()) {
                            j = m.l();
                        }
                        m.a(j);
                        m.b(this.b);
                    }
                    m.c(this.b);
                    if (!b.n() && m.q() <= 3) {
                        f2 = c.f();
                        x.a("system", new e().a("sv_upfail", String.valueOf(i)).a("wa_errcodef", String.valueOf(f2)).a("wa_errnt", c.g()), new String[0]);
                        x.a("forced", new e().a("svf_upfail", String.valueOf(i)).a("wa_errcode", String.valueOf(f2)).a("wa_errnt", c.g()), new String[0]);
                    }
                }
            } else if (!b.n() && m.q() <= 4) {
                f2 = c.f();
                x.a("system", new e().a("sv_upfail", String.valueOf(i)).a("wa_errcodef", String.valueOf(f2)).a("wa_errnt", c.g()), new String[0]);
                x.a("forced", new e().a("svf_upfail", String.valueOf(i)).a("wa_errcode", String.valueOf(f2)).a("wa_errnt", c.g()), new String[0]);
            }
        }
    }
}
