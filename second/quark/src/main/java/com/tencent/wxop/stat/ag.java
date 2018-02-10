package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.n;
import com.tencent.wxop.stat.a.q;
import com.tencent.wxop.stat.b.d;

final class ag {
    private static volatile long f = 0;
    private d a;
    private o b = null;
    private boolean c = false;
    private Context d = null;
    private long e = System.currentTimeMillis();

    public ag(d dVar) {
        this.a = dVar;
        this.b = i.a();
        this.c = dVar.e();
        this.d = dVar.d();
    }

    private void a(k kVar) {
        n.b(ah.t).a(this.a, kVar);
    }

    private void b() {
        if (as.a().b <= 0 || !i.m) {
            a(new af(this));
            return;
        }
        as.a().a(this.a, null, this.c, true);
        as.a().a(-1);
    }

    public final void a() {
        boolean z;
        long l;
        if (i.h > 0) {
            if (this.e > ah.h) {
                ah.g.clear();
                ah.h = this.e + i.i;
                if (i.b()) {
                    ah.q.a("clear methodsCalledLimitMap, nextLimitCallClearTime=" + ah.h);
                }
            }
            Integer valueOf = Integer.valueOf(this.a.b().j);
            Integer num = (Integer) ah.g.get(valueOf);
            if (num != null) {
                ah.g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > i.h) {
                    if (i.b()) {
                        ah.q.e("event " + this.a.f() + " was discard, cause of called limit, current:" + num + ", limit:" + i.h + ", period:" + i.i + " ms");
                    }
                    z = true;
                    if (z) {
                        if (i.n > 0 && this.e >= f) {
                            ah.e(this.d);
                            f = this.e + i.o;
                            if (i.b()) {
                                ah.q.a("nextFlushTime=" + f);
                            }
                        }
                        if (d.a(this.d).b()) {
                            as.a(this.d).a(this.a, null, this.c, false);
                            return;
                        }
                        if (i.b()) {
                            ah.q.a("sendFailedCount=" + ah.a);
                        }
                        if (ah.a()) {
                            if (this.a.m != null && this.a.m.d) {
                                this.b = o.INSTANT;
                            }
                            if (i.j && d.a(ah.t).a()) {
                                this.b = o.INSTANT;
                            }
                            if (i.b()) {
                                ah.q.a("strategy=" + this.b.name());
                            }
                            switch (x.a[this.b.ordinal()]) {
                                case 1:
                                    b();
                                    return;
                                case 2:
                                    as.a(this.d).a(this.a, null, this.c, false);
                                    if (i.b()) {
                                        ah.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + ah.c + ",difftime=" + (ah.c - this.e));
                                    }
                                    if (ah.c == 0) {
                                        ah.c = q.a(this.d, "last_period_ts");
                                        if (this.e > ah.c) {
                                            ah.f(this.d);
                                        }
                                        l = this.e + ((long) ((i.l() * 60) * 1000));
                                        if (ah.c > l) {
                                            ah.c = l;
                                        }
                                        g.a(this.d).a();
                                    }
                                    if (i.b()) {
                                        ah.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + ah.c + ",difftime=" + (ah.c - this.e));
                                    }
                                    if (this.e > ah.c) {
                                        ah.f(this.d);
                                        return;
                                    }
                                    return;
                                case 3:
                                case 4:
                                    as.a(this.d).a(this.a, null, this.c, false);
                                    return;
                                case 5:
                                    as.a(this.d).a(this.a, new ad(this), this.c, true);
                                    return;
                                case 6:
                                    if (d.a(ah.t).b != 1) {
                                        b();
                                        return;
                                    } else {
                                        as.a(this.d).a(this.a, null, this.c, false);
                                        return;
                                    }
                                case 7:
                                    if (n.e(this.d)) {
                                        a(new ae(this));
                                        return;
                                    }
                                    return;
                                default:
                                    ah.q.d("Invalid stat strategy:" + i.a());
                                    return;
                            }
                        }
                        as.a(this.d).a(this.a, null, this.c, false);
                        if (this.e - ah.b > 1800000) {
                            ah.c(this.d);
                            return;
                        }
                        return;
                    }
                }
            }
            ah.g.put(valueOf, Integer.valueOf(1));
        }
        z = false;
        if (z) {
            ah.e(this.d);
            f = this.e + i.o;
            if (i.b()) {
                ah.q.a("nextFlushTime=" + f);
            }
            if (d.a(this.d).b()) {
                as.a(this.d).a(this.a, null, this.c, false);
                return;
            }
            if (i.b()) {
                ah.q.a("sendFailedCount=" + ah.a);
            }
            if (ah.a()) {
                as.a(this.d).a(this.a, null, this.c, false);
                if (this.e - ah.b > 1800000) {
                    ah.c(this.d);
                    return;
                }
                return;
            }
            this.b = o.INSTANT;
            this.b = o.INSTANT;
            if (i.b()) {
                ah.q.a("strategy=" + this.b.name());
            }
            switch (x.a[this.b.ordinal()]) {
                case 1:
                    b();
                    return;
                case 2:
                    as.a(this.d).a(this.a, null, this.c, false);
                    if (i.b()) {
                        ah.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + ah.c + ",difftime=" + (ah.c - this.e));
                    }
                    if (ah.c == 0) {
                        ah.c = q.a(this.d, "last_period_ts");
                        if (this.e > ah.c) {
                            ah.f(this.d);
                        }
                        l = this.e + ((long) ((i.l() * 60) * 1000));
                        if (ah.c > l) {
                            ah.c = l;
                        }
                        g.a(this.d).a();
                    }
                    if (i.b()) {
                        ah.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + ah.c + ",difftime=" + (ah.c - this.e));
                    }
                    if (this.e > ah.c) {
                        ah.f(this.d);
                        return;
                    }
                    return;
                case 3:
                case 4:
                    as.a(this.d).a(this.a, null, this.c, false);
                    return;
                case 5:
                    as.a(this.d).a(this.a, new ad(this), this.c, true);
                    return;
                case 6:
                    if (d.a(ah.t).b != 1) {
                        as.a(this.d).a(this.a, null, this.c, false);
                        return;
                    } else {
                        b();
                        return;
                    }
                case 7:
                    if (n.e(this.d)) {
                        a(new ae(this));
                        return;
                    }
                    return;
                default:
                    ah.q.d("Invalid stat strategy:" + i.a());
                    return;
            }
        }
    }
}
