package com.ucpro.feature.setting.d;

import com.ucpro.business.stat.m;
import com.ucpro.feature.z.g.b.i;
import com.ucpro.feature.z.g.b.n;
import com.ucpro.ui.g.c;
import java.util.List;
import kotlin.jvm.a.f;

/* compiled from: ProGuard */
final class v implements c {
    final /* synthetic */ d a;

    v(d dVar) {
        this.a = dVar;
    }

    public final void a(int i) {
        int i2;
        boolean z;
        List b = n.b.b();
        if (i >= 0) {
            f.b(b, "$receiver");
            if (i <= b.size() - 1) {
                i2 = 1;
                if (i2 == 0) {
                    String str;
                    str = ((i) b.get(i)).a;
                    n.a = str;
                    if (str == null) {
                        f.a();
                    }
                    n.a(str);
                    z = true;
                } else {
                    z = false;
                }
                com.ucweb.common.util.c.b(z);
                this.a.a.a();
                m.a("search_engine", "select", "type", n.b.c());
            }
        }
        i2 = 0;
        if (i2 == 0) {
            z = false;
        } else {
            str = ((i) b.get(i)).a;
            n.a = str;
            if (str == null) {
                f.a();
            }
            n.a(str);
            z = true;
        }
        com.ucweb.common.util.c.b(z);
        this.a.a.a();
        m.a("search_engine", "select", "type", n.b.c());
    }
}
