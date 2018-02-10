package com.ucpro.feature.downloadpage.d;

import android.text.TextUtils;
import android.util.Log;
import com.quark.browser.R;
import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.a;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.ui.b.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ boolean b;
    final /* synthetic */ v c;

    i(v vVar, b bVar, boolean z) {
        this.c = vVar;
        this.a = bVar;
        this.b = z;
    }

    public final void run() {
        if (this.a.e == 1) {
            Object obj = this.a.h;
            com.ucpro.feature.video.cache.db.b.b().d(this.a.a.longValue());
            List<a> c = com.ucpro.feature.video.cache.db.b.b().c(this.a.a.longValue());
            ArrayList arrayList = new ArrayList();
            for (a aVar : c) {
                arrayList.add(Integer.valueOf(aVar.a.intValue()));
            }
            x.a().b(arrayList);
            com.ucpro.feature.video.cache.db.b.b().b(this.a.a.longValue());
            if (!this.b) {
                return;
            }
            if (TextUtils.isEmpty(obj)) {
                Log.e("hjw-m3u8", "VideoCachePresenter:removeTask:base data dir == empty");
                return;
            }
            File file = new File(obj);
            if (!file.exists() || file.isFile()) {
                Log.e("hjw-m3u8", "VideoCachePresenter:removeTask:base data dir not exists");
                return;
            }
            try {
                com.ucweb.common.util.k.a.i(file);
            } catch (IOException e) {
            }
            e.a().a(file + com.ucpro.ui.c.a.d((int) R.string.video_download_task_file_deleted), 0);
            return;
        }
        com.ucpro.feature.video.cache.db.b.b().d(this.a.a.longValue());
        x.a().b(this.a.a.intValue(), true);
        com.ucweb.common.util.k.a.h(new File(this.a.h));
    }
}
