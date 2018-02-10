package com.ucpro.feature.downloadpage.b;

import com.ucpro.ui.e.a.f;
import com.ucpro.ui.e.a.g;
import com.ucpro.ui.e.b;
import com.ucpro.ui.e.d;
import com.ucpro.ui.e.e;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class r extends d {
    private static final String b = d.a();
    private static final String c = d.a();
    private String d;
    private p e;

    public r(String str, String str2, p pVar) {
        super(str);
        this.d = str2;
        this.e = pVar;
    }

    public final void a(e eVar, b bVar) {
        if (a.d(eVar.b(), b)) {
            g gVar = (g) bVar;
            gVar.l.setText(this.d);
            if (!com.ucpro.c.d.a()) {
                gVar.n.setText(this.e.h.c());
            }
        } else if (a.d(eVar.b(), c)) {
            f fVar = (f) bVar;
            fVar.l.setText(this.d);
            fVar.n.setChecked(this.e.h.e());
            fVar.n.setOnCheckedChangeListener(new f(this));
        }
    }

    public final void a(e eVar, int i, b bVar) {
        if (a.c(eVar.b(), b)) {
            this.e.h.d();
        } else if (a.d(eVar.b(), c)) {
            ((f) bVar).n.a();
        }
    }

    public final com.ucpro.ui.e.a.d c() {
        if (a.d(this.a, b)) {
            return com.ucpro.ui.e.a.d.VIEW_TYPE_NORMAL;
        }
        if (a.d(this.a, c)) {
            return com.ucpro.ui.e.a.d.VIEW_TYPE_CHECKBOX;
        }
        return com.ucpro.ui.e.a.d.VIEW_TYPE_NORMAL;
    }
}
