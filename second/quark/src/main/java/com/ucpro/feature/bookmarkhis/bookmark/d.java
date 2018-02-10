package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.category.f;
import java.util.List;

/* compiled from: ProGuard */
final class d implements ValueCallback<List<m>> {
    final /* synthetic */ o a;

    d(o oVar) {
        this.a = oVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        List list = (List) obj;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                m mVar = (m) list.get(size);
                if (mVar != null && mVar.b == this.a.d.d) {
                    this.a.f = size;
                    break;
                }
            }
            this.a.c = list;
            if (this.a.e == null) {
                this.a.e = new f(this.a.c, this.a);
                this.a.b.setAdapter(this.a.e);
            } else {
                this.a.e.a(this.a.c);
            }
            this.a.b(this.a.f);
        }
    }
}
