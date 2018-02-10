package com.ucpro.feature.a;

import android.content.Context;
import android.text.TextUtils;
import com.uc.weex.h.k;
import com.uc.weex.h.o;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.base.weex.a.b;
import com.ucpro.base.weex.c;
import java.util.Map;

/* compiled from: ProGuard */
public final class d implements b {
    final w a;
    final Context b;
    final c c;
    final e d;
    o e;
    g f;
    com.ucpro.base.c.b.c g = new k(this);
    com.uc.weex.h.g h = new f(this);

    public d(w wVar, Context context, e eVar, c cVar) {
        this.a = wVar;
        this.b = context;
        this.c = cVar;
        this.d = eVar;
    }

    final void a() {
        r c = r.c();
        CharSequence f = this.e.f();
        if (!TextUtils.isEmpty(f)) {
            c.a.remove(f);
        }
        if (this.e != null) {
            this.e.d();
            this.e = null;
        }
    }

    final void a(boolean z) {
        if (this.d.a.b().a() == this.f) {
            this.d.a.b().a(z);
            this.f = null;
        }
    }

    final k a(k kVar) {
        b a = b.a("params");
        a.b = com.ucpro.base.system.b.a.f();
        a.a = com.ucpro.base.system.b.a.g();
        try {
            Object obj;
            Map map = kVar.d;
            CharSequence charSequence = "urloptions";
            if (map == null || TextUtils.isEmpty(charSequence)) {
                obj = null;
            } else {
                obj = map.get(charSequence);
            }
            map = (Map) obj;
            if (!(map == null || map == null)) {
                a.c.putAll(map);
            }
        } catch (Throwable th) {
        }
        kVar.a(a.a(this.b));
        return kVar;
    }
}
