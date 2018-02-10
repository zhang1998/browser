package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.util.Log;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.database.transaction.a;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
final class l implements a {
    final /* synthetic */ List a;
    final /* synthetic */ s b;

    l(s sVar, List list) {
        this.b = sVar;
        this.a = list;
    }

    public final void a(b bVar) {
        for (Long longValue : this.a) {
            long longValue2 = longValue.longValue();
            s sVar = this.b;
            m mVar = (m) z.a(new com.raizlabs.android.dbflow.a.b.a.b[0]).a(m.class).a(y.f.a(Long.valueOf(longValue2))).d();
            if (mVar == null) {
                Log.w(s.a, "luid " + longValue2 + " not exist");
            } else {
                boolean e = sVar.e(mVar);
                if (mVar.g()) {
                    for (m mVar2 : z.a(new com.raizlabs.android.dbflow.a.b.a.b[0]).a(m.class).a(y.h.a(Long.valueOf(longValue2)), y.n.a(Integer.valueOf(0))).c()) {
                        boolean z;
                        if (sVar.e(mVar2) && r1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        e = z;
                    }
                }
                c.b(e);
            }
        }
    }
}
