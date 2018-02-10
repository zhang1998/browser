package com.ucpro.feature.video.cache.db;

import android.util.Log;
import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.b;
import java.io.File;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
final class a extends com.ucweb.common.util.h.a {
    final /* synthetic */ b a;

    private a(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        List<b> loadAll = this.a.a.loadAll();
        com.ucpro.feature.video.d.a.b();
        for (b bVar : loadAll) {
            if (com.ucpro.c.b.b()) {
                Log.e("hjw-m3u8", "初次请求数据, 是否需要进行校验：" + bVar.toString());
            }
            if (bVar.e == 1) {
                if (!(bVar.f == "init" || bVar.f == "ts_failed" || bVar.f == "meata_data_failed")) {
                    long j = 0;
                    int i = 0;
                    for (com.ucpro.feature.video.cache.db.bean.a aVar : b.b().c(bVar.a.longValue())) {
                        File file = new File(aVar.d);
                        if (file.exists()) {
                            aVar.e = Integer.valueOf(-3);
                            j += file.length();
                            i++;
                        } else if (aVar.a() == -3) {
                            aVar.e = Integer.valueOf(1);
                        }
                    }
                    bVar.p = Integer.valueOf(i);
                    bVar.l = Long.valueOf(j);
                    if (i == bVar.e() && i > 0) {
                        bVar.f = "ts_successed";
                    }
                    new StringBuilder("finishedCount=").append(i).append(",TotalTsCount=").append(bVar.e()).append(",修正任务状态为").append(bVar.f);
                    com.ucpro.feature.video.d.a.b();
                    b.b().b(bVar);
                }
            } else if (bVar.e == 0) {
                x.a();
                bVar.l = Long.valueOf(x.b(bVar.a.intValue()));
                x.a();
                bVar.m = Long.valueOf(x.a(bVar.a.intValue()));
                x.a();
                bVar.n = Integer.valueOf((int) x.c(bVar.a.intValue()));
                bVar.s = new Date();
                x.a();
                int a = x.a(bVar.a.intValue(), bVar.h);
                if (a == -3) {
                    bVar.f = "ts_successed";
                } else if (a == 3) {
                    bVar.f = "ts_downloading";
                } else if (a == -2) {
                    bVar.f = "ts_paused";
                } else if (a == -1) {
                    bVar.f = "ts_failed";
                    bVar.g = "下载出错";
                }
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (com.ucpro.c.b.b()) {
            Log.e("hjw-m3u8", "Init time cost is:" + (currentTimeMillis2 - currentTimeMillis) + " ms");
        }
    }
}
