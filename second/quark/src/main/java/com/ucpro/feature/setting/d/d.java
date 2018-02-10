package com.ucpro.feature.setting.d;

import com.ucpro.feature.h.b;
import com.ucpro.feature.z.g.b.i;
import com.ucpro.feature.z.g.b.n;
import com.ucpro.ui.g.c;
import com.ucweb.common.util.n.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.a.f;

/* compiled from: ProGuard */
public final class d implements p {
    t a = null;
    c b = new w(this);
    private c c = new v(this);
    private c d = new e(this);

    public final void a() {
        n nVar = n.b;
        Object c = nVar.c();
        int i = 0;
        for (i iVar : nVar.b()) {
            if (f.a(iVar.a, c)) {
                break;
            }
            i++;
        }
        i = -1;
        List arrayList = new ArrayList();
        for (i iVar2 : n.b.b()) {
            arrayList.add(iVar2.b);
        }
        this.a.a(arrayList, i, this.c);
    }

    public final void b() {
        List a = com.ucpro.a.a.c.a();
        int i = 0;
        while (i < a.size()) {
            if (a.c((String) a.get(i), c())) {
                break;
            }
            i++;
        }
        i = 0;
        this.a.c(a, i, this.d);
    }

    public static String c() {
        b.a;
        return com.ucpro.a.a.c.a(com.ucpro.feature.h.a.d());
    }
}
