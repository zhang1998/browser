package com.uc.weex;

import android.content.Context;
import com.taobao.weex.ac;
import com.uc.weex.a.ah;
import com.uc.weex.e.b;
import com.uc.weex.e.e;
import com.uc.weex.f.d;
import com.uc.weex.h.k;
import com.uc.weex.h.o;
import com.uc.weex.h.r;

/* compiled from: ProGuard */
public final class p {
    public r a;
    public d b;
    private ah c;

    private p() {
        b.a = new b();
        this.a = b.a();
        this.c = b.b();
        this.b = b.c();
    }

    @Deprecated
    public final void a(String str, String str2) {
        for (o b : this.a.a) {
            b.b(str, str2);
        }
    }

    public final o a(ac acVar) {
        r rVar = this.a;
        if (acVar != null) {
            for (o oVar : rVar.a) {
                if (acVar == oVar.h()) {
                    return oVar;
                }
            }
        }
        return null;
    }

    public final o a(Context context, k kVar) {
        e mVar = new m(context, kVar.c, kVar);
        mVar.a(new k(this)).a(new j(this));
        mVar.a(null);
        return mVar.d;
    }
}
