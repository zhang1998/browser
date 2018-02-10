package com.ucpro.feature.video.cache.e;

import android.os.Looper;
import android.util.Log;
import com.uc.quark.n;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.feature.video.cache.e.b.i;
import com.ucweb.common.util.c;
import com.ucweb.common.util.k.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ boolean a = false;
    final /* synthetic */ c b;

    e(c cVar) {
        this.b = cVar;
    }

    public final void run() {
        ArrayList arrayList;
        c cVar = this.b;
        c.b(Looper.getMainLooper() != Looper.myLooper());
        b bVar = cVar.b;
        HashMap hashMap = new HashMap();
        byte[] d = a.d(bVar.i);
        if (d != null) {
            com.ucpro.feature.video.cache.e.b.e a = com.ucpro.feature.video.cache.a.a.a(d);
            if (a != null) {
                List list = a.a;
                if (list == null || list.size() <= 0) {
                    Log.e("hjw-m3u8", "parseVideoUrlListFromM3u8::elements empty..!!");
                } else {
                    String str;
                    if (bVar.a()) {
                        str = bVar.k;
                    } else {
                        str = bVar.b;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        String uri = ((i) list.get(i)).b().toString();
                        String str2 = bVar.h + "/" + String.valueOf(i);
                        uri = com.ucpro.feature.video.cache.a.a.a(str, uri);
                        if (com.ucpro.c.b.b()) {
                            new StringBuilder("parseVideoUrlListFromM3u8Full::[").append(i).append("] key----->").append(str2);
                            new StringBuilder("parseVideoUrlListFromM3u8Full::[").append(i).append("] value---->").append(uri);
                        }
                        hashMap.put(str2, uri);
                    }
                }
            } else {
                Log.e("hjw-m3u8", "parseVideoUrlListFromM3u8::playList == null!!");
            }
        } else {
            Log.e("hjw-m3u8", "parseVideoUrlListFromM3u8::m3u8Data == null!!");
        }
        cVar.c = hashMap;
        if (cVar.c.size() == 0) {
            cVar.b.f = "meata_data_failed";
            cVar.b.g = "种子文件解析失败";
            com.ucpro.feature.video.d.a.b();
            com.ucpro.feature.video.cache.db.b.b().b(cVar.b);
            arrayList = null;
        } else {
            if (com.ucpro.c.b.b()) {
                new StringBuilder("启动批量下载，标题").append(cVar.b.c);
                com.ucpro.feature.video.d.a.b();
                new StringBuilder("下载目标文件夹:").append(cVar.b.h);
                com.ucpro.feature.video.d.a.b();
                new StringBuilder("m3u8文件路径:").append(cVar.b.i);
                com.ucpro.feature.video.d.a.b();
                new StringBuilder("url列表文件含有:").append(cVar.c.size()).append("个url片段");
                com.ucpro.feature.video.d.a.b();
            }
            Iterator it = cVar.c.entrySet().iterator();
            if (com.ucpro.feature.video.cache.db.b.b().c(cVar.b.a.longValue()).size() != 0) {
                com.ucpro.feature.video.cache.db.b.b().b(cVar.b.a.longValue());
                new StringBuilder("删除对应本id：").append(cVar.b.a).append("对应的所有的ts行");
                com.ucpro.feature.video.d.a.b();
            }
            Iterable arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            while (it.hasNext()) {
                int i2;
                Entry entry = (Entry) it.next();
                n nVar = new n();
                nVar.a = (String) entry.getValue();
                nVar.f = true;
                nVar.g = false;
                nVar.e = (String) entry.getKey();
                nVar.d = "m3u8_ts_start:" + c.a();
                s a2 = x.a().a(nVar.a());
                if (it.hasNext()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                a2.a = i2;
                arrayList2.add(new com.ucpro.feature.video.cache.db.bean.a(Long.valueOf((long) a2.a()), cVar.b.a, a2.g(), a2.h(), Integer.valueOf(a2.e()), ""));
                arrayList3.add(a2);
            }
            new StringBuilder("下载任务批量插入数据库：size= ").append(arrayList2.size());
            com.ucpro.feature.video.d.a.b();
            com.ucpro.feature.video.cache.db.b.b().b.insertOrReplaceInTx(arrayList2);
            cVar.b.o = Integer.valueOf(cVar.c.size());
            new StringBuilder("总表总ts数更新 size=").append(cVar.b.e());
            com.ucpro.feature.video.d.a.b();
            arrayList = arrayList3;
        }
        if (arrayList != null) {
            c.a(this.b, arrayList);
            com.ucpro.feature.video.cache.db.b.b().b(this.b.b);
            this.b.a.a(this.b.b.e(), this.b.b.h);
        }
    }
}
