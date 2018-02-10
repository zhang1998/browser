package com.ucpro.feature.bookmarkhis.bookmark.a;

import com.raizlabs.android.dbflow.a.b.d;
import com.raizlabs.android.dbflow.a.b.v;
import com.raizlabs.android.dbflow.a.b.w;
import com.raizlabs.android.dbflow.a.f;
import java.util.List;

/* compiled from: ProGuard */
public final class o implements i {
    final /* synthetic */ long a;
    final /* synthetic */ List b;
    final /* synthetic */ s c;

    public o(s sVar, long j, List list) {
        this.c = sVar;
        this.a = j;
        this.b = list;
    }

    public final boolean a() {
        if (s.a(this.a) == null) {
            return false;
        }
        f vVar = new v(m.class);
        d[] dVarArr = new d[]{y.h.a(Long.valueOf(this.a))};
        w wVar = new w(vVar, vVar.a);
        wVar.b.a(dVarArr);
        if (wVar.a(y.h.a(this.b)).e() > 0) {
            return true;
        }
        return false;
    }
}
