package com.uc.weex.a;

import android.os.Handler;
import android.os.Looper;
import com.taobao.weex.common.r;
import com.taobao.weex.common.s;
import com.uc.weex.j.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class j implements k {
    final Map<l, List<e>> a = new HashMap();
    final Map<l, Long> b = new HashMap();
    d c = ag.c;
    private final Handler d = new Handler(Looper.getMainLooper());

    j() {
    }

    final void a(l lVar, e eVar) {
        this.d.post(new h(this, lVar, eVar));
    }

    private void a(l lVar, n nVar, String str) {
        this.d.post(new i(this, lVar, nVar, str));
    }

    public final void a(l lVar) {
        s sVar = lVar.k;
        String str = lVar.f;
        if (!"200".equals(sVar.a) || sVar.b == null || sVar.b.length <= 0 || !(str == null || str.compareToIgnoreCase(a.a(sVar.b)) == 0)) {
            Object obj;
            if (lVar.c == null || lVar.a.equals(lVar.c)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                r rVar = new r();
                rVar.b = lVar.c;
                rVar.e = lVar.j;
                rVar.a = lVar.i;
                lVar.a = rVar.b;
                ag.e.a(rVar, lVar);
                return;
            }
            n nVar = new n(lVar.d);
            nVar.c = lVar.e;
            a(lVar, nVar, null);
            return;
        }
        nVar = m.a(sVar.b);
        if (nVar != null) {
            nVar.a = lVar.d;
            nVar.g = 2;
            nVar.b = lVar.a("ETag");
            nVar.e = lVar.a("Last-Modified");
        }
        if (lVar.g) {
            y a = y.a();
            a.a.a.post(new q(a, nVar, sVar.b));
        }
        if (nVar == null) {
            nVar = new n(lVar.d);
            nVar.c = lVar.e;
        }
        a(lVar, nVar, new String(sVar.b));
    }
}
