package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
final class y implements ValueCallback<List<m>> {
    final /* synthetic */ ai a;

    y(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        List<m> list = (List) obj;
        if (list != null) {
            int i = 0;
            for (m mVar : list) {
                int i2;
                if (mVar == null || !mVar.g()) {
                    i2 = i;
                } else {
                    i2 = i + 1;
                }
                i = i2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("count", String.valueOf(i));
            com.ucpro.business.stat.m.a("bookmark", "bookmark_category_count", hashMap);
        }
        ai.a(this.a, (List) list);
    }
}
