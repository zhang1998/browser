package com.ucpro.feature.video.cache.e;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.quark.browser.R;
import com.uc.quark.filedownloader.as;
import com.uc.quark.n;
import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.feature.video.cache.e.a.j;
import com.ucpro.feature.video.d.a;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class d {
    private static d a = null;

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public final synchronized void a(String str, String str2, String str3) {
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        b a = com.ucpro.feature.video.cache.db.b.b().a(str);
        if (a != null) {
            a.b();
            e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_download_existed_task) + a.c, 0);
        } else {
            int hashCode = com.uc.quark.filedownloader.e.b.e(com.uc.quark.filedownloader.e.b.a("%sp%s@dir", str, com.ucpro.feature.video.cache.f.a.a + "/video/" + com.ucpro.b.b.b.a(str))).hashCode();
            if (com.ucpro.feature.video.cache.db.b.b().a((long) hashCode) != null) {
                a.b();
                c.a("查库发现生成的id已经在库中，这不太可能啊，应为id是根据url和路径生成的,所以不对劲！！！");
            }
            a = com.ucpro.feature.video.cache.db.a.a.a(str, str2, r2, str3, (long) hashCode);
            a.b();
            com.ucpro.feature.video.cache.db.b.b().a(a);
            a.b();
            a(a);
        }
    }

    public final void a(b bVar) {
        c.b(Looper.getMainLooper() != Looper.myLooper());
        i iVar = new i(bVar);
        Object gVar = new g(this, bVar);
        a.b();
        c.a(gVar);
        iVar.b = new j(gVar);
        iVar.a(true);
    }

    public static void a(int i) {
        boolean z = false;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            z = true;
        }
        c.b(z);
        a.b();
        b a = com.ucpro.feature.video.cache.db.b.b().a((long) i);
        if (a == null) {
            a.b();
            return;
        }
        a.b();
        if (a.f.equals("ts_downloading")) {
            a.b();
            if (a.e == 1) {
                List<com.ucpro.feature.video.cache.db.bean.a> c = com.ucpro.feature.video.cache.db.b.b().c(a.a.longValue());
                ArrayList arrayList = new ArrayList();
                for (com.ucpro.feature.video.cache.db.bean.a aVar : c) {
                    x.a();
                    if (x.a(aVar.a.intValue(), aVar.d) != -3) {
                        arrayList.add(Integer.valueOf(aVar.a.intValue()));
                        Log.e("hjw-m3u8", "pauseTask:id=" + aVar.a);
                    }
                }
                new StringBuilder("获取到m3u8类型下载任务的：").append(c.size()).append("个ts任务，对非完成状态的ts实施暂停操作,更新数据状态");
                a.b();
                synchronized (x.a().e) {
                    if (x.i()) {
                        as.a();
                        as.a(arrayList, false);
                    }
                }
                a.f = "ts_paused";
                com.ucpro.feature.video.cache.db.b.b().b(a);
                return;
            } else if (a.e == 0) {
                x.a();
                int a2 = x.a(a.a.intValue(), a.h);
                if (a2 != -3) {
                    x.a().d(a.a.intValue());
                    a.f = "ts_paused";
                    com.ucpro.feature.video.cache.db.b.b().b(a);
                    new StringBuilder("获取到普通视频类型下载任务，当前状态：").append(a2).append("，对非完成状态的ts实施暂停操作， 更新数据状态");
                    a.b();
                    return;
                }
                new StringBuilder("获取到普通视频类型下载任务，当前状态：").append(a2).append("，该任务已完成，暂停操作未实施");
                a.b();
                return;
            } else {
                return;
            }
        }
        new StringBuilder("当前状态非下载中, 中止逻辑：").append(a.f);
        a.b();
    }

    public static void a(@NonNull b bVar, List<com.ucpro.feature.video.cache.db.bean.a> list) {
        c.b(Looper.getMainLooper() != Looper.myLooper());
        if (bVar == null) {
            a.b();
            return;
        }
        a.b();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        long j = 0;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.ucpro.feature.video.cache.db.bean.a aVar = (com.ucpro.feature.video.cache.db.bean.a) list.get(i3);
            File file = new File(aVar.d);
            if (file.exists()) {
                if (aVar.a() != -3) {
                    aVar.e = Integer.valueOf(-3);
                    com.ucpro.feature.video.cache.db.b.b().a(aVar);
                }
                i++;
                j += file.length();
            } else {
                if (aVar.a() == -3) {
                    aVar.e = Integer.valueOf(-1);
                    com.ucpro.feature.video.cache.db.b.b().a(aVar);
                }
                i2++;
            }
            if (aVar.a() != -3) {
                hashMap.put(Integer.valueOf(aVar.a.intValue()), Boolean.valueOf(false));
                hashMap2.put(aVar.c, aVar.d);
                Log.e("hjw-m3u8", "startTask:id=" + aVar.a);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap2.entrySet()) {
            n nVar = new n();
            nVar.a = (String) entry.getKey();
            nVar.f = true;
            nVar.g = false;
            nVar.b = bVar.d;
            nVar.e = (String) entry.getValue();
            nVar.d = "m3u8_ts_start:" + ((String) entry.getValue());
            arrayList.add(x.a().a(nVar.a()));
        }
        x.a().a(arrayList);
        if (i2 > 0) {
            new StringBuilder("重新开始ts任务").append(i2).append("个，是否强制更新？false,当前状态为下载状态");
            a.b();
            bVar.l = Long.valueOf(j);
            bVar.f = "ts_downloading";
        } else {
            StringBuilder stringBuilder = new StringBuilder("重新开始ts任务0个，是否强制更新？false,当前状态为完成状态");
            a.b();
            bVar.p = Integer.valueOf(i);
            bVar.l = Long.valueOf(j);
            bVar.f = "ts_successed";
        }
        com.ucpro.feature.video.cache.db.b.b().b(bVar);
        a.b();
    }

    static /* synthetic */ void a(d dVar, b bVar) {
        c.b(Looper.getMainLooper() != Looper.myLooper());
        a.b();
        new Thread(new e(new c(bVar, new b(dVar, bVar)))).start();
    }
}
