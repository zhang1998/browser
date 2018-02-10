package com.ucpro.feature.l.a;

import android.support.v7.widget.bd;
import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class f implements ValueCallback<ArrayList<m>> {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        b bVar = this.a;
        boolean z = arrayList == null || arrayList.size() == 0;
        b.a(bVar, z);
        bd a = this.a.c;
        if (arrayList != null) {
            a.c = arrayList;
            a.a.a();
        }
    }
}
