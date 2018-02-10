package com.ucpro.feature.privacymode;

import com.ucpro.ui.e.a.g;
import com.ucpro.ui.e.b;
import com.ucpro.ui.e.d;
import com.ucpro.ui.e.e;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class k extends d {
    private static final String b = d.a();
    private static final String c = d.a();
    private String d;
    private c e;

    public k(String str, String str2, c cVar) {
        super(str);
        this.d = str2;
        this.e = cVar;
    }

    public final com.ucpro.ui.e.a.d c() {
        return com.ucpro.ui.e.a.d.VIEW_TYPE_NORMAL;
    }

    public final void a(e eVar, b bVar) {
        g gVar;
        if (a.d(eVar.b(), b)) {
            gVar = (g) bVar;
            gVar.l.setText(this.d);
            gVar.l.setTextColor(com.ucpro.ui.c.a.c("privacymode_title_color"));
        } else if (a.d(eVar.b(), c)) {
            gVar = (g) bVar;
            gVar.l.setText(this.d);
            gVar.l.setTextColor(com.ucpro.ui.c.a.c("privacymode_title_color"));
        }
    }

    public final void a(e eVar, int i, b bVar) {
        if (a.c(eVar.b(), b)) {
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.cL, Boolean.valueOf(true));
        } else if (a.d(eVar.b(), c)) {
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.cN, Boolean.valueOf(true));
        }
    }
}
