package com.ucpro.feature.navigation.b;

import com.d.a.a.a;
import com.d.a.a.b;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class u {
    final n a;
    a b = new a();
    b c = new b();
    HashMap<String, String> d = new HashMap();
    String[] e;
    private String[] f;

    public u(String[] strArr, String[] strArr2, n nVar) {
        a aVar = this.b;
        aVar.c = com.ucpro.base.system.b.a.c();
        aVar.d = com.ucpro.base.system.b.a.d();
        this.c.b("android");
        this.e = strArr2;
        this.f = strArr;
        this.a = nVar;
        if (this.e != null && this.f != null) {
            int min = Math.min(this.e.length, this.f.length);
            for (int i = 0; i < min; i++) {
                this.d.put(this.e[i], this.f[i]);
            }
        }
    }
}
