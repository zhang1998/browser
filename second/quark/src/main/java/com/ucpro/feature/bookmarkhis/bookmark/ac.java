package com.ucpro.feature.bookmarkhis.bookmark;

import com.ucpro.business.stat.m;
import com.ucpro.ui.g.h;
import com.ucpro.ui.g.l;
import com.ucpro.ui.g.u;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class ac implements l {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ aa d;

    ac(aa aaVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.d = aaVar;
        this.a = arrayList;
        this.b = arrayList2;
        this.c = arrayList3;
    }

    public final boolean a(h hVar, int i, Object obj) {
        if (i == u.c) {
            m.a("bookmark", "bookmark_delete", "delete_bookmark", (this.a.size() - this.b.size()), "delete_bookmark_dir", this.b.size());
            m.b("bookmark_ut", "bookmark_delete", "delete_bookmark", (this.a.size() - this.b.size()), "delete_bookmark_dir", this.b.size());
            if (this.d.n != null) {
                this.d.n.a(this.c);
            }
        }
        return false;
    }
}
