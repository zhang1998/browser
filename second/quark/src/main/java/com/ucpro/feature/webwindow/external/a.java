package com.ucpro.feature.webwindow.external;

import android.content.Context;
import com.ucpro.business.stat.m;
import com.ucpro.ui.g.g;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;

/* compiled from: ProGuard */
public final class a implements l {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Context c;
    final /* synthetic */ String d;
    final /* synthetic */ g e;
    final /* synthetic */ c f;

    public a(c cVar, String str, String str2, Context context, String str3, g gVar) {
        this.f = cVar;
        this.a = str;
        this.b = str2;
        this.c = context;
        this.d = str3;
        this.e = gVar;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (i == h.c) {
            m.a("app", "call_app", "host", this.a, "schema", this.b, "click", "once");
            c.a(this.c, this.d, this.b);
            if (this.e.a.isSelected()) {
                c.a(this.f, this.a, this.b);
            }
        } else if (i == h.d) {
            m.a("app", "call_app", "host", this.a, "schema", this.b, "click", "cancel");
            if (this.e.a.isSelected()) {
                c.b(this.f, this.a, this.b);
            }
        }
        return false;
    }
}
