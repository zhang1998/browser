package com.uc.weex.h;

import android.content.Context;
import android.text.TextUtils;
import com.uc.weex.e.e;
import com.uc.weex.g;

/* compiled from: ProGuard */
public final class b extends e<o> {
    private e d;
    private Context e;
    private k f;
    private String g;
    private Boolean h;
    private o i;

    public b(e eVar, Context context, String str, k kVar) {
        this.d = eVar;
        this.e = context;
        this.g = str;
        this.f = kVar;
    }

    protected final void h_() {
        if (this.h == null) {
            boolean z = (TextUtils.isEmpty(this.g) || this.g.startsWith(com.uc.weex.a.b.d) || this.g.startsWith(com.uc.weex.a.b.e) || !this.f.g) ? false : true;
            this.h = Boolean.valueOf(z);
        }
        if (this.i == null) {
            o dVar;
            e eVar;
            Context context;
            k kVar;
            if (this.h.booleanValue()) {
                eVar = this.d;
                context = this.e;
                kVar = this.f;
                dVar = new d(context);
                dVar.a(eVar);
                dVar.a(kVar);
            } else {
                eVar = this.d;
                context = this.e;
                kVar = this.f;
                dVar = new a(context);
                dVar.a(eVar);
                dVar.a(kVar);
                dVar.a = g.b.b;
            }
            this.i = dVar;
        }
        a((Object) this.i);
    }
}
