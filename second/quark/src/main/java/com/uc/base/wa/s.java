package com.uc.base.wa;

import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.c.c;
import com.uc.base.wa.component.e;
import com.uc.base.wa.config.b;
import com.uc.base.wa.config.m;
import java.io.File;
import java.util.HashMap;

/* compiled from: ProGuard */
final class s implements n<File> {
    private long a;
    private long b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f;
    private long g;
    private o h;
    private boolean i;

    public final /* synthetic */ void a(int i, int i2, float f, Object obj) {
        File file = (File) obj;
        try {
            e eVar = new e();
            if (i != -1) {
                long j;
                int f2;
                if (i == 0) {
                    if (i2 == 0) {
                        a(i);
                        if (this.h != null) {
                            this.h.a();
                            return;
                        }
                        return;
                    }
                    eVar.a(this.d ? "sv_wfup_period" : "sv_3gup_period", String.valueOf(this.f));
                    String f3 = b.f();
                    new File(f3).mkdirs();
                    file.renameTo(new File(f3 + "/" + this.b));
                    File[] listFiles = new File(f3).listFiles();
                    if (listFiles != null) {
                        for (File a : listFiles) {
                            c.a(a);
                        }
                    }
                    if (this.e) {
                        eVar.a("sv_reaquota", String.valueOf(this.a - ((long) i2)));
                        if (((long) i2) > this.a) {
                            long j2 = ((long) i2) - this.a;
                            m.a(0);
                            m.b(b.c(j2) + this.b);
                            eVar.a("sv_ovequota", String.valueOf(j2));
                        } else {
                            j = this.a - ((long) i2);
                            m.a(j > m.l() ? m.l() : j);
                            m.b(this.b);
                            eVar.a("sv_savquota", String.valueOf(j));
                        }
                        if (!this.c) {
                            eVar.a(this.d ? "sv_wfrup_period" : "sv_3grup_period", String.valueOf(this.g));
                            m.c(this.b);
                        }
                    }
                    if (!b.n() && m.q() <= 3) {
                        f2 = com.uc.base.wa.a.c.f();
                        x.a("forced", new e().a("svf_upfail", String.valueOf(i)).a("wa_errcode", String.valueOf(f2)).a("wa_errnt", com.uc.base.wa.a.c.g()).a("wa_upct", this.i ? SettingsConst.TRUE : SettingsConst.FALSE), new String[0]);
                        eVar.a("sv_upfail", String.valueOf(i)).a("wa_errcodef", String.valueOf(f2)).a("wa_errnt", com.uc.base.wa.a.c.g());
                    }
                } else if (!b.n() && m.q() <= 4) {
                    f2 = com.uc.base.wa.a.c.f();
                    x.a("forced", new e().a("svf_upfail", String.valueOf(i)).a("wa_errcode", String.valueOf(f2)).a("wa_errnt", com.uc.base.wa.a.c.g()).a("wa_upct", this.i ? SettingsConst.TRUE : SettingsConst.FALSE), new String[0]);
                    eVar.a("sv_upfail", String.valueOf(i)).a("wa_errcodef", String.valueOf(f2)).a("wa_errnt", com.uc.base.wa.a.c.g());
                }
                if (!(b.n() || eVar.a())) {
                    x.a("system", eVar, new String[0]);
                }
                if (!b.n()) {
                    e eVar2 = new e();
                    if (i == 0) {
                        eVar2.a("sv_upsize", String.valueOf(i2)).a("sv_upcompratio", String.valueOf(f));
                    }
                    j = e.a.a("E5FFFDF082B7E88B73195E0ED684035D");
                    if (j != 0) {
                        eVar2.a("sv_lg_lns", String.valueOf(j));
                        e.a.a("E5FFFDF082B7E88B73195E0ED684035D", -j);
                    }
                    j = e.a.a("1114AA5B512B55CECADDF881C655BFA4");
                    if (j != 0) {
                        eVar2.a("sv_lg_sz", String.valueOf(j));
                        e.a.a("1114AA5B512B55CECADDF881C655BFA4", -j);
                    }
                    if (!eVar2.a()) {
                        eVar2.a("wa_errnt", com.uc.base.wa.a.c.g());
                        x.a("forced", eVar2, new String[0]);
                    }
                }
                HashMap hashMap = new HashMap();
                c.a(hashMap);
                if (!b.n() && hashMap.size() > 0) {
                    x.a("forced", new e().a(hashMap), new String[0]);
                }
                a(i);
                if (this.h != null) {
                    this.h.a();
                }
            }
        } finally {
            a(i);
            if (this.h != null) {
                this.h.a();
            }
        }
    }

    public s(long j, long j2, boolean z, boolean z2, boolean z3, long j3, long j4, o oVar, boolean z4) {
        this.a = j;
        this.b = j2;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = j3;
        this.g = j4;
        this.h = oVar;
        this.i = z4;
    }

    private void a(int i) {
        long j = 0;
        long d;
        if (this.i) {
            if (i == 0) {
                d = m.d();
                if (d > 0) {
                    m.d(d - 1);
                }
            } else if (i != -1) {
                d = m.d();
                if (d < 20) {
                    if (d >= 0) {
                        j = d + 1;
                    }
                    m.d(j);
                    return;
                }
                m.e(System.currentTimeMillis());
            }
        } else if (i == 0) {
            d = m.f();
            if (d > 0) {
                d = System.currentTimeMillis() - d;
                if (d < 0 || d > 345600000) {
                    m.e();
                    m.g();
                }
            }
        }
    }
}
