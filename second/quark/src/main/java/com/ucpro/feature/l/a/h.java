package com.ucpro.feature.l.a;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class h implements ValueCallback<List<m>> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ j b;

    h(j jVar, ValueCallback valueCallback) {
        this.b = jVar;
        this.a = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Object<m> obj2 = (List) obj;
        c.a((Object) obj2);
        ArrayList arrayList = new ArrayList();
        for (m add : obj2) {
            arrayList.add(add);
        }
        this.a.onReceiveValue(arrayList);
    }
}
