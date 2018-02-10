package com.ucpro.feature.r;

import android.content.Context;
import com.ucweb.a.b.d;
import com.ucweb.a.u;
import com.ucweb.common.util.n.a;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class i implements d {
    final /* synthetic */ WeakReference a;

    i(WeakReference weakReference) {
        this.a = weakReference;
    }

    public final void a(u uVar) {
        int i = 0;
        String str = uVar.j;
        if (!a.a(str)) {
            int i2;
            String d = com.ucpro.model.a.d("CC8F115B0F3BD7B604669B0951277178");
            if (a.a(d) || a.a(str) || !str.equalsIgnoreCase(d)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long c = com.ucpro.model.a.c("8E1EC6336EAD61D36848B3F5299E1FE8");
                int b = com.ucpro.model.a.b("76C84375F67E4F55422EAD33D2838E7D");
                currentTimeMillis -= c;
                if ((currentTimeMillis >= 345600000 && b == 1) || ((b == 2 && currentTimeMillis >= 691200000) || (b == 3 && currentTimeMillis >= 1036800000))) {
                    com.ucpro.model.a.a("76C84375F67E4F55422EAD33D2838E7D", b + 1);
                    com.ucpro.model.a.a("8E1EC6336EAD61D36848B3F5299E1FE8", System.currentTimeMillis());
                    i = 1;
                }
            } else {
                com.ucpro.model.a.a("76C84375F67E4F55422EAD33D2838E7D", 1);
                com.ucpro.model.a.a("8E1EC6336EAD61D36848B3F5299E1FE8", System.currentTimeMillis());
                com.ucpro.model.a.a("CC8F115B0F3BD7B604669B0951277178", str);
                i = 1;
            }
        }
        if (i != 0 && this.a != null && this.a.get() != null) {
            com.ucpro.feature.r.a.a aVar = new com.ucpro.feature.r.a.a((Context) this.a.get());
            aVar.a(new d(this, uVar));
            aVar.a(uVar);
        }
    }

    public final void a() {
    }

    public final void a(boolean z) {
    }
}
