package com.ucpro.feature.bookmarkhis.bookmark.category;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.ui.c.a;
import com.ucpro.ui.f.c;
import com.ucpro.ui.f.e;
import java.util.List;

/* compiled from: ProGuard */
public final class f extends e {
    e b;
    public int c = -1;
    private List<m> d;
    private ImageView e;

    public f(List<m> list, e eVar) {
        this.d = list;
        this.b = eVar;
        list.add(new c(this));
    }

    public final int a() {
        if (this.d != null) {
            return this.d.size();
        }
        return 0;
    }

    public final Object a(int i) {
        return Integer.valueOf(i);
    }

    public final View a(c cVar, int i, View view) {
        boolean z;
        View a;
        m mVar = (m) this.d.get(i);
        if (mVar instanceof c) {
            z = true;
        } else {
            z = false;
        }
        if (view == null) {
            Context context = cVar.getContext();
            if (z) {
                a = a(context);
            } else {
                a = a(context, i);
            }
        } else {
            a = view;
        }
        if (z) {
            return a != this.e ? a(cVar.getContext()) : a;
        } else {
            if (!(a instanceof d)) {
                a = a(cVar.getContext(), i);
            }
            ((d) a).setText(mVar.e);
            if (this.c == i) {
                a.setSelected(true);
                return a;
            }
            a.setSelected(false);
            return a;
        }
    }

    private d a(Context context, int i) {
        d dVar = new d(context, i);
        dVar.setCallback(this.b);
        dVar.getTextView().setSingleLine(true);
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
        marginLayoutParams.setMargins(a.c((int) R.dimen.search_input_history_keyword_margin_left), a.c((int) R.dimen.search_input_history_keyword_margin_top), a.c((int) R.dimen.search_input_history_keyword_margin_left), a.c((int) R.dimen.search_input_history_keyword_margin_bottom));
        dVar.setLayoutParams(marginLayoutParams);
        return dVar;
    }

    private ImageView a(Context context) {
        this.e = new ImageView(context);
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
        marginLayoutParams.setMargins(a.c((int) R.dimen.search_input_history_keyword_margin_left), a.c((int) R.dimen.search_input_history_keyword_margin_top), a.c((int) R.dimen.search_input_history_keyword_margin_left), a.c((int) R.dimen.search_input_history_keyword_margin_bottom));
        this.e.setImageDrawable(a.a("collect_panel_add_btn.svg"));
        this.e.setLayoutParams(marginLayoutParams);
        this.e.setOnClickListener(new a(this));
        return this.e;
    }

    public final void a(List<m> list) {
        this.d = list;
        this.d.add(new c(this));
        c();
    }
}
