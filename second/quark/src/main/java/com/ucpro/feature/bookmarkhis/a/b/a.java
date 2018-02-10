package com.ucpro.feature.bookmarkhis.a.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.a.d;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;

/* compiled from: ProGuard */
public final class a extends j implements d {
    public f g = new f(getContext());

    public a(Context context) {
        super(context);
        this.f.b(com.ucpro.ui.c.a.a("history_title_view_delete.svg"));
        this.e.addView(this.g, new LayoutParams(-1, -1));
        b();
    }

    private void b() {
        setBackgroundColor(com.ucpro.ui.c.a.c("history_list_bg_color"));
    }

    public final void a() {
        if (this.g != null) {
            this.g.b();
        }
    }

    public final void a(com.ucpro.feature.bookmarkhis.a.a.a aVar) {
        int i = 0;
        if (this.g != null) {
            f fVar = this.g;
            if (fVar.a != null) {
                fVar.b.a = aVar;
                fVar.b.notifyDataSetChanged();
            } else {
                fVar.c();
                fVar.a = new e(fVar, fVar.getContext());
                fVar.b = new l(fVar.getContext(), fVar.a, aVar, fVar.c);
                fVar.a.setAdapter(fVar.b);
                fVar.a.setVisibility(0);
                fVar.addView(fVar.a);
                fVar.requestLayout();
            }
            while (i < fVar.b.getGroupCount()) {
                fVar.a.expandGroup(i);
                fVar.a.setGroupIndicator(null);
                i++;
            }
        }
    }

    public final void setHistoryWindowCallBacks(i iVar) {
        setWindowCallBacks(iVar);
        if (this.g != null) {
            this.g.setOnHistoryItemClickListener(iVar);
        }
    }

    public final void l() {
        super.l();
        if (this.g != null) {
            this.g.a();
        }
        if (this.f != null) {
            this.f.b();
        }
        b();
    }

    public final void a(f fVar, View view, ad adVar) {
        g.a().a(e.aF);
    }

    public final void a(f fVar, View view, w wVar) {
        g.a().a(e.aE);
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("8995230");
    }

    public final String getPageName() {
        return "Page_quark_history";
    }

    public final void f() {
        super.f();
    }

    public final void d(boolean z) {
        this.f.a.setVisibility(z ? 0 : 8);
    }
}
