package com.ucpro.feature.setting.b.d.b;

import android.content.Context;
import com.ucpro.c.b;
import com.ucpro.feature.setting.b.b.a.e;
import com.ucpro.feature.setting.b.b.a.f;
import com.ucpro.feature.setting.b.b.a.g;
import com.ucpro.feature.setting.b.b.a.h;
import com.ucpro.feature.setting.b.b.c;
import com.ucpro.feature.setting.b.d.a.d;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class j extends h {
    private c e;
    private e f = this.e.c;

    public j(Context context, c cVar) {
        super(context);
        this.e = cVar;
        com.ucweb.common.util.c.a((Object) cVar);
        com.ucweb.common.util.c.a(this.f);
        a();
    }

    protected final void a() {
        super.a();
        if (e()) {
            this.d.setImageDrawable(a.a("bookmark_edit.svg"));
        } else {
            this.d.setImageDrawable(a.a("searchpage_search_associate_list_search.svg"));
        }
    }

    public final void b() {
        this.b.setText(this.e.a);
        Object a = this.f.a();
        this.c.setText(a == null ? "" : a.toString());
    }

    private boolean e() {
        int i = this.e.d;
        if (i == com.ucpro.feature.setting.b.a.c.a) {
            return true;
        }
        if (i == com.ucpro.feature.setting.b.a.c.c) {
            return false;
        }
        if (i == com.ucpro.feature.setting.b.a.c.b) {
            return b.b();
        }
        com.ucweb.common.util.c.a("edit arg wrong.");
        return false;
    }

    protected final void c() {
        e eVar = this.e.c;
        if (eVar == null) {
            com.ucweb.common.util.c.a("devStringOperator == null");
        } else if (eVar instanceof h) {
            h hVar = (h) eVar;
            com.ucpro.feature.setting.b.d.a.c cVar = new com.ucpro.feature.setting.b.d.a.c(getContext(), 0);
            cVar.a(this.e.a);
            cVar.b((String) hVar.a());
            cVar.a(e());
            cVar.a(new a(this, hVar));
            cVar.show();
        } else if (eVar instanceof f) {
            f fVar = (f) eVar;
            r1 = new com.ucpro.feature.setting.b.d.a.c(getContext(), 3);
            r1.a(this.e.a);
            r1.b(String.valueOf(fVar.a()));
            r1.a(e());
            r1.a(new e(this, fVar));
            r1.show();
        } else if (eVar instanceof com.ucpro.feature.setting.b.b.a.b) {
            com.ucpro.feature.setting.b.b.a.b bVar = (com.ucpro.feature.setting.b.b.a.b) eVar;
            r1 = new com.ucpro.feature.setting.b.d.a.c(getContext(), 4);
            r1.a(this.e.a);
            r1.a(e());
            r1.b(String.valueOf(bVar.a()));
            r1.a(new i(this, bVar));
            r1.show();
        } else if (eVar instanceof g) {
            g gVar = (g) eVar;
            if (e()) {
                d dVar = new d(getContext());
                dVar.b.setText(this.e.a);
                dVar.a.setChecked(((Boolean) gVar.a()).booleanValue());
                dVar.v = new c(this, gVar);
                com.ucweb.common.util.c.a(dVar.v);
                dVar.a.setOnCheckedChangeListener(new com.ucpro.feature.setting.b.d.a.b(dVar));
                dVar.show();
            }
        } else if (eVar instanceof com.ucpro.feature.setting.b.b.a.a) {
            com.ucpro.feature.setting.b.b.a.a aVar = (com.ucpro.feature.setting.b.b.a.a) eVar;
            r1 = new com.ucpro.feature.setting.b.d.a.c(getContext(), 1);
            r1.a(this.e.a);
            r1.b(String.valueOf(aVar.a()));
            r1.a(e());
            r1.a(new f(this, aVar));
            r1.show();
        } else if (eVar instanceof com.ucpro.feature.setting.b.b.a.c) {
            com.ucpro.feature.setting.b.b.a.c cVar2 = (com.ucpro.feature.setting.b.b.a.c) eVar;
            r1 = new com.ucpro.feature.setting.b.d.a.c(getContext(), 2);
            r1.a(this.e.a);
            r1.b(String.valueOf(cVar2.a()));
            r1.a(e());
            r1.a(new d(this, cVar2));
            r1.show();
        }
    }

    public final void a(String str) {
        this.b.setText(this.e.a);
        this.c.setText(str);
    }
}
