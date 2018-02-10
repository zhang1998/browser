package com.uc.weex.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.weex.common.w;
import com.uc.weex.j.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class y {
    private static y b;
    final w a = new w("JsBundleThread");
    private final Handler c = new Handler(Looper.getMainLooper());
    private final Map<String, n> d = new HashMap();
    private final j e = new j();
    private g f = new c();
    private f g = ag.d;
    private boolean h;
    private Map<String, List<e>> i = new HashMap();

    static y a() {
        if (b != null) {
            return b;
        }
        y yVar;
        synchronized (y.class) {
            if (b == null) {
                b = new y();
            }
            yVar = b;
        }
        return yVar;
    }

    private y() {
    }

    final void a(e eVar, n nVar, String str, int i) {
        if (eVar != null) {
            this.c.post(new p(this, eVar, nVar, str, i));
        }
    }

    private boolean b(n nVar) {
        if (nVar == null) {
            return false;
        }
        n nVar2 = (n) this.d.get(nVar.a);
        if (af.a(nVar.d)) {
            Object obj;
            if (nVar2 == null) {
                obj = 1;
            } else if (af.a(nVar.c, nVar2.c) >= 0) {
                int i = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void b(y yVar) {
        Object a = b.a(z.c);
        if (!TextUtils.isEmpty(a)) {
            List<n> a2 = ad.a(a, 2);
            if (a2 != null && !a2.isEmpty()) {
                for (n nVar : a2) {
                    if (yVar.b(nVar)) {
                        yVar.d.put(nVar.a, nVar);
                    }
                }
            }
        }
    }

    static /* synthetic */ void c(y yVar) {
        Object b = b.b(z.a);
        if (!TextUtils.isEmpty(b)) {
            List<n> a = ad.a(b, 1);
            if (a != null && !a.isEmpty()) {
                for (n nVar : a) {
                    if (nVar != null && yVar.b(nVar)) {
                        yVar.d.put(nVar.a, nVar);
                    }
                }
            }
        }
    }

    static /* synthetic */ String a(n nVar) {
        if (nVar.a()) {
            return b.b(z.b + nVar.a + b.c);
        }
        return b.a(nVar.h);
    }
}
