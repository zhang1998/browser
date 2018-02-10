package com.ucpro.feature.video.cache.b;

import android.os.Handler;
import android.text.TextUtils;
import com.uc.quark.h;
import com.uc.quark.s;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.services.networkstate.a;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import java.io.File;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
public final class d implements h, a {
    private static d a = null;
    private int b = 0;
    private List<com.ucpro.feature.video.cache.db.bean.a> c;
    private Handler d = new Handler(m.b());
    private b e = new b();

    static /* synthetic */ void a(d dVar, s sVar, int i) {
        boolean z = true;
        Object b = sVar.b();
        boolean n = sVar.n();
        new StringBuilder("接到文件下载模块的回调，下载id是:").append(sVar.a());
        com.ucpro.feature.video.d.a.b();
        if (n) {
            m.c(dVar.e);
            m.a(3, dVar.e, 40000);
            b a = com.ucpro.feature.video.cache.db.b.b().a((long) sVar.a());
            if (a == null) {
                com.ucpro.feature.video.d.a.b();
                return;
            }
            if (a.e != 0) {
                z = false;
            }
            c.b(z);
            c.a(a.b);
            c.a(a.h);
            c.a(a.c);
            a.l = Long.valueOf(sVar.d());
            a.m = Long.valueOf(sVar.c());
            a.n = Integer.valueOf((int) sVar.f());
            a.s = new Date();
            if (i == -3) {
                a.f = "ts_successed";
            } else if (i == 3) {
                a.f = "ts_downloading";
            } else if (i == -2) {
                a.f = "ts_paused";
            } else if (i == -1) {
                a.f = "ts_failed";
                a.g = "下载出错";
            }
            com.ucpro.feature.video.cache.db.b.b().b(a);
            return;
        }
        if (TextUtils.isEmpty(b) || !b.startsWith("m3u8_ts_start:")) {
            z = false;
        }
        if (z) {
            dVar.a(sVar);
        }
    }

    private d() {
        com.ucpro.services.networkstate.b.a.a(this);
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public final void a(s sVar, int i, long j, long j2) {
        this.d.post(new e(this, sVar, i, j, j2));
    }

    private void a(s sVar) {
        m.c(this.e);
        m.a(3, this.e, 40000);
        com.ucpro.feature.video.cache.db.bean.a aVar = (com.ucpro.feature.video.cache.db.bean.a) com.ucpro.feature.video.cache.db.b.b().b.load(Long.valueOf((long) sVar.a()));
        if (aVar == null) {
            com.ucpro.feature.video.d.a.b();
            return;
        }
        c.a(aVar.d);
        c.a(aVar.c);
        aVar.e = Integer.valueOf(sVar.e());
        if (sVar.e() == -1) {
            aVar.f = "ts出错";
        }
        if (aVar.a() == -3) {
            if (a(aVar)) {
                com.ucpro.feature.video.d.a.b();
            } else {
                aVar.e = Integer.valueOf(-1);
                aVar.f = "未发现文件";
                com.ucpro.feature.video.d.a.b();
            }
        } else if (aVar.a() == -1) {
            if (a(aVar)) {
                aVar.e = Integer.valueOf(-3);
                com.ucpro.feature.video.d.a.b();
            } else {
                aVar.e = Integer.valueOf(-1);
                aVar.f = "error, 未发现文件";
                com.ucpro.feature.video.d.a.b();
            }
        }
        com.ucpro.feature.video.cache.db.b.b().a(aVar);
        if (aVar.a() == -3 || aVar.a() == -1) {
            b a = com.ucpro.feature.video.cache.db.b.b().a(aVar.b.longValue());
            if (a == null) {
                com.ucpro.feature.video.d.a.b();
                return;
            }
            this.c = com.ucpro.feature.video.cache.db.b.b().c(aVar.b.longValue());
            int i = 0;
            int i2 = 0;
            long j = 0;
            int i3 = 0;
            int i4 = 0;
            for (com.ucpro.feature.video.cache.db.bean.a aVar2 : this.c) {
                File file = new File(aVar2.d);
                if (aVar2.a() == -3) {
                    j = file.length() + j;
                    i3++;
                } else if (aVar2.a() == -1) {
                    i++;
                } else if (aVar2.a() == -2) {
                    i2++;
                } else {
                    i4++;
                }
            }
            new StringBuilder("ts盘点结论：当前已下载成功的ts数量：").append(i3).append("；已下载失败的数量：").append(i).append("；正在下载的数量：").append(i4).append("当前pause的数量：").append(i2);
            com.ucpro.feature.video.d.a.b();
            Object obj = (i <= 0 || i3 + i != a.e() || this.b >= 5) ? null : 1;
            Object obj2 = (i == 0 && i3 == a.e()) ? 1 : null;
            Object obj3 = (i <= 0 || i3 + i != a.e() || this.b < 5) ? null : 1;
            if (i2 > 0) {
                a.e();
            }
            a.p = Integer.valueOf(i3);
            a.q = Integer.valueOf(i);
            if (j > 0) {
                a.l = Long.valueOf(j);
            }
            if (obj2 != null) {
                com.ucpro.feature.video.d.a.b();
                j = 0;
                for (com.ucpro.feature.video.cache.db.bean.a aVar22 : this.c) {
                    File file2 = new File(aVar22.d);
                    if (file2.exists()) {
                        j = file2.length() + j;
                    } else {
                        com.ucpro.feature.video.d.a.b();
                        c.a((Object) "不应该的，即将上报成功，还会有不存在的ts文件");
                    }
                }
                a.l = Long.valueOf(j);
                a.f = "ts_successed";
                a.s = new Date();
                com.ucpro.feature.video.cache.db.b.b().b(a);
            } else if (obj != null) {
                a.f = "ts_downloading";
                new StringBuilder("ts盘点结论：需要对错误任务进行重试，除了成功的就是失败的 errorCount=").append(i).append(", 已重试：").append(this.b);
                com.ucpro.feature.video.d.a.b();
                m.a(3, new c());
                this.b++;
                a.s = new Date();
                com.ucpro.feature.video.cache.db.b.b().b(a);
            } else if (obj3 != null) {
                a.f = "ts_failed";
                com.ucpro.feature.video.d.a.b();
                a.s = new Date();
                com.ucpro.feature.video.cache.db.b.b().b(a);
            } else {
                a.f = "ts_downloading";
                com.ucpro.feature.video.d.a.b();
                a.s = new Date();
                com.ucpro.feature.video.cache.db.b.b().b(a);
            }
        }
    }

    public final void p_() {
        if (!com.ucweb.common.util.i.c.b()) {
            m.a(3, new a(), 1000);
        }
    }

    private static boolean a(com.ucpro.feature.video.cache.db.bean.a aVar) {
        File file = new File(aVar.d);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }
}
