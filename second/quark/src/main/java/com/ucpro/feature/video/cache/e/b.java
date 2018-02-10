package com.ucpro.feature.video.cache.e;

import android.util.Log;
import com.ucpro.feature.video.cache.e.a.a;

/* compiled from: ProGuard */
final class b implements a {
    final /* synthetic */ com.ucpro.feature.video.cache.db.bean.b a;
    final /* synthetic */ d b;

    b(d dVar, com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.b = dVar;
        this.a = bVar;
    }

    public final void a(int i, String str) {
        if (com.ucpro.c.b.b()) {
            Log.e("hjw-m3u8", "onFileDownloadStarted:taskAmount=" + i + ",baseDirPath=" + str);
        }
        new StringBuilder("视频缓存任务:").append(this.a.c).append("已启动，共存在").append(i).append("个ts任务");
        com.ucpro.feature.video.d.a.b();
    }
}
