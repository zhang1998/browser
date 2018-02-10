package com.ucpro.feature.z.d;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.quark.browser.R;
import com.ucpro.feature.z.f.a.f;
import com.ucpro.ui.c.a;
import com.ucpro.ui.f.c;
import com.ucweb.common.util.i.g;

/* compiled from: ProGuard */
final class e extends com.ucpro.ui.f.e {
    final /* synthetic */ l b;

    e(l lVar) {
        this.b = lVar;
    }

    public final int a() {
        return this.b.a.size();
    }

    public final Object a(int i) {
        return this.b.a.get(i);
    }

    public final View a(c cVar, int i, View view) {
        View rVar;
        if (view == null) {
            rVar = new r(this.b.c, i);
            ((r) rVar).setCallback(this.b);
            ((r) rVar).getTextView().setSingleLine(true);
            LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
            marginLayoutParams.setMargins(a.c((int) R.dimen.search_input_history_keyword_margin_left), a.c((int) R.dimen.search_input_history_keyword_margin_top), a.c((int) R.dimen.search_input_history_keyword_margin_left), a.c((int) R.dimen.search_input_history_keyword_margin_bottom));
            rVar.setLayoutParams(marginLayoutParams);
        } else {
            rVar = view;
        }
        f fVar = ((i) this.b.a.get(i)).a;
        ((r) rVar).setText(fVar.c);
        if (com.ucweb.common.util.i.f.j(fVar.c) == g.a) {
            ((r) rVar).getHistoryUrlIcon().setVisibility(0);
        } else {
            ((r) rVar).getHistoryUrlIcon().setVisibility(8);
        }
        return rVar;
    }
}
