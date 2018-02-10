package com.ucpro.feature.setting.b.f;

import android.util.Log;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.ui.b.e;
import java.util.List;

/* compiled from: ProGuard */
final class l implements i {
    l() {
    }

    public final void a() {
        StringBuilder stringBuilder = new StringBuilder();
        List<b> c = com.ucpro.feature.video.cache.db.b.b().c();
        stringBuilder.append("共有数据" + c.size() + "条\n");
        for (b bVar : c) {
            stringBuilder.append(bVar.toString());
            stringBuilder.append("\n");
        }
        Log.e("hjw-m3u8", "M3U8 model层数据:" + stringBuilder.toString());
        e.a().a(stringBuilder.toString(), 0);
    }
}
