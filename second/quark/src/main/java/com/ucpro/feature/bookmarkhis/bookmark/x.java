package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class x implements ValueCallback<List<m>> {
    final /* synthetic */ l a;

    x(l lVar) {
        this.a = lVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        List<m> list = (List) obj;
        if (!list.isEmpty()) {
            int i = (int) this.a.j.d;
            ArrayList arrayList = new ArrayList();
            for (m mVar : list) {
                if (mVar.b != ((long) i)) {
                    arrayList.add(mVar);
                }
            }
            this.a.setupListViewData(arrayList);
        }
    }
}
