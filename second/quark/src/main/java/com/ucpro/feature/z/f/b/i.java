package com.ucpro.feature.z.f.b;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class i implements ValueCallback<List<m>> {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ ValueCallback c;
    final /* synthetic */ a d;

    i(a aVar, ArrayList arrayList, ArrayList arrayList2, ValueCallback valueCallback) {
        this.d = aVar;
        this.a = arrayList;
        this.b = arrayList2;
        this.c = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        List<m> list = (List) obj;
        ArrayList arrayList = new ArrayList();
        for (m add : list) {
            arrayList.add(add);
        }
        o oVar = new o();
        oVar.a = this.d.a;
        oVar.b = this.a;
        oVar.c = arrayList;
        oVar.d = this.b;
        if (this.c != null) {
            this.c.onReceiveValue(oVar);
        }
    }
}
