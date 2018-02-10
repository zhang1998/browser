package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.category.f;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
final class h implements ValueCallback<List<m>> {
    final /* synthetic */ j a;

    h(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        obj = (List) obj;
        c.a(obj);
        this.a.c = obj;
        if (this.a.d == null) {
            this.a.d = new f(this.a.c, this.a);
            this.a.a.setAdapter(this.a.d);
            return;
        }
        this.a.d.a(this.a.c);
    }
}
