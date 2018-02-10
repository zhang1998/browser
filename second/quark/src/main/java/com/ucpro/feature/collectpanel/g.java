package com.ucpro.feature.collectpanel;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.category.f;
import java.util.List;

/* compiled from: ProGuard */
final class g implements ValueCallback<List<m>> {
    final /* synthetic */ i a;

    g(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        List list = (List) obj;
        if (list != null) {
            m mVar;
            if (this.a.k && this.a.d != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    for (int i = 0; i < this.a.d.size(); i++) {
                        mVar = (m) list.get(size);
                        m mVar2 = (m) this.a.d.get(i);
                        if (mVar != null && mVar2 != null && ((int) mVar.b) == ((int) mVar2.b)) {
                            list.remove(size);
                            break;
                        }
                    }
                }
            }
            this.a.e = list;
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                mVar = (m) list.get(size2);
                if (mVar != null && ((long) ((int) mVar.b)) == this.a.f) {
                    this.a.h = size2;
                    break;
                }
            }
            if (this.a.g == null) {
                this.a.g = new f(this.a.e, this.a);
                this.a.g.c = this.a.h;
                this.a.a.setAdapter(this.a.g);
                return;
            }
            this.a.g.a(this.a.e);
        }
    }
}
